package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C10_Get_ExpectedDataHazirlama {
        /*
     https://jsonplaceholder.typicode.com/posts/22 url'ine
     bir GET request yolladigimizda donen response body'sinin
     asagida verilen ile ayni oldugunu test ediniz

    Response body : (Expected Body)
     {
     "userId":3,
     "id":22,
     "title":"dolor sint quo a velit explicabo quia nam",
     "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
     }
      */

    @Test
    public void getExp(){
        // 1- Endpoint hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- Expected Body hazirlama
        JSONObject expectBody = new JSONObject();
        expectBody.put("userId",3);
        expectBody.put("id",22);
        expectBody.put("title","dolor sint quo a velit explicabo quia nam");
        expectBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //System.out.println("expectBody: "+ expectBody);

        // 3- Response kaydetmek

        Response response = given().when().get(url);

        // 4- Assertion islemi

        JsonPath respJP = response.jsonPath(); // donen cevabin icindeki verileri inceleyebilmek icin
                                                // bir JSONPath objesi icine donen cevabi yerlestirdik

        Assert.assertEquals(expectBody.get("userId"),respJP.get("userId"));
        Assert.assertEquals(expectBody.get("id"),respJP.get("id"));
        Assert.assertEquals(expectBody.get("title"),respJP.get("title"));
        Assert.assertEquals(expectBody.get("body"),respJP.get("body"));

    }
}
