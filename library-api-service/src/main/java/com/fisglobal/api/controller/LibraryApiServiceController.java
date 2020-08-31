package com.fisglobal.api.controller;

import java.beans.Transient;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fisglobal.api.domain.BookVO;
import com.fisglobal.api.domain.SubscriptionVO;
import com.fisglobal.api.exception.GenericUnprocessableEntityException;
import com.fisglobal.api.exception.LibraryApiGenericException;
import com.fisglobal.api.proxy.LibraryRepositoryServiceProxy;
import com.fisglobal.api.service.LibraryApiService;

@RestController
public class LibraryApiServiceController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	 @Autowired 
	 private LibraryRepositoryServiceProxy proxy;
	 
	 @Autowired 
	 private LibraryApiService libraryService;
	 
	@GetMapping("/library-api-service/books")
	public List<BookVO> books() {
		
		ResponseEntity<BookVO[]> response = new RestTemplate()
				.getForEntity("http://localhost:8001/repository/book/retrieveAvailableBooks",BookVO[].class);
		BookVO[] list = response.getBody();
		return ( list == null ? Collections.emptyList() :(List<BookVO>)Arrays.asList(list));
	}
	
	@GetMapping("/library-api-service-feign/books") 
	public List<BookVO> booksFeign(){
		return libraryService.fetchBooksUsingFeign();
	}
	
	@GetMapping("/library-api-service/subscriptions") 
	public List<SubscriptionVO> subscriptions(){
		return libraryService.fetchSubscriptions();
	
	}
	
	@PostMapping("/library-api-service/subscriptions") 
	public SubscriptionVO addNewSubscription(@RequestBody final SubscriptionVO subscription){
		return libraryService.addNewSubscription(subscription);
	}
	
	@PostMapping("/library-api-service/returnSubscriptions") 
	public SubscriptionVO returnSubscriptions(@RequestBody final SubscriptionVO subscription){
		return libraryService.returnSubscriptions(subscription);
	}
	 
	

}
