package io.yadnyesh.yadbrewery.mappers;

import io.yadnyesh.yadbrewery.model.Customer;
import io.yadnyesh.yadbrewery.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
	
	Customer customerDtoToCustomer(CustomerDto customerDto);
	CustomerDto customerToCustomerDto(Customer customer);
	
}
