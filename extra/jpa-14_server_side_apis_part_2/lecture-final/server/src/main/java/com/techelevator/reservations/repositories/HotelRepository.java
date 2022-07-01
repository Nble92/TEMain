package com.techelevator.reservations.repositories;

import com.techelevator.reservations.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
