package com.fisglobal.api.domain;


public class BookVO {
	
	private Long id;
	private String name;
	private String AUTHOR;
	private Long AVAILABLE_COPIES;
	private Long TOTAL_COPIES;
	
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
}
