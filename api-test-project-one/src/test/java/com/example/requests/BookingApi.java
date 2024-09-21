package com.example.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given; // これが重要

public class BookingApi {
    //ベースURLの宣言
    private static final String apiUrl = "https://automationtesting.online/booking/";

    //GETリクエストの送出
    public static Response getBookingSummary(){
        return given().get(apiUrl + "summary?roomid=1");
        
    }
}
