package testDatas;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataHerOkuApp {

    public int okStatusKodu = 200;
    /*
    Request body
      {
      "firstname" : "Ali",
      "lastname" : "Bak",
      "totalprice" : 500,
      "depositpaid" : false,
      "bookingdates" : {
                     "checkin" : "2021-06-01",
                     "checkout" : "2021-06-10"
                       },
      "additionalneeds" : "wi-fi"
       }
     */

    public JSONObject bookingDatesOlustur(){
       JSONObject bookingDates = new JSONObject();
       bookingDates.put("checkin" , "2021-06-01");
       bookingDates.put("checkout" , "2021-06-10");
       return bookingDates;
    }

    public JSONObject reqBodyOlusturJSON(){
        JSONObject booking = new JSONObject();
        booking.put("firstname" , "Ali");
        booking.put("lastname" , "Bak");
        booking.put("totalprice" , 500);
        booking.put("depositpaid" , false);
        booking.put("bookingdates" , bookingDatesOlustur());
        booking.put("additionalneeds" ,"wi-fi");

        return booking;
    }

    public JSONObject expBodyOlusturJSON(){
        /*
        Expected Body
{
   "bookingid":24,
   "booking":{
           "firstname":"Ali",
           "lastname":"Bak",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
                           "checkin":"2021-06-01",
                           "checkout":"2021-06-10"
                           },
           "additionalneeds":"wi-fi"
              }
         */

        JSONObject expData = new JSONObject();
        expData.put("bookingid",24);
        expData.put("booking",reqBodyOlusturJSON());

        return expData;

    }

    public HashMap<String,Object> bookingdatesMAP(){
        HashMap<String,Object>  bookingdates  = new HashMap<>();
        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");
        return bookingdates;
    }

    public HashMap<String,Object> reqBodyOlusturMAP(){
        HashMap<String,Object>  reqBodyOlustur  = new HashMap<>();
        reqBodyOlustur .put("firstname" , "Ahmet");
        reqBodyOlustur .put("lastname" , "Bulut");
        reqBodyOlustur .put("totalprice" , 500);
        reqBodyOlustur .put("depositpaid" , false);
        reqBodyOlustur .put("bookingdates" , bookingdatesMAP());
        reqBodyOlustur .put("additionalneeds" ,"wi-fi");

        return reqBodyOlustur;
    }

    public HashMap<String,Object> expBodyOlusturMAP(){
        HashMap<String,Object>  expBodyOlustur  = new HashMap<>();
        expBodyOlustur.put("bookingid",24);
        expBodyOlustur.put("booking",reqBodyOlusturMAP());

        return expBodyOlustur;
    }

}
