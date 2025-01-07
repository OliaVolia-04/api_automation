package api;

import com.github.javafaker.Faker;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.Config;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.CashWiseAuthorization;

public class PojoPractice {

    @Test
    public void createCategory() {
        String url = "https://backend.cashwise.us/api/myaccount/categories";
        String token = CashWiseAuthorization.getToken();

        RequestBody requestBody = new RequestBody();
        requestBody.setCategory_title("transportation");
        requestBody.setDescription("uber rides");
        requestBody.setFlag(true);

        Response response = RestAssured.given()
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        int status = response.statusCode();
        Assert.assertEquals(201, status);
    }

    @Test
    public void testCustom() throws JsonProcessingException {
        String url = "https://backend.cashwise.us/api/myaccount/categories";
        String token = CashWiseAuthorization.getToken();

        RequestBody requestBody = new RequestBody();
        requestBody.setCategory_title("study");
        requestBody.setCategory_description("coding classes");
        requestBody.setFlag(true);

        Response response = RestAssured.given()
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        int status = response.getStatusCode();

        Assert.assertEquals(201, status);

        response.prettyPrint();

        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);

        String expectedTitle = customResponse.getCategory_title();
        String expectedCategory_description = customResponse.getCategory_description();


        Assert.assertEquals(expectedTitle, "study");
        Assert.assertEquals(expectedCategory_description, "coding classes");

    }

    @Test
    public void createGetSeller() throws JsonProcessingException {
        String url = "https://backend.cashwise.us/api/myaccount/sellers";
        String token = CashWiseAuthorization.getToken();

        Faker faker = new Faker();

        RequestBody requestBody = new RequestBody();

        requestBody.setSeller_name("Ilon Mask");
        requestBody.setCompany_name("Tesla");
        requestBody.setPhone_number("123456778990");
        requestBody.setAddress("2250 Devon Ave");
        requestBody.setEmail(faker.internet().emailAddress());

        Response response = RestAssured.given()
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        int status = response.statusCode();

        Assert.assertEquals(201, status);

        ObjectMapper mapper = new ObjectMapper();

        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);

        int id = customResponse.getSeller_id();


        String url1 = "https://backend.cashwise.us/api/myaccount/sellers/" + id;

        Response response1 = RestAssured.given()
                .auth()
                .oauth2(token)
                .get(url1);

        int status2 = response1.getStatusCode();

        Assert.assertEquals(200, status2);

        String expectedSellerName = customResponse.getSeller_name();
        Assert.assertEquals("Ilon Mask", expectedSellerName);

        String expectedCompanyName = customResponse.getCompany_name();
        Assert.assertEquals("Tesla", expectedCompanyName);


    }
}
