package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class BubbleGumMachine {
   private int availableCents;
   private int totalCents;
   private List<GumBall> gumBalls;
   private int capacity;
   private int costPerGumBall;

   public BubbleGumMachine(int capacity, int costPerGumBall) {
       this.capacity = capacity;
       this.costPerGumBall = costPerGumBall;
       this.availableCents = 0;
       this.totalCents = 0;
       this.gumBalls = new ArrayList<>();
   }


   public int addCents(int cents){
       availableCents += cents;
       return availableCents;
   }

    public int getTotalCents() {
        return totalCents;
    }

    public List<GumBall> turnHandle() {
       List<GumBall> purchased = new ArrayList<>();
       while (availableCents >= costPerGumBall) {
           int whichOne = (int)(Math.random() * gumBalls.size());
           GumBall gumBall = gumBalls.remove(whichOne);
           purchased.add(gumBall);

           availableCents -= costPerGumBall;
           totalCents += costPerGumBall;
       }
       return purchased;
   }


}
