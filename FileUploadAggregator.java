package com.citi.cards.aggregator;

import java.io.FileWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.citi.cards.requestBean.FileUploadRequest;
import com.citi.cards.requestBean.InsurUsers;

@Component
public class FileUploadAggregator {

	private static final String FILE_UPLOAD_PATH = "C:\\test\\";

	public void processFileUpload( FileUploadRequest fileUploadRequest) {
		try {

			Comparator comparator = Comparator.comparing(InsurUsers::getLastName)
												.thenComparing(InsurUsers::getFirstName);
	
			Map<String, List<InsurUsers>> ulist = (Map<String, List<InsurUsers>>) fileUploadRequest.getInsurUsersList().stream()
																									.sorted(comparator)
																									.collect(Collectors.groupingBy(InsurUsers::getCompany));

			for(Map.Entry<String, List<InsurUsers>> map: ulist.entrySet()) {
				FileWriter fileWriter = new FileWriter(FILE_UPLOAD_PATH + map.getKey() + ".csv");
				for(InsurUsers iu : map.getValue()) {
					fileWriter.append(iu.getUserId() +","+ iu.getFirstName()+","+ iu.getLastName()+","+iu.getVersion()+","+iu.getCompany()+"\n");
				}
				fileWriter.flush();
				fileWriter.close();
			}
			
		} catch(Exception e) {}		
	}
	
}

