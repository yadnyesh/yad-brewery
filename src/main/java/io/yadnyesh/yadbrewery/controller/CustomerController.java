package io.yadnyesh.yadbrewery.controller;

import io.yadnyesh.yadbrewery.model.BeerDto;
import io.yadnyesh.yadbrewery.model.CustomerDTO;
import io.yadnyesh.yadbrewery.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerDTO> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		CustomerDTO savedCustomerDto = customerService.saveNewCustomer(customerDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer/" + savedCustomerDto.getId().toString());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity updateBeer(@PathVariable UUID customerId, @Valid @RequestBody CustomerDTO customerDTO) {
		customerService.updateCustomer(customerId, customerDTO);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeerById(@PathVariable UUID customerId) {
		customerService.deleteById(customerId);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
		List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
		
		e.getConstraintViolations().forEach(constraintViolation -> {
			errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
}
