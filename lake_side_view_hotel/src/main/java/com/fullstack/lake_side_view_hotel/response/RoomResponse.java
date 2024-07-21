package com.fullstack.lake_side_view_hotel.response;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor


public class RoomResponse {
    //Room Response is a DTO
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked;
    private String photo;
    private List<BookingResponse> bookings;

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked,
                        byte[] photoBytes) {
           // , List<BookingResponse> bookings
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        //this.photo = photoBytes != null ? Base64.encodeBase64String(photoBytes) : null;  -- this is depricated as we use the java util lib
        this.photo = photoBytes != null ? java.util.Base64.getEncoder().encodeToString(photoBytes) : null;
        //this.bookings = bookings;
    }
}
