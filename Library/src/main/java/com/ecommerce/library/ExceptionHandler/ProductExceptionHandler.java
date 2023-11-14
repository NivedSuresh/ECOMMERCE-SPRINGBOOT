package com.ecommerce.library.ExceptionHandler;

import com.ecommerce.library.Exceptions.UnableToMakeOrderException;
import com.ecommerce.library.Exceptions.CannotDeleteCategoryException;
import com.ecommerce.library.Exceptions.ImageProcessException;
import com.ecommerce.library.Exceptions.InvalidProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class ProductExceptionHandler {




    @GetMapping("/errorView")
    public String errorView(Model model, String message){
        model.addAttribute("errorMsg", message);
        return "exceptionProducts";
    }

    @ExceptionHandler(ImageProcessException.class)
    public String imageProcessExceptionHandler(ImageProcessException e, Model model){
        return errorView(model, e.getUserMessage());
    }


    @ExceptionHandler(InvalidProductException.class)
    public String InvalidProductExceptionHandler(InvalidProductException e, Model model){
        return errorView(model, e.getViewMessage());
    }

    @ExceptionHandler(UnableToMakeOrderException.class)
    public String UnableToMakeOrderExceptionHandler(UnableToMakeOrderException e, Model model){
        return errorView(model, e.getViewMessage());
    }

    @ExceptionHandler(CannotDeleteCategoryException.class)
    public String CannotDeleteCategoryExceptionHandler(CannotDeleteCategoryException c, Model model){
        return errorView(model, c.getMessage());
    }



}
