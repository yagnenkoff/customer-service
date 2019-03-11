package com.yagnenkoff.demo.service.impl;

import com.yagnenkoff.demo.entity.Customer;
import com.yagnenkoff.demo.exception.NotFoundException;
import com.yagnenkoff.demo.repository.CustomerRepository;
import com.yagnenkoff.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) throws NotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return customer.get();
        }
        else{
            throw new NotFoundException("User not found");
        }
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
