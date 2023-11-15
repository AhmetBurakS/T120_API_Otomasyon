package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class tekrar {

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
    public void test01(){
        //1- endpoint hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- expected body hazirlama
        JSONObject expBody = new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3- response kaydetmek
        Response response = given().when().get(url);


        // 4- assertion islemi
        JsonPath respJP = response.jsonPath();

        Assert.assertEquals(expBody.get("userId"),respJP.get("userId"));
        Assert.assertEquals(expBody.get("id"),respJP.get("id"));
        Assert.assertEquals(expBody.get("title"),respJP.get("title"));
        Assert.assertEquals(expBody.get("body"),respJP.get("body"));
    }

}
