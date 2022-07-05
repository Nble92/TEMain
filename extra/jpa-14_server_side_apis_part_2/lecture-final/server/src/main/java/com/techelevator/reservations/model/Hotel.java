package com.techelevator.reservations.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Objects;
import java.util.Set;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    private String name;
    @OneToOne
    private Address address;
    private int stars;
    private int roomsAvailable;
    private double costPerNight;
    private String coverImage;
    @OneToMany
    private Set<Reservation> reservations;

    public Hotel() {
    }

    public Hotel(int id, String name, Address address, int stars, int roomsAvailable, double costPerNight) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.roomsAvailable = roomsAvailable;
        this.costPerNight = costPerNight;
        this.coverImage = "default-cover-image.png";
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Hotel Details" +
                "\n--------------------------------------------" +
                "\n Id: " + id +
                "\n Name:'" + name + '\'' +
                "\n Stars: " + stars +
                "\n RoomsAvailable: " + roomsAvailable +
                "\n Cost Per Night: " + costPerNight +
                "\n Image:" + coverImage;
    }

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(double costPerNight) {
        this.costPerNight = costPerNight;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
