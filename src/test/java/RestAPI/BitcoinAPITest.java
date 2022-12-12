package RestAPI;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BitcoinAPITest {

    @Test
    public void verifyStatusCodeIs200(){
        given().when().get("https://api.coindesk.com/v1/bpi/currentprice.json").then().statusCode(200);

    }

    @Test
    public void getStatusCode(){
        int StatusCode= given().
                when().
                        get("https://api.coindesk.com/v1/bpi/currentprice.json").
                                                                                      getStatusCode();
        System.out.println("The StatusCode is: "+StatusCode);
        Assert.assertTrue(StatusCode==200);
    }

    @Test
    public void getResponseBody(){
      given().when().
                get("https://api.coindesk.com/v1/bpi/currentprice.json").then().log().body();

    }

    @Test
    public void getStatus(){
        given().when().
                get("https://api.coindesk.com/v1/bpi/currentprice.json").getStatusCode();

    }

}
