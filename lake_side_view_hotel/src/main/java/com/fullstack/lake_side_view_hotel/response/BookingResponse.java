package com.fullstack.lake_side_view_hotel.response;

import java.time.LocalDate;

public class BookingResponse {
    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullName;
    private String guestEmail;
    private  int NumOfAdults;
    private  int NumOfChildren;
    private  int totalNumofGuest;
    private String BookingConfirmationCode;
}
