package com.techelevator.dao.cat;

import com.techelevator.model.cat.CatCard;

import java.util.List;

public interface CatCardDao {

	List<CatCard> list();

	CatCard get(long id);

	boolean save(CatCard cardToSave);

	boolean update(long id, CatCard card);

	boolean delete(long id);

}
