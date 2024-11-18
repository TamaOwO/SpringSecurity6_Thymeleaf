package com.example.springsecurity6_thymeleaf.controller;

import com.example.springsecurity6_thymeleaf.entiry.Product;
import com.example.springsecurity6_thymeleaf.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private ProductServices service;

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler(){
        System.out.println("Logging user login success...");

        return "index";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler(){
        System.out.println("Login failure handler...");

        return "login";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProduct(Model model, @ModelAttribute("product") Product product){
        model.addAttribute("product", product);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        service.save(product);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProduct(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_product");

        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        service.delete(id);

        return "redirect:/";
    }
}
