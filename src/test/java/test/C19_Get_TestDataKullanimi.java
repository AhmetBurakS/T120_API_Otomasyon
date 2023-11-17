package test;

import baseUrl.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import testDatas.TestDataDummy;
import testDatas.TestDataJSONPlace;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C19_Get_TestDataKullanimi extends DummyBaseUrl {
    /*
        C20_Get_TestDataKullanimi
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un status code’unun 200, content Type’inin
    application/json ve body’sinin asagidaki gibi oldugunu test edin.
    Response Body
    {
    "status": "success",
    "data": {
    "id": 3,
    "employee_name": "Ashton Cox",
    "employee_salary": 86000,
    "employee_age": 66,
    "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
    }
     */

    @Test
    public void get01(){

        // 1- EndPoint hazirlama

        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        // 2- Expected body olusturma

        TestDataDummy testDataDummy = new TestDataDummy();

        //JSONObject expBody = testDataDummy.expBodyOlustur();

        // 3- Response kaydetme

        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        // 4- Assertion islemi

        JsonPath resJP = response.jsonPath();

        assertEquals(testDataDummy.okStatusKodu,response.getStatusCode());
        assertEquals(testDataDummy.contentType,response.getContentType());
       /* assertEquals(expBody.getJSONObject("data").get("id"),resJP.get("data.id"));
        assertEquals(expBody.getJSONObject("data").get("employee_name"),resJP.get("data.employee_name"));
        assertEquals(expBody.getJSONObject("data").get("employee_salary"),resJP.get("data.employee_salary"));
        assertEquals(expBody.getJSONObject("data").get("employee_age"),resJP.get("data.employee_age"));
        assertEquals(expBody.getJSONObject("data").get("profile_image"),resJP.get("data.profile_image"));
        assertEquals(expBody.get("message"),resJP.get("message"));

        */
    }
}
