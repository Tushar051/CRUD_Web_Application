package com.webaaplication.webApplication.service;

import com.webaaplication.webApplication.entity.Customer;
import com.webaaplication.webApplication.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class customerService {

    @Autowired
    private final customerRepository customerrepository;


    public customerService(customerRepository customerrepository) {
        this.customerrepository = customerrepository;
    }

    public List<Customer> getAll(){
        return (List<Customer>)  customerrepository.findAll();
    }

    public Optional<Customer> findById(Long id){
        return customerrepository.findById(id);
    }

    public Customer save(Customer customer){
        return customerrepository.save(customer);
    }

    public void deleteById(Long id){
        customerrepository.deleteById(id);
    }
}
