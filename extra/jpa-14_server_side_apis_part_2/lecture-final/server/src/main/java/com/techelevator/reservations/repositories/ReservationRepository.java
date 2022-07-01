package com.techelevator.reservations.repositories;

import com.techelevator.reservations.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByHotelID(int hotelID);
}

