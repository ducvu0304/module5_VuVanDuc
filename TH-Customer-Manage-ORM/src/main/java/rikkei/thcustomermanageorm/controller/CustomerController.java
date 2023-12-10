package rikkei.thcustomermanageorm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rikkei.thcustomermanageorm.dto.RegisterForm;
import rikkei.thcustomermanageorm.model.Customer;
import rikkei.thcustomermanageorm.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping({"/", "/home"})
    public String displayCustomerPage(Model model) {

        List<Customer> customers = customerService.getCustomerList();

        model.addAttribute("customers", customers);
        model.addAttribute("registerForm", new Customer());
        model.addAttribute("editForm", false);

        return "customer-page";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String doRegisterForm(@ModelAttribute("registerForm") Customer Customer, Model model) {
        customerService.save(Customer);

        return "redirect:/home";
    }

    @RequestMapping(value = "/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {
        System.out.println(customerId);
        boolean isDeletion = customerService.deleteCustomerById(customerId);

        if(isDeletion) {
            return "redirect:/home";
        }

        return "redirect:/home";
    }

    @RequestMapping(value = "/edit")
    public String showEditForm(@RequestParam("customerId") int customerId, Model model) {
        List<Customer> customers = customerService.getCustomerList();

        Customer customer = customerService.findCustomerById(customerId);

        model.addAttribute("customers", customers);
        model.addAttribute("registerForm", customer);
        model.addAttribute("editForm", true);

        return "customer-page";
    }

}
