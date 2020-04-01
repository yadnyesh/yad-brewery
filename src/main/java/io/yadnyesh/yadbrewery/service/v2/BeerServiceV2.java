package io.yadnyesh.yadbrewery.service.v2;

import io.yadnyesh.yadbrewery.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
	
	void deleteById(UUID beerId);
	BeerDtoV2 getBeerById(UUID beerId);
	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);
	void updateBeer(UUID beerId, BeerDtoV2 beerDto);
}
