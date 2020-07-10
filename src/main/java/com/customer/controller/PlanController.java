package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.entity.CustomerDTO;
import com.customer.entity.LoginDTO;
import com.customer.entity.PlanDTO;
import com.customer.entity.RegisterDTO;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/planController")
public class PlanController {
@Autowired
private RestTemplate restTemplate;
@Autowired
private CustomerService service;

@PostMapping("/register")
public boolean addCustomer(@RequestBody RegisterDTO registerDTO) {
	return service.registerCustomer(registerDTO);
}
@PostMapping("/login")
public boolean loginCustomer(@RequestBody LoginDTO loginDTO) {
	return service.loginCustomer(loginDTO);
}
@GetMapping("/view/{phoneNumber}")
public CustomerDTO readDetails(@PathVariable Long phoneNumber) {
	CustomerDTO customerDTO = service.readCustomer(phoneNumber);
	
	PlanDTO planDTO = restTemplate.getForObject("http://localhost:7777/Plan/{planId}", PlanDTO.class,customerDTO.getPlanId());
	customerDTO.setPlanDetails(planDTO);
	
	ParameterizedTypeReference<List<Long>> re=new ParameterizedTypeReference<List<Long>>() {};
	ResponseEntity<List<Long>> responseEntity = restTemplate.exchange("http://localhost:6666/Friend/{phoneNumber}", HttpMethod.GET, null, re, phoneNumber);
	List<Long> list = responseEntity.getBody();
	customerDTO.setFriendsNumbers(list);
	return customerDTO;
}
}
