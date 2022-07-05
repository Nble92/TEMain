# Refactor For JPA

Start with module2 - 14_server_side_apis_part_2 exercise-final.


## pom.xml changes

Add the following dependencies...
```
        <dependency> 
            <groupId>org.postgresql</groupId> 
            <artifactId>postgresql</artifactId> 
            <version>42.3.3</version> 
        </dependency>
        <dependency> 
            <groupId>org.springframework.boot</groupId> 
            <artifactId>spring-boot-starter-data-jpa</artifactId> 
        </dependency>
```

Maven reload project.

## Model changes
### Hotel.java

- Annotate with @Entity .
```
@Entity 
public class Hotel {
```

- Annotate the @Id column.
- Annotate for the IDENTITY type.
```
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(updatable = false)
    private int id;
```

- Annotate address variable with @OneToOne to define the relationship to the Address entity.
```
    @OneToOne 
    private Address address;
```

- Add a reservations variable and annotate with @OneToMany to define the relationship to the Reservation entity.
```
    @OneToMany 
    private Set<Reservation> reservations;
```

- Create a no-arg constructor.
```
    public Hotel() { 
    }
```

- Generate getter and setter for the reservations variable.
```
    public Set<Reservation> getReservations() { 
        return reservations; 
    }

    public void setReservations(Set<Reservation> reservations) { 
        this.reservations = reservations; 
    }
```

- Generate equals and hashCode using the Intellij defaults.
```
    @Override 
    public boolean equals(Object o) { 
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
        Hotel hotel = (Hotel) o; 
        return id == hotel.id && stars == hotel.stars && roomsAvailable == hotel.roomsAvailable && Double.compare(hotel.costPerNight, costPerNight) == 0 && Objects.equals(name, hotel.name) && Objects.equals(address, hotel.address) && Objects.equals(coverImage, hotel.coverImage) && Objects.equals(reservations, hotel.reservations); 
    }

    @Override 
    public int hashCode() { 
        return Objects.hash(id, name, address, stars, roomsAvailable, costPerNight, coverImage, reservations); 
    }
```

### Address.java

- Annotate with @Entity .
```
@Entity
public class Address {
```
Change id variable from String to int.
```
private int id;
```
- Clean up id accessors for int.
```
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
```

- Annotate the @Id column.
- Annotate for the IDENTITY type.
```
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
```

- Generate equals and hashCode using the Intellij defaults.

### Reservation.java

- Annotate with @Entity .
```
@Entity
public class Reservation {
```
- Annotate the @Id column.
- Annotate for the IDENTITY type.
```
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
```

- Add no-arg constructor.
```
 public Reservation() {
    }
```

- Generate equals and hashCode using the Intellij defaults.

## Add repositories

- Create new package for repositories.
```
com.techelevator.reservations.repositories
```

### HotelRepository
- Create new interface for Hotel repository extending JpaRepository .
```
public interface HotelRepository extends JpaRepository<Hotel, Integer> { 
}
```

### AddressRepository
- Create new interface for Address repository extending JpaRepository .
```
public interface AddressRepository extends JpaRepository<Address, Integer> { 
}
```

### ReservationRepository
- Create new interface for Reservation repository extending JpaRepository .
- Add method to find all reservations by hotel ID.
- The above method will be needed to satisfy the ReservationDao interface when we implement the JPA DAO.
```
public interface ReservationRepository extends JpaRepository<Reservation, Integer> { 
    List<Reservation> findByHotelID(int hotelID); 
}
```


## JPA DAO implementations

### JpaHotelDao
- Create a new JPA DAO classes that implement HotelDao .
- Annotate with @Component("hotelDao") .
- Add a private final member of type HotelRepository .
- Add a private final member of type AddressRepository .
- Add a constructor that takes a HotelRepository and a AddressRepository .  Spring will inject these when constructed.
- Implement each of the methods using the repository.
- Add @Transactional to each mutating method.
- Note the use of an Optional<Hotel> returned from findById in the get method.
```
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
...

}
```

### JpaReservationDao
- Create a new JPA DAO classes that implement ReservationDao .
- Annotate with @Component("reservationDao") .
- Add a private final member of type ReservationRepository .
- Add a constructor that takes a ReservationRepository .  Spring will inject this when constructed.
- Implement each of the methods using the repository.
- Note the use of an Optional<Reservation> returned from findById in the get method.
```
@Component("reservationDao")
public class JpaReservationDao implements ReservationDao {
    private final ReservationRepository repository;

    public JpaReservationDao(ReservationRepository repository) {
        this.repository = repository;
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
```

## application.properties

- Add the following to application.properties to setup Postgres and auto DDL.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/Hotels 
spring.datasource.username=postgres 
spring.datasource.password=postgres1 
spring.datasource.platform=postgres 
spring.datasource.driver-class-name=org.postgresql.Driver 
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect 
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false 
spring.jpa.show-sql=true 
spring.jpa.hibernate.ddl-auto=update

spring.mvc.pathmatch.matching-strategy=ant-path-matcher
```


## Create the Auction database

- In pgAdmin create a Hotels database but don't run any DDL.  Spring will create the tables automatically.