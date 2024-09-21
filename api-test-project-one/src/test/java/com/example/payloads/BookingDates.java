package com.example.payloads;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;







public class BookingDates {
    //bookingクラスのサブクラス
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

    @JsonProperty   //変数がJSONproppatyなことを宣言する
    private LocalDate checkin;  //変数宣言
    @JsonProperty
    private LocalDate checkout;

    //jacksonが必要とするデフォルトコンストラクタ
    public BookingDates(){}
    //ペイロード構築のためのカスタマイズコンストラクタ
    public BookingDates(LocalDate checkin, LocalDate chechout){
        this.checkin = checkin;
        this.checkout = chechout; 
    }

    //jacksonが使うGetter
    public LocalDate getCheckin(){
        return checkin;
    }

    public LocalDate getCheckout(){
        return checkout;
    }
}
