package test;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C3_JSON_DataOlusturma {

            /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.

        {
        "firstname":"Jim",
         "additionalneeds":"Breakfast",
         "bookingdates":{
                        "checkin":"2018-01-01",
                        "checkout":"2019-01-01"
                        },
        "totalprice":111,
        "depositpaid":true,
         "lastname":"Brown"
        }
         */


    @Test
    public void JSONData(){
        JSONObject jsondata = new JSONObject();

        jsondata.put("title","Ahmet");
        jsondata.put("body","Merhaba");
        jsondata.put("userId",1);

        System.out.println("ılK OLUSTURDUGUM JSON DATA: "+jsondata);
    }


    @Test
    public void innerJson(){
        JSONObject innerJsonObj = new JSONObject();
        innerJsonObj.put("checkin","2018-01-01");
        innerJsonObj.put("checkout","2019-01-01");

        JSONObject jsonData = new JSONObject();
        jsonData.put("firstname","Jim");
        jsonData.put("additionalneeds","Breakfast");
        jsonData.put("bookingdates",innerJsonObj);
        jsonData.put("totalprice",111);
        jsonData.put("depositpaid",true);
        jsonData.put("lastname","Brown");

        System.out.println("jsonData :"+ jsonData);
    }
}
