package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C2_Get_ApiSorgulama_Assertion {
    /*
    https://restful-booker.herokuapp.com/booking/83 url'ine bir GET request
gonderdigimizde donen Response'un,
status code'unun 200,
ve content type'inin application/json; charset=utf-8, ve Server isimli Header'in degerinin Cowboy,
ve status Line'in HTTP/1.1 200 OK
 */

    @Test
    public void getAssert(){
        String url = "https://restful-booker.herokuapp.com/booking/83";
        Response responce = given().when().get(url);

        responce.then()
                .assertThat()
                .statusCode(200)
                .header("Server","Cowboy")
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

    }
}
