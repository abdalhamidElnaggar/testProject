package MapsApisTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MapsApisTests extends ApisBaseTest {


    @Test(priority = 1)
    public void testUnAuthorized() {
        RestAssured.baseURI = dataparser.getPropertyValue("baseURI");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.queryParam("apikey", dataparser.getPropertyValue("ApiInvalidKey")).
                queryParam("at", "52.5228,13.4124").
                queryParam("q", "cairo").
                get();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 401);

    }

    @Test(priority = 2)
    public void discoverPlace() {

        RestAssured.baseURI = dataparser.getPropertyValue("baseURI");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.queryParam("apikey", dataparser.getPropertyValue("ApiValidkey")).
                queryParam("at", "52.5228,13.4124").
                queryParam("q", "cairo").
                get();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
        Assert.assertEquals(response.header("Content-Type"), "application/json");
        Assert.assertTrue(bodyAsString.contains("Cairo"));


    }
}
