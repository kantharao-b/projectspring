package com.customer.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.entity.CustomerDTO;
import com.customer.entity.LoginDTO;
import com.customer.entity.RegisterDTO;
import com.customer.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
private CustomerRepository repo;
	@Override
	public boolean registerCustomer(RegisterDTO registerDTO) {
		if(repo.existsById(registerDTO.getPhoneNumber())==true){
			return false;
		}else {
			Customer customer=new Customer();
		BeanUtils.copyProperties(registerDTO, customer);
		repo.save(customer);
		return true;
	}
	}
	@Override
	public boolean loginCustomer(LoginDTO loginDTO) {
		if(repo.loginCheck(loginDTO.getPhoneNumber(),loginDTO.getPassword())==0) {
			return true;
		}else {
			return false;

		}
	}

	@Override
	public CustomerDTO readCustomer(Long phoneNumber) {
		Customer customer = repo.findById(phoneNumber).get();
		CustomerDTO customerDTO=new CustomerDTO();
		BeanUtils.copyProperties(customer, customerDTO);
		System.out.println(customerDTO.getUserName());
		System.out.println(customerDTO.getPhoneNumber());
		return customerDTO;
	}

}
