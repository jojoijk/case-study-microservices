package com.fisglobal.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fisglobal.repository.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
