package com.customer.service;

import com.customer.entity.CustomerDTO;
import com.customer.entity.LoginDTO;
import com.customer.entity.RegisterDTO;

public interface CustomerService {
boolean registerCustomer(RegisterDTO registerDTO);
boolean loginCustomer(LoginDTO loginDTO);
CustomerDTO readCustomer(Long phoneNumber);

}
