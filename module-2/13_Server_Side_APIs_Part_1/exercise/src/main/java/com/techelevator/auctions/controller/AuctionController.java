package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    //GET ALL AUCTIONS
//This top thing is what tells the api what to look for when a specific request comes in
    @RequestMapping(path = "/auctions", method = RequestMethod.GET)
    //here we create a list for the values to go into
    public List<Auction> list(@RequestParam(defaultValue = "", required = false) String title_like,
                              @RequestParam (defaultValue = "0") double currentBid_lte) {
        if (currentBid_lte > 0 && (!Objects.equals(title_like, "") )){
            return dao.searchByTitleAndPrice(title_like, currentBid_lte);
        }
        if (currentBid_lte > 0){
            return dao.searchByPrice(currentBid_lte);
        }
        if (!Objects.equals(title_like, "")) {
            return dao.searchByTitle(title_like);
        }
        return dao.list();
    }




        //GET AUCTION BY ID
        @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
        //WHENEVER A VARIABLE NEEDS TO BE ADDED, you need the path variable @thing
        public Auction auction ( @PathVariable int id){

            return dao.get(id);
        }

        @RequestMapping(path = "/auctions", method = RequestMethod.POST)
        public Auction newAuction (@RequestBody Auction auction){
            return dao.create(auction);

        }
    }


