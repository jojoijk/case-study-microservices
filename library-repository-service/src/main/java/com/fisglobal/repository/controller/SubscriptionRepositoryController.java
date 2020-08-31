package com.fisglobal.repository.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.repository.data.SubscriptionRepository;
import com.fisglobal.repository.entity.Subscription;
import com.fisglobal.repository.exception.GenericObjectNotFoundException;

@RestController
@RequestMapping("/repository/subscription/")
public class SubscriptionRepositoryController {

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@RequestMapping(value="retrieveSubscriptions", method = RequestMethod.GET)
	public List<Subscription> retrieveSubscriptions(){
		List<Subscription> subscriptionList = subscriptionRepository.findAll();
		return subscriptionList;
	}
	
	@RequestMapping(value="search/{id}", method = RequestMethod.GET)
	public ResponseEntity<Subscription> getSubscriptionById(@PathVariable("id") String id){
		Optional<Subscription> subscription = subscriptionRepository.findById(Long.valueOf(id));
		if (!subscription.isPresent())
			throw new GenericObjectNotFoundException("No subscription available with ID - " + id);
		else
			return new ResponseEntity<Subscription>(subscription.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value="addSubscription", method = RequestMethod.POST)
	public Subscription addSubscription(@RequestBody final Subscription subscription){
		try {
				return subscriptionRepository.save(subscription);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			} 
	}
	
	@RequestMapping(value="updateSubscription", method = RequestMethod.POST)
	public Subscription updateSubscription(@RequestBody final Subscription subscription){
		try {
				return subscriptionRepository.saveAndFlush(subscription);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			} 
	}
}
