package com.example.checks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.payloads.Booking;
import com.example.payloads.BookingDates;
import com.example.requests.BookingApi;

import io.restassured.response.Response;

public class BookingApiIT{
    @Test
    public void getBookingSummaryShouldReturn200(){
        // GETリクエスト
        Response response = BookingApi.getBookingSummary();

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void postBookingReturns201(){
        BookingDates dates = new BookingDates(
            LocalDate.of(2021, 1, 1),
            LocalDate.of(2021,1,3)
        );

        Booking payload = new Booking(
            1,
            "John",
            "Smith",
            true,
            dates,
            "Breakfast"
        );

        Response response = BookingApi.postBooking(payload);

        assertEquals(201, response.getStatusCode());
    }

    @Test
    public void deleteBookingReturns202(){
        //予約の削除のテスト
        //リクエストの結合・パースをする

        BookingDates dates = new BookingDates(
            LocalDate.of(2021, 2, 1),
            LocalDate.of( 2021, 2, 3)
        );
        Booking payload = new Booking(
            1,
            "Mark",
            "Hunter",
            true,
            dates,
            "a cup of coffee"
        );
        
    }
}