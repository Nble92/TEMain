package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        boolean isWinning = generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        isWinning = generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids




        ReserveAuction reserveAuction = new ReserveAuction("Tech Elevator Hat", 80);

        Bid tomBid = new Bid("Tom", 35);
        reserveAuction.placeBid(tomBid);
        reserveAuction.placeBid(new Bid("John", 95));


        BuyoutAuction buyoutAuction = new BuyoutAuction("Tech Elevator Travel Mug", 55);
        Bid bid = new Bid("Cathy", 12);
        buyoutAuction.placeBid(bid);
        bid = new Bid("Christina", 60);
        buyoutAuction.placeBid(bid);
        buyoutAuction.placeBid(new Bid("Jen", 100));

    }
}
