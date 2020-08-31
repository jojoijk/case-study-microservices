package com.fisglobal.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.fisglobal.api.domain.BookVO;
import com.fisglobal.api.domain.SubscriptionVO;
import com.fisglobal.api.exception.GenericUnprocessableEntityException;
import com.fisglobal.api.exception.LibraryApiGenericException;
import com.fisglobal.api.proxy.LibraryRepositoryServiceProxy;

@Service
public class LibraryApiService {

	 @Autowired 
	 private LibraryRepositoryServiceProxy proxy;
	 
	 public List<SubscriptionVO> fetchSubscriptions(){
		 List<SubscriptionVO> response = proxy.retrieveSubscriptions();
		 return response;
	 }
	 
	 public List<BookVO> fetchBooksUsingFeign(){
		 List<BookVO> response = proxy.retrieveAvailableBooks(); 
		 return response;
	 }
	 
	 @Transactional
	 public SubscriptionVO returnSubscriptions(SubscriptionVO subscription) {
		 Optional<BookVO> book = proxy.getBookById(subscription.getBOOK_ID()); 
			if (book.isPresent()) {
				Optional<SubscriptionVO> subscriptionVO = proxy.getSubscriptionById(subscription.getID());
				if(!subscriptionVO.isPresent()){
					throw new GenericUnprocessableEntityException("No subscription available for this book - " + subscription.getBOOK_ID());
				}else {
					if(null == subscription.getDATE_RETURNED() || subscription.getDATE_RETURNED().toString().isEmpty())
					{
						throw new LibraryApiGenericException("No return date is specified in the request.");
					}else {
						subscriptionVO.get().setDATE_RETURNED(subscription.getDATE_RETURNED());
						SubscriptionVO response = proxy.updateSubscription(subscriptionVO.get());
						proxy.returnBookById(Long.toString(book.get().getId()));
						return response;
					}
				}
			}
			return subscription;
	 }
	 
	 @Transactional
	 public SubscriptionVO addNewSubscription(SubscriptionVO subscription){
		 Optional<BookVO> book = proxy.getBookById(subscription.getBOOK_ID()); 
			if (book.isPresent()) {
				int avaialableCopies = book.get().getAVAILABLE_COPIES() != null ? book.get().getAVAILABLE_COPIES().intValue() : 0;
				if(avaialableCopies <= 0){
					throw new GenericUnprocessableEntityException("Available copies not found for this book - " + subscription.getBOOK_ID());
				}else {
					SubscriptionVO response = proxy.addSubscription(subscription);
					proxy.lendBookById(Long.toString(book.get().getId()));
					return response;
				}
			}
		return subscription;
	 }
}
