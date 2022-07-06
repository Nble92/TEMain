package com.techelevator.model;

import com.techelevator.services.RestCatFactService;
import com.techelevator.services.RestCatPicService;

import javax.validation.constraints.NotEmpty;

public class CatCard {

	//public CatFact fact;
	//public CatPic pic;
	public Long catCardId;
	@NotEmpty
	public String catFact;
	@NotEmpty
	public String imgUrl;
	@NotEmpty
	public String caption;


	public CatCard() {

	}

	public CatCard(CatFact catFact, CatPic pic) {
	this.catFact = catFact.getText();
	imgUrl = pic.getFile();
	}

	public Long getCatCardId() {
		return catCardId;
	}
	public void setCatCardId(Long catCardId) {
		this.catCardId = catCardId;
	}
	
	public String getCatFact() {
		return catFact;
	}
	public void setCatFact(String catFact) {
		this.catFact = catFact;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
}
