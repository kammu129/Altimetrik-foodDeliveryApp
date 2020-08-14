package com.altimetrik.foodfanda.service;

import com.altimetrik.foodfanda.entity.Customer;
import com.altimetrik.foodfanda.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer create(Customer customer){
         return customerRepository.save(customer);
    }
    public List<Customer> findAll(){
        final List<Customer>customers=new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer findById(final UUID uuid){
        Optional<Customer> customerOptional = customerRepository.findById(uuid);
        return customerOptional.orElseThrow(()->new RuntimeException("Customer Not Found"));
    }

    public Customer update(final Customer customer){
        this.findById(customer.getId());
        return customerRepository.save(customer);
    }


    public List<Customer> findCustomerByLocation(final UUID uuid ){
        return customerRepository.findCustomerByLocation_uuid(uuid);
    }

    public void delete(Customer customer){
        final Customer customerById = this.findById(customer.getId());
        customerRepository.delete(customerById);
    }
}
