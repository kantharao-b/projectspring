package com.customer.entity;

import java.util.List;

public class CustomerDTO implements java.io.Serializable {
	private Long phoneNumber;
	private String userName;
	private String email;
	private String planId;
	private PlanDTO planDetails;
	private List<Long> friendsNumbers;
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public PlanDTO getPlanDetails() {
		return planDetails;
	}
	public void setPlanDetails(PlanDTO planDetails) {
		this.planDetails = planDetails;
	}
	public List<Long> getFriendsNumbers() {
		return friendsNumbers;
	}
	public void setFriendsNumbers(List<Long> friendsNumbers) {
		this.friendsNumbers = friendsNumbers;
	}
	
}
