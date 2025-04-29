package com.webaaplication.webApplication.repository;

import com.webaaplication.webApplication.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface customerRepository extends CrudRepository<Customer, Long> {

}
