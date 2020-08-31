package com.fisglobal.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name = "BOOK_ID", length = 25)
	private Long id;
	
	@NotNull
	@Column(name = "BOOK_NAME", length = 255)
	@Size(min=5, max =255, message="Name should have atleast 5 characters")
	private String name;
	
	@NotNull
	@Size(min=5, max =80, message="Author should have atleast 5 characters")
	private String AUTHOR;
	
	@NotNull
	private Long AVAILABLE_COPIES;
	
	@NotNull
	private Long TOTAL_COPIES;
	
	public Long getAVAILABLE_COPIES() {
		return AVAILABLE_COPIES;
	}
	public void setAVAILABLE_COPIES(Long aVAILABLE_COPIES) {
		AVAILABLE_COPIES = aVAILABLE_COPIES;
	}
	public Long getTOTAL_COPIES() {
		return TOTAL_COPIES;
	}
	public void setTOTAL_COPIES(Long tOTAL_COPIES) {
		TOTAL_COPIES = tOTAL_COPIES;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAUTHOR() {
		return AUTHOR;
	}
	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}
	

}
