package com.techelevator.reservations.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    @Min( value = 1, message = "The field 'hotelID' is required.")
    private int hotelID;
    @NotBlank( message = "The field 'fullName' is required.")
    private String fullName;
    @NotBlank( message = "The field 'checkinDate' is required.")
    private String checkinDate;
    @NotBlank( message = "The field 'checkoutDate' is required.")
    private String checkoutDate;
    @Min( value = 1, message = "The minimum number of guests is 1")
    @Max( value = 5, message = "The maximum number of guests is 5")
    private int guests;

    public Reservation() {
    }

    public Reservation(int id, int hotelID, String fullName, String checkinDate, String checkoutDate, int guests) {
        this.id = id;
        this.hotelID = hotelID;
        this.fullName = fullName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Reservation Details" +
                "\n--------------------------------------------" +
                "\n Id: " + id +
                "\n Hotel Id: " + hotelID +
                "\n Full Name: " + fullName +
                "\n Checkin Date: " + checkinDate +
                "\n Checkout Date: " + checkoutDate +
                "\n Guests: " + guests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id && hotelID == that.hotelID && guests == that.guests && fullName.equals(that.fullName) && Objects.equals(checkinDate, that.checkinDate) && Objects.equals(checkoutDate, that.checkoutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelID, fullName, checkinDate, checkoutDate, guests);
    }
}
