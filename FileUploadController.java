package com.citi.cards.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citi.cards.aggregator.FileUploadAggregator;
import com.citi.cards.requestBean.FileUploadRequest;

@RestController
@RequestMapping
public class FileUploadController {
	private static final String FILE_UPLOAD_REQUEST_URI = "/private/v1/load/insurance/users"; 
	
	@Autowired
	FileUploadAggregator fileUploadAggregator;
	
	@RequestMapping(value = FILE_UPLOAD_REQUEST_URI,
			method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void uploadData(
						@PathVariable String ccId,
						@RequestBody FileUploadRequest fileUploadRequest,
						HttpServletRequest request, @RequestHeader Map<String,String> headers ) {	
	
		try {
			fileUploadAggregator.processFileUpload( fileUploadRequest );
		} catch (Exception e) {
		}
	
	}

}

