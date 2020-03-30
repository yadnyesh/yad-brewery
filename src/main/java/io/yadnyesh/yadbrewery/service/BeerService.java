package io.yadnyesh.yadbrewery.service;

import io.yadnyesh.yadbrewery.model.BeerDto;

import java.util.UUID;

public interface BeerService {
	
	BeerDto getBeerById(UUID beerId);
}
