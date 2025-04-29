package com.webaaplication.webApplication.controller;

import com.webaaplication.webApplication.entity.Customer;
import com.webaaplication.webApplication.service.customerService;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private final customerService customerservice;

    public HomeController(customerService customerservice) {
        this.customerservice = customerservice;
    }


    @GetMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "") String name,
                       Model model) {

        List<Customer> customerList = customerservice.getAll();
        model.addAttribute("customerList", customerList);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") Customer customer,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }

        customerservice.save(customer);
        redirectAttributes.addFlashAttribute(
                "message",
                "Customer created successfully"
        );
        return "redirect:/";
    }

    @GetMapping("customer/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Customer customer = customerservice.findById(id).orElse(null);
        model.addAttribute("customer", customer);
        return "create";
    }

    @GetMapping("customer/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        customerservice.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Customer deleted successfully");
        return "redirect:/";
    }

    @GetMapping("customer/{id}")
    public String show(@PathVariable long id, Model model){
        customerservice.findById(id)
                .ifPresent(customer -> model.addAttribute("customer", customer));
        return "show";
    }

}
