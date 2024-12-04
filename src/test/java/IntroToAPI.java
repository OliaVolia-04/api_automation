import com.sun.net.httpserver.Request;
import io.restassured.RestAssured;
import org.testng.reporters.jq.Main;

import static io.restassured.RestAssured.given;

public class IntroToAPI {
    public static void main(String[] args) {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";

        RestAssured.given()
                .auth()
                .oauth2(token)
                .baseUri("https://backend.cashwise.us/api")
                .when()
                .get("/myaccount/sellers/all")
                .then()
                .statusCode(200);


        RestAssured.given()
                .auth()
                .oauth2(token)
                .baseUri("https://backend.cashwise.us/api")
                .when()
                .get("/myaccount/tags/all")
                .then()
                .statusCode(200);


        RestAssured.given()
                .auth()
                .oauth2(token)
                .baseUri("https://backend.cashwise.us/api")
                .and()
                .queryParam("page", "1")
                .queryParam("size", "4")
                .when()
                .get("/myaccount/reminder/requests")
                .then()
                .statusCode(200);


        RestAssured.given()
                .auth()
                .oauth2(token)
                .baseUri("https://backend.cashwise.us/api")
                .when()
                .get("/myaccount/reminder/notifications")
                .then()
                .statusCode(200);



    }
}
