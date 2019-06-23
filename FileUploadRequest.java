package com.citi.cards.requestBean;

import java.util.LinkedList;
import java.util.List;

public class FileUploadRequest {
	private List<InsurUsers> insurUsersList = new LinkedList();

	public List<InsurUsers> getInsurUsersList() {
		return insurUsersList;
	}

	public void setInsurUsersList(List<InsurUsers> insurUsersList) {
		this.insurUsersList = insurUsersList;
	}
	
	
}
