import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.specification.ProxySpecification.auth;
import static org.hamcrest.Matchers.equalTo;

public class IntroToPostRequest {
    public static void main(String[] args) {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";


        JSONObject requestBody = new JSONObject();
        requestBody.put("product_title", "Lagmar");
        requestBody.put("product_price", 32);
        requestBody.put("service_type_id", 2);
        requestBody.put("category_id", 1234);
        requestBody.put("product_description", "Italian");
        requestBody.put("date_of_payment", "2024-12-03");
        requestBody.put("remind_before_day", 1);
        requestBody.put("do_remind_every_month", "REPEAT_EVERY_MONTH");


        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth()
                .oauth2(token)
                .baseUri("")
                .body(requestBody.toString())
                .when()
                .post("/myaccount/products")
                .then()
                .statusCode(201)
                .body("product title", equalTo("Lagmar"))
                .body("product_price", equalTo(32));




        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .baseUri("")
                .body(requestBody.toString())
                .when()
                .post("endpoint");
    }
}
