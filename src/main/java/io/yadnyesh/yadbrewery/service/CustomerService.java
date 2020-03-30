package io.yadnyesh.yadbrewery.service;

import io.yadnyesh.yadbrewery.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
	CustomerDTO getCustomerById(UUID customerId);
}
