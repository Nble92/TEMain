package com.techelevator.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BGMachine {
   private int availableCents;
   private List <GumBall> gumBalls;
   private int capacity;
   private int costPerGumball;
   private int totalCents = 0;


   public BGMachine(int capacity, int costPerGumball) {
       this.capacity = capacity;
       this.costPerGumball = costPerGumball;
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
      while (availableCents >= costPerGumball) {
         //this produces a random number between 0 and the size of the list
         //picks out a random gumball from the gumball list
         int whichOne = (int)(Math.random() * gumBalls.size());
         GumBall gumBall = gumBalls.remove((whichOne));

         purchased.add(gumBall);

         availableCents -= costPerGumball;
         totalCents += costPerGumball;
      }


      return purchased;


}

}
