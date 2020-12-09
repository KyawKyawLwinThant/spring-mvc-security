package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.dao.CustomerDao;
import com.example.springsecuritydemo.ds.Customer;
import com.example.springsecuritydemo.security.annotation.customer.IsCustomerCreate;
import com.example.springsecuritydemo.security.annotation.customer.IsCustomerDelete;
import com.example.springsecuritydemo.security.annotation.customer.IsCustomerRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    @IsCustomerRead
    @GetMapping("/customers")
    public ModelAndView index(){
        return new ModelAndView("customers","customers",customerDao.findAll());
    }

    @IsCustomerCreate
    @GetMapping("/customers/create")
    public ModelAndView create(){
        return new ModelAndView("customer-create","customer",new Customer());
    }

    @IsCustomerCreate
    @PostMapping("/customers/create")
    public String create(@ModelAttribute @Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "customer-create";
        }
        else {
            customerDao.save(customer);
            return "redirect:/customers";
        }
    }

    @IsCustomerDelete
    @GetMapping("/customers/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerDao.deleteById(id);
        return "redirect:/customers";
    }
}
