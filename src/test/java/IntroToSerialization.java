import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import pojo.Tag;

import java.util.Arrays;

import static com.google.common.base.Predicates.equalTo;

public class IntroToSerialization {
    public static void main(String[] args) {

        /* create a tag
         */

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";


        // 1. Create pojo object
        Tag tag = new Tag();
        tag.setName_tag("pineapple");
        tag.setDescription("this is pineapple tag");

        //2. serialize pojo object to json object
        Gson gson = new Gson();
        String requestBodyInJson = gson.toJson(tag);
        System.out.println(requestBodyInJson);


        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .baseUri("https://backend.cashwise.us/api")
                .body(requestBodyInJson)
                .when()
                .post("/myaccount/tags");
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
//                .then()
//                .statusCode(201)
//                .body("name_tag", Matchers.equalTo(tag.getName_tag()));

        // 3. deserialize json to java

        String responseInJson = response.asString();
        gson = new Gson();
        Tag tagResponse = gson.fromJson(responseInJson, Tag.class);

        System.out.println(tagResponse.getMessage());
        System.out.println(Arrays.toString(tagResponse.getDetails()));

        //  Assert.assertTrue(tagResponse.getName_tag().equals(tag.getName_tag()));

    }
}
