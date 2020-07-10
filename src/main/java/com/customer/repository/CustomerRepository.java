package com.customer.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value="select count(*) from customer where phone_no=? and password=?",nativeQuery=true)
	Integer loginCheck(Long phoneNumber,String password);
}
