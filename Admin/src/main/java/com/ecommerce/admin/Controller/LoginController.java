package com.ecommerce.admin.Controller;

import com.ecommerce.library.Model.Utils.Token;
import com.ecommerce.library.Repository.UtilRepos.OtpRepo;
import com.ecommerce.library.Service.AdminService;
import com.ecommerce.library.Service.OtpService;
import com.ecommerce.library.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class LoginController {

    OtpRepo otpRepo;
    OtpService otpService;

    AdminService adminService;

    TokenService tokenService;

    @Autowired
    public LoginController(OtpRepo otpRepo, OtpService otpService,
                           AdminService adminService,
                           TokenService tokenService) {
        this.otpRepo = otpRepo;
        this.otpService = otpService;
        this.adminService = adminService;
        this.tokenService = tokenService;
    }

    @GetMapping("/login")
    public String loginPage(Model model, @RequestParam(value = "username", required = false) String username){
        if(username==null){
            username = "";
        }
        if(model.containsAttribute("info")){
            return "loginView";
        }
        model.addAttribute("info", username);
        model.addAttribute("error",null);
        return "loginView";
    }

    @PostMapping("/send-otp")
    public String verifyEmail(@RequestParam(value = "username", required = false)
                                  String username, Model model){
        model.addAttribute("username",username);
        if(adminService.adminExists(username)){
            otpService.generateOtp(username);
            model.addAttribute("info", "Otp sent to "+username);
            return loginPage(model, username);
        }
        return "redirect:/admin/login?invalid";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam("username") String username, Model model){
        if(username!=null && adminService.adminExists(username)){
            model.addAttribute("username", username);
            return sendTokenForgotPassword(username, model);
        }
        return "/forgot-password";
    }

    @PostMapping("/send-token")
    public String sendTokenForgotPassword(@RequestParam("username") String username, Model model){
        if(username!=null && adminService.adminExists(username)){
            tokenService.generateTokenForPasswordReset(username, true);
            model.addAttribute("username", username);
            model.addAttribute("info", "Token to reset password has been sent to "+username);
            return loginPage(model, "");
        }
        return "redirect:/admin/forgot-password?invalid-user";
    }


    @GetMapping("/reset-password")
    public String newPasswordPage(@RequestParam("token") String tokenCode, Model model){
        Token serverToken = tokenService.findByToken(tokenCode);
        if(tokenService.validateToken(serverToken)){
            model.addAttribute("token", tokenCode);
            return "/reset-password";
        }
        return "redirect:/admin/login?error";
    }

    @Transactional
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("password") String password,
                                @RequestParam("confirmPassword") String confirmPassword,
                                @RequestParam("token") String token,
                                Model model){

        if (!Objects.equals(password, confirmPassword)){
            model.addAttribute("password-unmatch", "Passwords don't match");
            return newPasswordPage(token, model);
        }
        String username = tokenService.findByToken(token).getUsername();
        adminService.changePassword(password, username);
        model.addAttribute("info", "Password was reset");
        return loginPage(model, username);
    }

}
