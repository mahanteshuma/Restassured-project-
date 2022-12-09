package RestAPI;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class WeatherAPITest {


    String key="c8fa75d15a22c9b85059ae57403e52fc";
    String url="https://api.openweathermap.org/data/2.5/weather";

    @Test
    public void getWeatherByCityName(){

     given().queryParam("q", "Pune").
             queryParam("appid", key).
             when().get(url).
             then().log().body();
    }


    @Test
    public void validateCountry(){
      String country= given().queryParam("q","Pune")
                .queryParam("appid",key)
                .when().get(url)
                .then().extract().path("sys.country");

        Assert.assertTrue(country.equals("IN"));
        System.out.println(country);

    }

    @Test
    public void validateWeather(){
        String mainWeather= given().queryParam("q","Pune")
                                 .queryParam("appid",key)
                                 .when().get(url)
                                 .then().extract().path("weather[0].main");

        Assert.assertTrue(mainWeather.equals("Clouds"));
        System.out.println(mainWeather);

    }

    @Test
    public void validateHeaders(){
        given().queryParam("q","Pune")
                .queryParam("appid",key)
                .when().get(url)
                .then().log().headers();

    }


    @Test
    public void validateServerHeader(){
        given().queryParam("q","Pune")
                .queryParam("appid",key)
                .when().get(url)
                .then().assertThat().headers("Server","openresty");

    }

    @Test
    public void validateContentType(){
        given().queryParam("q","Pune")
                .queryParam("appid",key)
                .when().get(url)
                .then().assertThat().headers("Content-Type","application/json; charset=utf-8");

    }

}
