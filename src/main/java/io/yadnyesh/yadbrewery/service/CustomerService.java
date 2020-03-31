package io.yadnyesh.yadbrewery.service;

import io.yadnyesh.yadbrewery.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
	
	void deleteById(UUID customerId);
	CustomerDTO getCustomerById(UUID customerId);
	CustomerDTO saveNewCustomer(CustomerDTO customerDTO);
	void updateCustomer(UUID customerId, CustomerDTO customerDTO);
}
