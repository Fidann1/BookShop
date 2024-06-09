package com.example.demo.service;

import com.example.demo.dto.RequestCustomer;
import com.example.demo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

    public List<Customer> getCustomerList();
    public Optional<Customer> getCustomerById(Long id);
    public void saveCustomer(RequestCustomer customer);




}
