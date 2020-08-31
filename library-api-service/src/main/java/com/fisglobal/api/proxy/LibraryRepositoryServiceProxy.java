package com.fisglobal.api.proxy;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fisglobal.api.domain.BookVO;
import com.fisglobal.api.domain.SubscriptionVO;

//@FeignClient(name="library-repository-service",url="localhost:8001") //using hardcoded url to connect to particular exchange service
//@FeignClient(name="library-repository-service") // removed hardcoded url to use ribbon
@RibbonClient(name="library-repository-service")
@FeignClient(name="library-gateway-service")
public interface LibraryRepositoryServiceProxy {
	 @RequestMapping("/library-repository-service/repository/book/retrieveAvailableBooks")
     public List<BookVO> retrieveAvailableBooks();
	 
	 @RequestMapping("/library-repository-service/repository/book/search/{id}")
     public Optional<BookVO> getBookById(@PathVariable("id") Long id);
	 
	 @PostMapping("/library-repository-service/repository/book/lend/{id}")
     public Integer lendBookById(@PathVariable("id") String id);
	 
	 @PostMapping("/library-repository-service/repository/book/return/{id}")
     public Integer returnBookById(@PathVariable("id") String id);
     
	 @RequestMapping("/library-repository-service/repository/subscription/retrieveSubscriptions")
     public List<SubscriptionVO> retrieveSubscriptions();
	 
	 @RequestMapping("/library-repository-service/repository/subscription/search/{id}")
     public Optional<SubscriptionVO> getSubscriptionById(@PathVariable("id") Long id);
     
	 @RequestMapping("/library-repository-service/repository/subscription/addSubscription")
     public SubscriptionVO addSubscription(@RequestBody SubscriptionVO subscription);
	 
	 @RequestMapping("/library-repository-service/repository/subscription/updateSubscription")
     public SubscriptionVO updateSubscription(@RequestBody SubscriptionVO subscription);
}
