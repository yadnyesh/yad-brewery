package io.yadnyesh.yadbrewery.service.v2;

import io.yadnyesh.yadbrewery.model.v2.BeerDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
	
	@Override
	public void deleteById(UUID beerId) {
	
	}
	
	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		return null;
	}
	
	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
		return null;
	}
	
	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
	
	}
}
