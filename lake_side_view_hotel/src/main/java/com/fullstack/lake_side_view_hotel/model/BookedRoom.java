package com.fullstack.lake_side_view_hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.util.Lazy;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {

    @Id // setting the primary key for table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this line says that ID is incremented as a primary key
    private Long bookingId;

    @Column(name = "check_in")
    private LocalDate checkInDate;

    @Column(name = "check_out")
    private LocalDate checkOutDate;

    @Column(name = "guest_Name")
    private String guestFullName;

    @Column(name = "guest_Email")
    private String guestEmail;

    @Column(name = "adults")
    private  int NumOfAdults;

    @Column(name = "children")
    private  int NumOfChildren;

    @Column(name = "total_guest")
    private  int totalNumofGuest;

    @Column(name = "confirmation_Code")
    private String BookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    /* This annotation is used in Database to fetch many to one instances as there may be many bookings done on a single entity,
    where fetchtype.LAZY is a stratergy to fetch data,v meaning it will be loaded only when it is accessed for the first time*/
    @JoinColumn (name = "room_id")
    private Room room;

    public void calculateTotalNumberofGuest(){
        this.totalNumofGuest = this.NumOfAdults + this.NumOfChildren;
    }

    public void setNumOfAdults(int numOfAdults) {
        NumOfAdults = numOfAdults;
        calculateTotalNumberofGuest(); //if anychanges done here will also changes the total num of guest i.e we called the function here
    }

    public void setNumOfChildren(int numOfChildren) {
        NumOfChildren = numOfChildren;
        calculateTotalNumberofGuest(); //if anychanges done here will also changes the total num of guest i.e we called the function here
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        BookingConfirmationCode = bookingConfirmationCode;
    }
}
