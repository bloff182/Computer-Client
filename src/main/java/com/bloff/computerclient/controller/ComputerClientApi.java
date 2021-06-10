package com.bloff.computerclient.controller;

import java.util.Map;
import java.util.stream.Stream;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bloff.computerclient.model.Computer;

@RestController
public class ComputerClientApi {

	// when a datas are keep in list
	@GetMapping("/getDataFromControllerApiTest")
	public Computer[] sentDataFromControllerApiTest() {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Computer[]> responseEntity = restTemplate.exchange(
				"http://localhost:8080/get", 
				HttpMethod.GET,
				null, Computer[].class);

		Stream.of(responseEntity).forEach(System.out::println);
		return responseEntity.getBody();
	}

	// datas are keep in map
	@GetMapping("/getDataFromMapCollection")
	public Map<Integer, Computer> sentData() {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Map<Integer, Computer>> responseEntity = restTemplate.exchange(
				"http://localhost:8080/api/computers", HttpMethod.GET, null,
				new ParameterizedTypeReference<Map<Integer, Computer>>() {
				});

		Map<Integer, Computer> body = responseEntity.getBody();
		return body;
	}

	@GetMapping("/deleteDataFromMapCollection/{id}")
	public Boolean deleteData(@PathVariable Long id) {
		
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
				"http://localhost:8080/api/computers/" + id,
				HttpMethod.DELETE, 
				null, 
				Boolean.class);
		
		return responseEntity.getBody();
	}

//	@GetMapping("/save")
	@GetMapping("/save/{id}/{ddrType}/{mhz}/{memorySize}")
	public Computer saveComputer(@PathVariable Long id, @PathVariable String ddrType, @PathVariable Long mhz, @PathVariable Integer memorySize) {
//	public Computer saveComputer() {

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		
		String objToSent = "{\n"+
				"\"id\":"+ id +",\n" +
				"\"ddrType\":\"" + ddrType +"\",\n" +
				"\"mhz\":" + mhz + ",\n" +
				"\"memorySize\":" + memorySize + "\n" +
				"}";
		
		HttpEntity entity = new HttpEntity(objToSent, headers);
		
		ResponseEntity<Computer> computerEntity = restTemplate.exchange("http://localhost:8080/api/computers",
				HttpMethod.POST,
				entity,
				Computer.class);
		
		return computerEntity.getBody();
	}

}
