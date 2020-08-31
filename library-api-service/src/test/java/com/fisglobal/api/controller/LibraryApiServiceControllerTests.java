package com.fisglobal.api.controller;

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
import com.fisglobal.api.domain.SubscriptionVO;


@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LibraryApiServiceControllerTests {

	@Autowired 
	LibraryApiServiceController controller;
	
	@Test
	@Order(1)
	public void testGetSubscriptions() {
			
		List<SubscriptionVO> subscription = this.controller.subscriptions();
		assertThat(subscription).isNotNull();
	}
	
	@Test
	@Order(2)
	public void testAddNewSubscription() {
		SubscriptionVO subscriptionvo = new SubscriptionVO();
		subscriptionvo.setName("Mr.Thomas");
		subscriptionvo.setBOOK_ID(new Long(2));
		subscriptionvo.setDATE_SUBSCRIBED(new Date());
		subscriptionvo.setDATE_RETURNED(null);	
		SubscriptionVO response = this.controller.addNewSubscription(subscriptionvo);
		assertThat(response).isNotNull();
	}
	
	
	@Test
	@Order(2)
	public void testReturnSubscription() {
		SubscriptionVO subscriptionvo = new SubscriptionVO();
		subscriptionvo.setID(new Long(1));
		subscriptionvo.setName("Mr.Thomas");
		subscriptionvo.setBOOK_ID(new Long(2));
		subscriptionvo.setDATE_SUBSCRIBED(new Date());
		subscriptionvo.setDATE_RETURNED(null);	
		SubscriptionVO response = this.controller.returnSubscriptions(subscriptionvo);
		assertThat(response).isNotNull();
	}
	
}
