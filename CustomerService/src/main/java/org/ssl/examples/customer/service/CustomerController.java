package org.ssl.examples.customer.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ssl.examples.customer.dto.Customer;

@RestController
public class CustomerController {
	
	List<Customer> customers = null;

	@GetMapping
    public List<Customer> getAllCustomers() {
		 customers = Arrays.asList(
					new Customer(1, "Hare Krishna"),
		            new Customer(2, "Jai Jagganatha"));
        return customers;
    }
	 @GetMapping("/{id}")
	    public Customer getCustomerById(@PathVariable int id) {
	        return customers.stream()
	                        .filter(customer -> customer.getId() == id)
	                        .findFirst()
	                        .orElseThrow(IllegalArgumentException::new);
	    }
}
