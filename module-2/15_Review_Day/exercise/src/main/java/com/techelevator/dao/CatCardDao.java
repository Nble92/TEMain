package com.techelevator.dao;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.RestCatFactService;
import com.techelevator.services.RestCatPicService;

import java.io.File;
import java.util.List;

public interface CatCardDao {

	List<CatCard> list();

	CatCard get(long id);

		CatCard random(CatFact fact, CatPic pic);

	boolean save(CatCard cardToSave);

	boolean update(long id, CatCard card);

	boolean delete(long id);

}
