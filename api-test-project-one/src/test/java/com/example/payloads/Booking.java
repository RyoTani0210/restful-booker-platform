package com.example.payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreType
public class Booking {
    // // 作りたいJSONデータ
    // {
    //      "roomid": int,
    //      "firstname": str,
    //      "lastname": str,
    //      "depositpaid": bool,
    //      "bookingdates"{
    //          "checkin": date,
    //          "checkout": date,
    //      },
    //      "additioalneeds": str
    // }
    @JsonProperty
    private int roomid;
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private boolean depositpaid;
    @JsonProperty
    private BookingDates bookingdates;
    @JsonProperty
    private String additionalneeds;

    //デフォルトコンストラクタ作成
    public Booking() {}

    public Booking(
        int roomid,
        String firstname,
        String lastname,
        boolean depositpaid,
        BookingDates bookingdates,
        String additionalneeds
        ) {
            this.roomid = roomid;
            this.firstname = firstname;
            this.lastname = lastname;
            this.depositpaid = depositpaid;
            this.bookingdates = bookingdates;
            this.additionalneeds = additionalneeds;
        }

        public int getRoomid(){
            return roomid;
        }
        public String getFirstname(){
            return firstname;
        }
        public String getLastname(){
            return lastname;
        }
        public boolean isDepositpaid(){
            return depositpaid;
        }
        public BookingDates getBookingDates(){
            return bookingdates;
        }
        public String getAdditionalneeds(){
            return additionalneeds;
        }
}
