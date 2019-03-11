package com.yagnenkoff.demo.service;

import com.yagnenkoff.demo.entity.Customer;
import com.yagnenkoff.demo.exception.NotFoundException;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    void deleteById(Long id);

    Customer findById(Long id) throws NotFoundException;

    List<Customer> findAll();
}
