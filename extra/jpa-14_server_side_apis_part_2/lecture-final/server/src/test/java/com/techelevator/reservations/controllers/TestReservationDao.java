package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;

public class TestReservationDao extends MemoryReservationDao {

    public TestReservationDao(HotelDao hotelDao) {
        super(hotelDao);

        // Add some more reservations to the hotels.
        for (Hotel hotel : hotelDao.list()) {
            int hotelId = hotel.getId();
            Reservation reservation = new Reservation(getMaxIdPlusOne(), hotelId, "Walter White",
                    "10/16/2022", "10/17/2022", 2);
            create(reservation, hotelId);

            reservation = new Reservation(getMaxIdPlusOne(), hotelId, "Jesse Pinkman",
                    "10/16/2022", "10/18/2022", 1);
            create(reservation, hotelId);

            reservation = new Reservation(getMaxIdPlusOne(), hotelId, "Gus Fring",
                    "10/17/2022", "10/19/2022", 1);
            create(reservation, hotelId);
        }
    }
}
