package io.yadnyesh.yadbrewery.service;

import io.yadnyesh.yadbrewery.model.BeerDto;

import java.util.UUID;

public interface BeerService {
	
	void deleteById(UUID beerId);
	BeerDto getBeerById(UUID beerId);
	BeerDto saveNewBeer(BeerDto beerDto);
	void updateBeer(UUID beerId, BeerDto beerDto);
}
