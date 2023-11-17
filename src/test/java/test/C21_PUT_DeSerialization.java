package test;

import baseUrl.jsonPlaceBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import testDatas.TestDataJSONPlace;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C21_PUT_DeSerialization extends jsonPlaceBaseUrl {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body'e sahip bir PUT request yolladigimizda donen response'in
    response body'sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

    Expected Data :

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
 */

    @Test
    public void put01(){

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJSONPlace testDataJSONPlace = new TestDataJSONPlace();

        HashMap<String,Object> reqBody = testDataJSONPlace.requestBodyOlusturMAP();

        HashMap<String,Object> expData = testDataJSONPlace.requestBodyOlusturMAP();

        Response response = given()
                                    .spec(specJsonPlace)
                                    .contentType(ContentType.JSON)
                                    .when()
                                    .body(reqBody)
                                    .put("/{pp1}/{pp2}");

        // Assertion islemi

        HashMap<String,Object> resMAP = response.as(HashMap.class);

        assertEquals(expData.get("title"),resMAP.get("title"));
        assertEquals(expData.get("body"),resMAP.get("body"));
        assertEquals(expData.get("userId"),resMAP.get("userId"));
        assertEquals(expData.get("id"),resMAP.get("id"));



    }
}
