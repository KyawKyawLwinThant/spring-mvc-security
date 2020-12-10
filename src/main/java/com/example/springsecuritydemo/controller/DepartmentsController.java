package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.dao.DepartmentDao;
import com.example.springsecuritydemo.ds.Department;
import com.example.springsecuritydemo.security.annotation.customer.IsCustomerDelete;
import com.example.springsecuritydemo.security.annotation.departments.IsDepartmentCreate;
import com.example.springsecuritydemo.security.annotation.departments.IsDepartmentDelete;
import com.example.springsecuritydemo.security.annotation.departments.IsDepartmentRead;
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
public class DepartmentsController {
    @Autowired
    private DepartmentDao departmentDao;

    @IsDepartmentRead
    @GetMapping("/departments")
    public ModelAndView index(){
        return new ModelAndView("departments","departments",departmentDao.findAll());
    }

    @IsDepartmentCreate
    @GetMapping("/departments/create")
    public ModelAndView create(){
        return new ModelAndView("department-create","department",new Department());
    }

    @IsDepartmentCreate
    @PostMapping("/departments/create")
    public String create(@ModelAttribute @Valid Department department, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "department-create";
        }
        else{
            departmentDao.save(department);
            return "redirect:/departments";
        }
    }
    @IsDepartmentDelete
    @GetMapping("/departments/delete/{id}")
    public String delete(@PathVariable Integer id){
        departmentDao.deleteById(id);
        return "redirect:/departments";
    }
}
