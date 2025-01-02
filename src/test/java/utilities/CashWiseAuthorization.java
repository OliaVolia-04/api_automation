package utilities;

import antitis.RequestBody;
import io.restassured.RestAssured;
import io.restassured.config.Config;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CashWiseAuthorization {

    public static String getToken() {
        String url = "https://backend.cashwise.us/api/myaccount/auth/login";
        RequestBody requestBody = new RequestBody();
        requestBody.setEmail("oliavolianska7@gmail.com");
        requestBody.setPassword("tombim907");

        Response response = RestAssured.given(). // restAssured is a library how we hit the api
                contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        return response.jsonPath().getString("jwt_token"); // utility method to receive the token


    }
}
