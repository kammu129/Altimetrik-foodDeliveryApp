package com.altimetrik.foodfanda.controller;

import com.altimetrik.foodfanda.entity.Customer;
import com.altimetrik.foodfanda.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/api/customer")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        return new ResponseEntity(customerService.create(customer), HttpStatus.CREATED);
    }

    @GetMapping("/api/customer")
    public ResponseEntity<List<Customer>> findAll(){
        return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/api/customer/{id}")
    public ResponseEntity<Customer> findById(@PathVariable UUID id){
        return new ResponseEntity<>(customerService.findById(id),HttpStatus.OK);
    }
    @PutMapping("/api/customer")
    public ResponseEntity<Customer> update(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.update(customer),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/api/customer/location/{id}")
    public ResponseEntity<List<Customer>> findCustomerByLocation(@PathVariable UUID id){
        return new ResponseEntity<>(customerService.findCustomerByLocation(id),HttpStatus.OK);
    }
}
