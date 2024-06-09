package com.example.demo.controller;

import com.example.demo.dto.RequestCustomer;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/customer")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(path="list")
    public List<Customer> list(){
        return customerService.getCustomerList();
    }

    @PostMapping(path="save")

    public void save(@Valid @RequestBody RequestCustomer customer){
         customerService.saveCustomer(customer);
    }
    @GetMapping(path="id/{id}")

    public Customer getById(@PathVariable Long id){
        return customerService.getCustomerById(id).get();
    }






}
