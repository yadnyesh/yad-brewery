package io.yadnyesh.yadbrewery.controller.v2;

import io.yadnyesh.yadbrewery.model.v2.BeerDtoV2;
import io.yadnyesh.yadbrewery.service.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
	
	private BeerServiceV2 beerServiceV2;
	
	public BeerControllerV2(BeerServiceV2 beerServiceV2) {
		this.beerServiceV2 = beerServiceV2;
	}
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDtoV2> addBeer(@RequestBody BeerDtoV2 beerDto) {
		BeerDtoV2 savedBeerDto = beerServiceV2.saveNewBeer(beerDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/" + savedBeerDto.getId().toString());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity updateBeer(@PathVariable UUID beerId, @RequestBody BeerDtoV2 beerDto) {
		beerServiceV2.updateBeer(beerId, beerDto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeerById(@PathVariable UUID beerId) {
		beerServiceV2.deleteById(beerId);
	}
	
}
