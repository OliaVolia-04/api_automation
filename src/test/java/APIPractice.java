import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class APIPractice {
    public static void main(String[] args) {


        // GETTING ALL SELLERS BY USING HASHMAP

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
        String url = "https://backend.cashwise.us/api/myaccount/sellers";
        Map<String, Object> parameters = new HashMap();
        parameters.put("isArchived", false);
        parameters.put("page", 1);
        parameters.put("size", 10);


        Response response = RestAssured.given().auth().oauth2(token).params(parameters).get(url);
        System.out.println(response.prettyPrint());
        System.out.println("--------------------");
        System.out.println(response.statusCode());
    }

    @Test
    public void reqres() {
        String url = "https://reqres.in/api/users/7";
        Response response = RestAssured.get(url);
//        System.out.println(response.statusCode());
//        System.out.println("---------------------");
//        System.out.println(response.prettyPrint());


//        String expectedSupportText = "Tired of writing endless social media content? Let Content Caddy generate if for you";
//        int responseStatusCode = 200;
//        Assert.assertEquals(response.jsonPath().get("data.text"),expectedSupportText);
//
        // HOW TO GET VALUES FROM JSON FILES
        String email = response.jsonPath().get("data.email");
        System.out.println(email);
    }

    @Test
    public void getAllSellersTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
        String url = "https://backend.cashwise.us/api/myaccount/sellers";
        Map<String, Object> parameters = new HashMap();
        parameters.put("isArchived", false);
        parameters.put("page", 1);
        parameters.put("size", 10);

        Response response = RestAssured.given().auth().oauth2(token).params(parameters).get(url);
        System.out.println(response.prettyPrint());

        Assert.assertTrue(response.statusCode() == 200);
        String url1 = "https://backend.cashwise.us/api/myaccount/sellers";
        String sellerId = response.jsonPath().get("[0].seller_id");

        Response response1 = RestAssured.given().auth().oauth2(token).get(url1);
        Assert.assertTrue(response1.statusCode() == 200);
        int actualSellerId = (response1.jsonPath().get("seller_id"));
        Assert.assertTrue(sellerId.equals(actualSellerId));
        System.out.println(response1.prettyPrint());


//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
//        String endpoint = "/api/myaccount/sellers";
//
//        Map<String, Object> params = new HashMap();
//        params.put("isArchived", false);
//        params.put("page", 1);
//        params.put("size", 10);
//
//        Response response = RestAssured.given().auth().oauth2(token).params(params).get(token) + endpoint);
//        System.out.println(response.prettyPrint());
//        Assert.assertTrue(response.statusCode() == 200);
//
//        int sellerId = response.jsonPath().get("responses[0].seller_id");
//
//        Response response1 = RestAssured.given().auth().oauth2(token).get(token) + endpoint + "/" + sellerId);
//        Assert.assertTrue(response1.statusCode() == 200);
//        int actualSellerId = (response1.jsonPath().get("seller_id"));
//        Assert.assertTrue(sellerId == actualSellerId);


        String URL1 = "https://backend.cashwise.us/api/myaccount/sellers";
        int seller_id = (response.jsonPath().get("responses[0].seller_id"));

        Response response2 = RestAssured.given()
                .auth()
                .oauth2(token)
                .delete(URL1 + "/" + seller_id);
        Assert.assertTrue(response2.statusCode() == 200);

        Response response3 = RestAssured.given()
                .auth()
                .oauth2(token)
                .get(URL1 + "/" + seller_id);
        Assert.assertTrue(response3.statusCode() != 200);
    }

}