/**
 * 
 */
package com.atm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atm.model.AtmResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This controller class is used to create/maintain all api's which are using
 * for ATM application.
 * 
 * 
 * @author Ramanjaneya Reddy S
 *
 */

@RestController
public class AtmController {

	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private ObjectMapper mapper;
	
	
	private static final Logger log = LogManager.getLogger(AtmController.class);

	final String url = "https://www.ing.nl/api/locator/atms/";

	@GetMapping("/getallatms")
	public AtmResponse[] getAllAtms() throws URISyntaxException, JsonMappingException, JsonProcessingException {
		log.info("Entering into getallatms");
		URI uri = new URI(url);
		ResponseEntity<String> atmResponseEntity = restTemplate.getForEntity(uri, String.class);
		AtmResponse[] atmReponse = mapper.readValue(atmResponseEntity.getBody().substring(6), AtmResponse[].class);
		log.info("Number of ATMs: "+ atmReponse.length);
		return atmReponse;
	}

	@GetMapping("/getatmsbycity")
	public List<AtmResponse> getAtmsByCity(@RequestParam String city)
			throws URISyntaxException, JsonMappingException, JsonProcessingException {
		log.info("Entering into getatmsbycity");
		URI uri = new URI(url);
		ResponseEntity<String> atmResponseEntity = restTemplate.getForEntity(uri, String.class);
		AtmResponse[] atmResponse = mapper.readValue(atmResponseEntity.getBody().substring(6), AtmResponse[].class);
		Stream<AtmResponse> atmResponseStream = Arrays.stream(atmResponse);
		List<AtmResponse> atmResponseList = atmResponseStream.filter(atm -> atm.getAddress().getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
		log.info("Number of ATMs: "+ atmResponseList.size() + " in city "+city);
		return atmResponseList;
	}

}
