package test;

import baseUrl.herOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import testDatas.TestDataHerOkuApp;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class odev extends herOkuAppBaseUrl {

        /*
            C21_Post_TestDataKullanimi
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
    request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

    Response Body
    {
    "bookingid": 24,
    "booking": {
    "firstname": "Ahmet",
    "lastname": "Bulut",
    "totalprice": 500,
    "depositpaid": false,
    "bookingdates": {
                    "checkin": "2021-06-01",
                    "checkout": "2021-06-10"
    },
    "additionalneeds": "wi-fi"
    }
    }

    Request body
    {
    "firstname" : "Ahmet",
    "lastname" : “Bulut",
    "totalprice" : 500,
    "depositpaid" : false,
    "bookingdates" : {
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
    },
    "additionalneeds" : "wi-fi"
    }
         */

    @Test
    public void post01(){

        specHerOkuApp.pathParam("pp1","booking");

        TestDataHerOkuApp testDataHerOkuApp = new TestDataHerOkuApp();

        HashMap<String,Object> reqBody = testDataHerOkuApp.reqBodyOlusturMAP();
        HashMap<String,Object> expBody = testDataHerOkuApp.expBodyOlusturMAP();

        Response response = given()
                                    .spec(specHerOkuApp)
                                    .contentType(ContentType.JSON)
                                    .when()
                                    .body(reqBody)
                                    .post("pp1");

        HashMap<String,Object> resMAP = response.as(HashMap.class);



    }




}
