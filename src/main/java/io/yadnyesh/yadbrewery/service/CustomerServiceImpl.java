package io.yadnyesh.yadbrewery.service;

import io.yadnyesh.yadbrewery.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Override
	public void deleteById(UUID customerId) {
		log.debug("Deleting a customer...." + customerId);
	}
	
	@Override
	public CustomerDTO getCustomerById(UUID customerId) {
		return CustomerDTO.builder()
				.id(UUID.randomUUID())
				.customerName("Yadnyesh")
				.build();
	}
	
	@Override
	public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
		return null;
	}
	
	@Override
	public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
		log.debug("Updating a customer...." + customerId);
	}
}
