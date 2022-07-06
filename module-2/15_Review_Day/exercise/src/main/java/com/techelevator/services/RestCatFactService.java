package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	private static final String API_BASE_URL = "https://cat-data.netlify.app/api";
	private final RestTemplate restTemplate = new RestTemplate();


	@Override
	public CatFact rdmFact() {
		return restTemplate.getForObject(API_BASE_URL + "/facts/random", CatFact.class);
	}

}
