package utilities;

import antitis.CustomResponse;
import antitis.RequestBody;
import com.sun.net.httpserver.Request;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;

import java.util.Map;

public class ApiRunner {
    @Getter
    private static CustomResponse customResponse;

    // this is a get method, get without any parameters
    public static void runGet(String path) {
        String url = ("https://backend.cashwise.us") + path; // path is the endpoint
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
        Response response = RestAssured.given()
                .auth()
                .oauth2(token)
                .get(url);
        response.getStatusCode();

        ObjectMapper mapper = new ObjectMapper();
        try {
            customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    // this is a get method that takes parameters
    public static void runGet(String path, Map<String, Object> params) {
        String url = ("https://backend.cashwise.us") + path; // path is the endpoint
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
        Response response = RestAssured.given()
                .auth()
                .oauth2(token)
                .params(params)
                .get(url);
        response.getStatusCode();

        ObjectMapper mapper = new ObjectMapper();
        try {
            customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    // this is the method to post with Request Body
    public static void runPost(String path, RequestBody requestBody) {
        String url = ("https://backend.cashwise.us") + path; // path is the endpoint
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
        Response response = RestAssured.given()
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);
        response.getStatusCode();

        ObjectMapper mapper = new ObjectMapper();
        try {
            customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // this is the post method that takes parameters

    public static void runPost(String path, Map<String, Object> params) {
        String url = ("https://backend.cashwise.us") + path; // path is the endpoint
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
        Response response = RestAssured.given()
                .auth()
                .oauth2(token)
                .params(params)
                .post(url);
        System.out.println(response.getStatusCode());

        ObjectMapper mapper = new ObjectMapper();
        try {
            customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // this is delete method that only takes token and url
    public static void runDelete(String path) {
        String url = ("https://backend.cashwise.us") + path; // path is the endpoint
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
        Response response = RestAssured.given()
                .auth()
                .oauth2(token)
                .delete(url);
        System.out.println(response.getStatusCode());
    }



    // this is put method that takes request body
    public static void runPut(String path, RequestBody requestBody) {
        String url = ("https://backend.cashwise.us") + path; // path is the endpoint
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
        Response response = RestAssured.given()
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(url);
        System.out.println(response.getStatusCode());

        ObjectMapper mapper = new ObjectMapper();
        try {
            customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}



