package com.altimetrik.foodfanda.repository;

import com.altimetrik.foodfanda.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    List<Customer> findCustomerByLocation_uuid(UUID location);
}
