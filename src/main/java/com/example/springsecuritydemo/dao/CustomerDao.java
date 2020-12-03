package com.example.springsecuritydemo.dao;

import com.example.springsecuritydemo.ds.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository<Customer,Integer> {
}
