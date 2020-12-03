package com.example.springsecuritydemo.dao;

import com.example.springsecuritydemo.ds.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends CrudRepository<Department,Integer> {
}
