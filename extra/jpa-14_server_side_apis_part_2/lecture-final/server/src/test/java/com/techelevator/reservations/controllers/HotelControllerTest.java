package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.*;

public class HotelControllerTest {

    private HotelController controller;

    @Before
    public void setup() {
        HotelDao hotelDao = new TestHotelDao();
        ReservationDao reservationDao = new TestReservationDao(hotelDao);
        controller = new HotelController(hotelDao, reservationDao);
    }

    @org.junit.Test
    public void list() {
        List<Hotel> hotels = controller.list();

        assertEquals(7, hotels.size());
        assertEquals("Aloft Cleveland", hotels.get(0).getName());
        assertEquals("Greektown Detroit", hotels.get(6).getName());
    }

    @org.junit.Test
    public void get() {
        Hotel hotel = controller.get(1);
        assertEquals("Aloft Cleveland", hotel.getName());
        hotel = controller.get(7);
        assertEquals("Greektown Detroit", hotel.getName());
    }

    @org.junit.Test
    public void listReservations() {
        List<Reservation> reservations = controller.listReservations();
        assertEquals(24, reservations.size());

        assertEquals(1, reservations.get(0).getId());
        assertEquals("John Smith", reservations.get(0).getFullName());
        assertEquals(24, reservations.get(23).getId());
        assertEquals("Gus Fring", reservations.get(23).getFullName());
    }

    @org.junit.Test
    public void getReservation() throws Exception {
        Reservation reservation = controller.getReservation(1);
        assertEquals("John Smith", reservation.getFullName());

        reservation = controller.getReservation(24);
        assertEquals("Gus Fring", reservation.getFullName());
    }

    @org.junit.Test(expected = ReservationNotFoundException.class)
    public void getReservation_notFound() throws ReservationNotFoundException {
        controller.getReservation(1099);
    }

    @org.junit.Test
    public void listReservationsByHotel() throws Exception {
        List<Reservation> reservations = controller.listReservationsByHotel(1);
        assertEquals(6, reservations.size());

        reservations = controller.listReservationsByHotel(7);
        assertEquals(3, reservations.size());
    }

    @org.junit.Test(expected = HotelNotFoundException.class)
    public void listReservationsByHotel_notFound() throws HotelNotFoundException {
        controller.listReservationsByHotel(1099);
    }

    @org.junit.Test
    public void addReservation() throws Exception {
        List<Reservation> reservations = controller.listReservations();
        assertEquals(24, reservations.size());

        Reservation reservation = new Reservation(25, 1, "Mike Ehrmantraut",
                "10/16/2022", "10/17/2022", 3);
        controller.addReservation(reservation);

        reservations = controller.listReservations();
        assertEquals(25, reservations.size());
        assertEquals("Mike Ehrmantraut", reservations.get(24).getFullName());
    }

    @org.junit.Test
    public void update() throws Exception {
        Reservation reservation = controller.getReservation(1);
        assertEquals("John Smith", reservation.getFullName());

        reservation = new Reservation(1, 1, "Mike Ehrmantraut",
                "10/16/2022", "10/17/2022", 3);
        controller.update(reservation, 1);

        reservation = controller.getReservation(1);
        assertEquals("Mike Ehrmantraut", reservation.getFullName());
    }

    @org.junit.Test(expected = ReservationNotFoundException.class)
    public void update_notFound() throws ReservationNotFoundException {
        Reservation reservation = new Reservation(1099, 1, "Mike Ehrmantraut",
                "10/16/2022", "10/17/2022", 3);
        controller.update(reservation, 1099);
    }

    @org.junit.Test(expected = ReservationNotFoundException.class)
    public void delete() throws ReservationNotFoundException {
        Reservation reservation = controller.getReservation(1);
        assertEquals("John Smith", reservation.getFullName());

        controller.delete(1);

        controller.getReservation(1);
    }


    @org.junit.Test(expected = ReservationNotFoundException.class)
    public void delete_notFound() throws ReservationNotFoundException {
        controller.delete(1099);
    }

    @org.junit.Test
    public void filterByStateAndCity() {
        List<Hotel>  hotels = controller.filterByStateAndCity("Ohio", null);
        assertEquals(5, hotels.size());

        hotels = controller.filterByStateAndCity("Pennsylvania", null);
        assertEquals(1, hotels.size());

        hotels = controller.filterByStateAndCity("Ohio", "Cleveland");
        assertEquals(3, hotels.size());

        hotels = controller.filterByStateAndCity("Florida", "Miami");
        assertEquals(0, hotels.size());
    }
}