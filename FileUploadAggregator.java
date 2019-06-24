package com.citi.cards.aggregator;

import java.io.FileWriter;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
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
			Comparator comparator1 = Comparator.comparing(InsurUsers::getUserId)
								.thenComparing(InsurUsers::getVersion)
								.reversed();

			Map<String, List<InsurUsers>> ulist = (Map<String, List<InsurUsers>>) fileUploadRequest.getInsurUsersList().stream()
													.sorted(comparator1)
													.collect(Collectors.groupingBy(InsurUsers::getCompany));

			Comparator comparator = Comparator.comparing(InsurUsers::getLastName)
								.thenComparing(InsurUsers::getFirstName);

			for(Map.Entry<String, List<InsurUsers>> map: ulist.entrySet()) {
				String tempUserId = "";
				ListIterator<InsurUsers> listIterator = map.getValue().listIterator(); 
				while(listIterator.hasNext()) {
					InsurUsers iu = listIterator.next();
					if(tempUserId.equals(iu.getUserId())) {
						listIterator.remove();
					}
					tempUserId = iu.getUserId();
				}

				map.getValue().stream().sorted(comparator);
			}

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

