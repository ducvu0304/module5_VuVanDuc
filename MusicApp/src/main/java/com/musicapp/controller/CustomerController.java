package com.musicapp.controller;

import com.musicapp.model.Customer;
import com.musicapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"/", "/home"})
    public String displayHomePage(Model model) {
        model.addAttribute("customers", customerService.findAlCustomers());

        return "home";
    }

    @GetMapping("/create-customer")
    public String displayForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("form","register");
        return "form";
    }

    @GetMapping("/edit-customer")
    public String editFormModel (@RequestParam int customerId, Model model) {
        Optional<Customer>  customer = customerService.findCustomerById(customerId);
        if(customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            model.addAttribute("form","edit");
        }
        return "form";
    }

    @PostMapping("/save")
    public String doForm(@ModelAttribute Customer customer) {
        System.out.println(customer);

//        customerService.save(customer);
        return "redirect:/home";
    }

    @GetMapping("/account")
    public String deleteAccountById(@RequestParam(name = "id") int customerId) {
        customerService.deleteCustomerById(customerId);

        return "redirect:/home";
    }
}
