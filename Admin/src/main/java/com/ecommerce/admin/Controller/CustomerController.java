package com.ecommerce.admin.Controller;

import com.ecommerce.library.Repository.UserRepos.CustomerRepository;
import com.ecommerce.library.Service.CustomerService;
import com.ecommerce.library.ProductsService.TaskOfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/admin/customers")
@Controller
public class CustomerController {

    CustomerRepository customerRepository;

    CustomerService customerService;
    TaskOfferService taskOfferService;

    public CustomerController(CustomerRepository customerRepository,
                              CustomerService customerService, TaskOfferService taskOfferService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.taskOfferService = taskOfferService;
    }

    @GetMapping
    public String listAllCustomers(@ModelAttribute("info") String info,  Model model){
        if(info!=null && !info.isEmpty()) model.addAttribute("info", info);
        model.addAttribute("customers", customerRepository.findAll());
        return "/PostAuth/customers";
    }

    @PostMapping("/block/{id}")
    public String blockUser(@PathVariable("id") Long id){

        if(customerService.existsById(id))
            customerService.blockCustomer(id);

        return "redirect:/admin/customers";
    }

    @PostMapping("/unblock/{id}")
    public String unblockUser(@PathVariable("id") Long id){
        if(customerService.existsById(id)){
            customerService.unBlockCustomer(id);
        }
        return "redirect:/admin/customers";
    }

    @PostMapping("/enable-referral")
    public String enableReferral(RedirectAttributes redirectAttributes){
        taskOfferService.enabledOrDisable("REFERRAL", true);
        redirectAttributes.addAttribute("info", "Referral Offer has been enabled for your website!");
        return "redirect:/admin/customers";
    }
    @PostMapping("/disable-referral")
    public String disableReferral(RedirectAttributes redirectAttributes){
        taskOfferService.enabledOrDisable("REFERRAL", false);
        redirectAttributes.addAttribute("info", "Referral Offer has been disabled for your website!");
        return "redirect:/admin/customers";
    }


}
