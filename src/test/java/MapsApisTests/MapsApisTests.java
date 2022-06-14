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

    @Test(priority = 3)
    public void addFeedbackValidPayLoad() {
        RestAssured.baseURI = dataparser.getPropertyValue("roadSignFeedBackURI");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.headers(createValidheaders()).body(createValidPayload()).post();
        int statusCode = response.getStatusCode();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        Assert.assertEquals(statusCode, 200);
        Assert.assertTrue(bodyAsString.contains("The speed limit is now 100 km/h"));

    }

    @Test(priority = 4)
    public void addFeedbackWithInvalidPayload() {
        RestAssured.baseURI = dataparser.getPropertyValue("roadSignFeedBackURI");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.headers(createValidheaders()).body(createInValidPayload()).post();
        int statusCode = response.getStatusCode();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        Assert.assertEquals(statusCode, 500);
        Assert.assertTrue(bodyAsString.contains("Failed to read Feedback as Maphub object, missing valid type for feedback"));

    }
}
