package com.citi.cards.requestBean;

public class InsurUsers {
	private String userId;
	private String lastName;
	private String firstName;
	private Integer version;
	private String company;
	
	public InsurUsers(){};
	
	public InsurUsers(String userId, String firstName, String lastName, Integer version, String company) {
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.version = version;
		this.company = company;
	};

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
