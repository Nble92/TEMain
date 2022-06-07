package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CigarPartyTest {

    @Test
    public void havePartyTestHappyPath() {

        //arrange
        CigarParty party = new CigarParty();


        //act
        //assert
        assertEquals(false, party.haveParty(20,true));
        assertEquals(true, party.haveParty(50,true));
        assertEquals(true, party.haveParty(200,true));
        assertEquals(false, party.haveParty(70,true));

    }



}