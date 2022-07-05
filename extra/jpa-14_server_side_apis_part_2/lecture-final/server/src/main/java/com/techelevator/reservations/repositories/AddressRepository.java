package com.techelevator.reservations.repositories;

import com.techelevator.reservations.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
