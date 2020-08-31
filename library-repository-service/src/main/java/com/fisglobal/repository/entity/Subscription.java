package com.fisglobal.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subscription {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name = "SUBSCRIBER_ID", length = 25)
	private Long ID;
	
	@Column(name = "SUBSCRIBER_NAME", length = 80)
	private String name;
	
	private Date DATE_SUBSCRIBED;
	
	private Date DATE_RETURNED;
	private Long BOOK_ID;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDATE_SUBSCRIBED() {
		return DATE_SUBSCRIBED;
	}
	public void setDATE_SUBSCRIBED(Date dATE_SUBSCRIBED) {
		DATE_SUBSCRIBED = dATE_SUBSCRIBED;
	}
	public Date getDATE_RETURNED() {
		return DATE_RETURNED;
	}
	public void setDATE_RETURNED(Date dATE_RETURNED) {
		DATE_RETURNED = dATE_RETURNED;
	}
	public Long getBOOK_ID() {
		return BOOK_ID;
	}
	public void setBOOK_ID(Long bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}
}
