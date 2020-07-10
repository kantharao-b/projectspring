package com.customer.entity;

public class LoginDTO implements java.io.Serializable{
private Long phoneNumber;
private String password;
public Long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(Long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
