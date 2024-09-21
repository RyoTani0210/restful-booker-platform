package com.example.checks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.requests.BookingApi;

import io.restassured.response.Response;

public class BookingApiIT{
    @Test
    public void getBookingSummaryShouldReturn200(){
        Response response = BookingApi.getBookingSummary();

        assertEquals(200, response.getStatusCode());
    }

}