package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.RestCatFactService;
import com.techelevator.services.RestCatPicService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatController {

    private CatCardDao catCardDao;
    private RestCatFactService catFactService;
    private RestCatPicService catPicService;

    public CatController(CatCardDao catCardDao, RestCatFactService catFactService, RestCatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> list() {
        return catCardDao.list();
    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard getCatCard(@PathVariable("id") long id) {
        return catCardDao.get(id);
    }

    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public CatCard randomCard() {
    CatCard card = new CatCard();
card.setCatFact(catFactService.rdmFact().getText());
card.setImgUrl(catPicService.rdmPic().getFile());
        return card;
    }


//    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
//    public CatCard getCatCard(@PathVariable("id") Random id) {
//        return catCardDao.get(id);
//    }
}
