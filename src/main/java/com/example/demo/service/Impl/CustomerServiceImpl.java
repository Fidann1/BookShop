package com.example.demo.service.Impl;

import com.example.demo.dto.RequestCustomer;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl  implements CustomerService {
    CustomerRepository customerRepository;
   @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void saveCustomer(RequestCustomer customer) {
       Customer customer1=Customer.builder().id(customer.getId()).name(customer.getName()).surname(customer.getSurname()).build();
        customerRepository.save(customer1);
        System.out.println("Operatiion is done successfully");
    }


}
