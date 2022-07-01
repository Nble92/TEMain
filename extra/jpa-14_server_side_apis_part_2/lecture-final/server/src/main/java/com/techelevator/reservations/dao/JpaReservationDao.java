package com.techelevator.reservations.dao;

import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.model.Reservation;
import com.techelevator.reservations.repositories.ReservationRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("reservationDao")
public class JpaReservationDao implements ReservationDao {
    private final ReservationRepository repository;

    public JpaReservationDao(ReservationRepository repository) {
        this.repository = repository;
        initializeReservationData();
    }

    @Override
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Reservation> findByHotel(int hotelID) throws HotelNotFoundException {
        return repository.findByHotelID(hotelID);
    }

    @Override
    public Reservation get(int reservationID) throws ReservationNotFoundException {
        return repository.findById(reservationID).orElse(null);
    }

    @Override
    public Reservation create(Reservation reservation, int hotelID) throws HotelNotFoundException {
        return repository.save(reservation);
    }

    @Override
    public Reservation update(Reservation reservation, int id) throws ReservationNotFoundException {
        reservation.setId(id);
        return repository.save(reservation);
    }

    @Override
    public void delete(int id) throws ReservationNotFoundException {
        repository.delete(get(id));
    }

    // ***** Initialization code for demo purposes ****************************

    private void initializeReservationData() {
        // skip if already initialized
        if (repository.findAll().size() > 0) {
            return;
        }

        LocalDate now = LocalDate.now();

        repository.save(new Reservation(1,
                1,
                "John Smith",
                now.toString(),
                now.plusDays(3).toString(),
                2));
        repository.save(new Reservation(2,
                1,
                "Sam Turner",
                now.toString(),
                now.plusDays(5).toString(),
                4));
        repository.save(new Reservation(3,
                1,
                "Mark Johnson",
                now.plusDays(7).toString(),
                now.plusDays(10).toString(),
                2));
    }
}
