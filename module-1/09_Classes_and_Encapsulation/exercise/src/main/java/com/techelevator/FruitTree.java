package com.techelevator;

import java.security.KeyStore;

public class FruitTree { //class


//instance variables: they set the state of the class. these are accessed through getters & setters.
    private String typeOfFruit;
    private int piecesOfFruitLeft;


    //constructor class: this cl
    public FruitTree(String typeOfFruit, int piecesOfFruitLeft) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = piecesOfFruitLeft;


    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }
    public String getTypeOfFruit()
    {
        return typeOfFruit;
    }

    public boolean pickFruit(int numberOfPiecesToRemove) {
boolean result = true;

        if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
            result = true;
            piecesOfFruitLeft -= numberOfPiecesToRemove;

        }
        else {
            result = false;


        }
        return result;


    }
}



