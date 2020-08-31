package com.fisglobal.repository.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

import com.fisglobal.repository.entity.Book;
import com.fisglobal.repository.entity.Subscription;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SubscriptionRepositoryControllerTest {

	@Autowired 
	SubscriptionRepositoryController controller;
	
	@Test
	@Order(1)
	public void testAddSubscription() {
		Subscription subscription = new Subscription();
		subscription.setName("Mr.Thomas");
		subscription.setBOOK_ID(new Long(2));
		subscription.setDATE_SUBSCRIBED(new Date());
		subscription.setDATE_RETURNED(null);
		
		subscription = this.controller.addSubscription(subscription);
		assertThat(subscription).isNotNull();
	}
	
	
	@Test
	@Order(2)
	public void testUpdateSubscription() {
		Subscription subscription = new Subscription();
		subscription.setID(new Long(1));
		subscription.setName("Mr.Thomas");
		subscription.setBOOK_ID(new Long(2));
		subscription.setDATE_SUBSCRIBED(new Date());
		subscription.setDATE_RETURNED(new Date());
		
		subscription = this.controller.updateSubscription(subscription);
		assertThat(subscription).isNotNull();
	}
	
	@Test
	@Order(3)
	public void testRetrieveSubscriptions() {
		
		List<Subscription> subscription = this.controller.retrieveSubscriptions();
		assertThat(subscription).isNotEmpty();
	}
	
	@Test
	@Order(4)
	public void testGetSubscriptionById() {
		
		ResponseEntity<Subscription> subscription = this.controller.getSubscriptionById("1");
		assertThat(subscription.getBody()).isNotNull();
	}

}
