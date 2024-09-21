package com.example.requests;

// import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import com.example.payloads.Booking;


public class BookingApi extends BaseApi{
    //ベースURLの宣言
    private static final String apiUrl = baseUrl + "booking/";

    //GETリクエストの送出
    public static Response getBookingSummary(){
        return given().get(apiUrl + "summary?roomid=1");
        
    }
    public static Response postBooking(Booking payload){
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(apiUrl);
    }
}
