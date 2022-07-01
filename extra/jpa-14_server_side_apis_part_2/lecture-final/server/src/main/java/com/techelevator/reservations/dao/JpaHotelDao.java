package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Address;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.repositories.AddressRepository;
import com.techelevator.reservations.repositories.HotelRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component("hotelDao")
public class JpaHotelDao implements HotelDao {

    private final HotelRepository repository;
    private final AddressRepository addressRepository;

    public JpaHotelDao(HotelRepository repository, AddressRepository addressRepository) {
        this.repository = repository;
        this.addressRepository = addressRepository;
        initializeHotelData();
    }

    @Override
    public List<Hotel> list() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void create(Hotel hotel) {
        addressRepository.save(hotel.getAddress());
        repository.save(hotel);
    }

    @Override
    public Hotel get(int id) {
        return repository.findById(id).orElse(null);
    }

    // ***** Initialization code for demo purposes ****************************
    private void initializeHotelData() {
        // skip if already initialized
        if (repository.findAll().size() > 0) {
            return;
        }
        create(new Hotel(1,
                "Aloft Cleveland",
                new Address("1111 W 10th St","","Cleveland","Ohio","44115"),
                4,
                48,274));
        create(new Hotel(2,
                "Hilton Cleveland Downtown",
                new Address("100 Lakeside Ave","","Cleveland","Ohio","44114"),
                4,
                12,287));
        create(new Hotel(3,
                "Metropolitan at the 9",
                new Address("2017 E 9th St","","Cleveland","Ohio","48226"),
                5,
                22,319));
        create(new Hotel(4,
                "The Westin Pittsburgh",
                new Address("1000 Penn Ave","","Pittsburgh","Pennsylvania","15222"),
                4,
                60,131));
        create(new Hotel(5,
                "Hilton Columbus Downtown",
                new Address("401 N High St","","Columbus","Ohio","43215"),
                4,
                34,190));
        create(new Hotel(6,
                "The Summit A Dolce Hotel",
                new Address("5345 Medpace Way","","Cincinnati","Ohio","43215"),
                4,
                43,218));
        create(new Hotel(7,
                "Greektown Detroit",
                new Address("1200 St Antoine St","","Detroit","Michigan","48226"),
                4,
                75,185));
    }
}
