package com.yagnenkoff.demo.controller;

import com.yagnenkoff.demo.entity.Customer;
import com.yagnenkoff.demo.exception.NotFoundException;
import com.yagnenkoff.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
public class MainController {

    private final CustomerService customerService;

    @Autowired
    public MainController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value="/customers/add",method= RequestMethod.POST)
    public void addCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Incorrect user input");
        }
        customerService.save(Customer.create(customer.getFirstName(),customer.getLastName()));
    }

    @RequestMapping(value="/customers/delete/{id}",method= RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @RequestMapping(value="/customers/edit",method= RequestMethod.PUT)
    public void etitCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Incorrect user input");
        }
        customerService.save(customer);
    }

    @ResponseBody
    @RequestMapping(value="/customers/get/{id}",method= RequestMethod.GET, produces = "application/json")
    public Customer getCustomer(@PathVariable("id") Long id) throws NotFoundException {
        return customerService.findById(id);
    }

    @ResponseBody
    @RequestMapping(value="/customers/all",method= RequestMethod.GET, produces = "application/json")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }
}
