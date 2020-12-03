package com.example.springsecuritydemo.dao;

import com.example.springsecuritydemo.ds.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
