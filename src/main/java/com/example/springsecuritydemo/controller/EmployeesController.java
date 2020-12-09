package com.example.springsecuritydemo.controller;


import com.example.springsecuritydemo.dao.EmployeeDao;
import com.example.springsecuritydemo.ds.Employee;
import com.example.springsecuritydemo.security.annotation.employees.IsEmployeeCreate;
import com.example.springsecuritydemo.security.annotation.employees.IsEmployeeDelete;
import com.example.springsecuritydemo.security.annotation.employees.IsEmployeeRead;
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
public class EmployeesController {
    @Autowired
    private EmployeeDao employeeDao;

    @IsEmployeeRead
    @GetMapping("/employees")
    public ModelAndView index(){
        return new ModelAndView("employees","employees",employeeDao.findAll());
    }
    @IsEmployeeCreate
    @GetMapping("/employees/create")
    public ModelAndView create(){
        return new ModelAndView("employee-create","employee",new Employee());
    }

    @IsEmployeeCreate
    @PostMapping("/employees/create")
    public String create(@ModelAttribute @Valid Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "employee-create";
        }
        else{
            employeeDao.save(employee);
            return "redirect:/employees";
        }
    }
    @IsEmployeeDelete
    @GetMapping("/employees/delete/{id}")
    public String delete(@PathVariable Integer id){
        employeeDao.deleteById(id);
        return "redirect:/employees";
    }
}
