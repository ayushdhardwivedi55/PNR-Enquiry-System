package PNR;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PNRTest { 

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:3000";
    }
    
    @Test
    public void testGetPNRDetails() {
        String pnrNumber = "947654321";
        Response response = given()
                .queryParam("pnrNumber", pnrNumber)
                .when()
                .get("/pnrStatuses");

        response.then().statusCode(200);
        response.then().time(lessThan(1077L));

        response.then().header("Content-Type", "application/json");
        response.then().body("pnrNumber", hasItem(pnrNumber));
        response.then().body("passengerDetails[0].name", hasItem("Ayush Dwivedi"));
        response.then().body("passengerDetails[0].status", hasItem("Confirmed"));

        // now we are validate that the passenger array contains 1 entry
        response.then().body("passengerDetails.size()", equalTo(3));
    }

    @Test
    public void testGetPNRDetails_RAC() {
        String pnrNumber = "947654";

        Response response = given()
                .queryParam("pnrNumber", pnrNumber)
                .when()
                .get("/pnrStatuses");

        response.then().statusCode(200);

        response.then().body("pnrNumber", hasItem(pnrNumber));
        response.then().body("passengerDetails[0].name", hasItem("Ravi Kumar"));
        response.then().body("passengerDetails[0].status", hasItem("RAC"));

        response.then().body("passengerDetails.size()", equalTo(1));
    }

    @Test
    public void testGetPNRDetails_Waiting() {
        String pnrNumber = "94754321";

        Response response = given()
                .queryParam("pnrNumber", pnrNumber)
                .when()
                .get("/pnrStatuses");

        response.then().statusCode(200);

        response.then().body("pnrNumber", hasItem(pnrNumber));
        response.then().body("passengerDetails[0].name", hasItem("Sita Devi"));
        response.then().body("passengerDetails[0].status", hasItem("Waiting"));

        response.then().body("passengerDetails.size()", equalTo(1));
    }

    @AfterClass
    public void AfterAllTests() {
        System.out.println("Hurray! All tests are executed successfully");
    }
}