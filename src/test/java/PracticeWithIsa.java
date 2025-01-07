//import antitis.CustomResponse;
//import antitis.RequestBody;
//import com.sun.net.httpserver.Request;
//import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
//import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import lombok.SneakyThrows;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import utilities.ApiRunner;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class PracticeWithIsa {
//
//    @SneakyThrows
//    @Test
//    public void getSingleSeller() {
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
//        String url = "https://backend.cashwise.us/api/myaccount/sellers/" + 5978;
//
//        Response response = RestAssured.given()
//                .auth()
//                .oauth2(token).get(url);
//        Object mapper = new ObjectMapper();
//        CustomResponse customResponse;
//        customResponse = ((ObjectMapper) mapper).readValue(response.asString(), CustomResponse.class);
//        String email = customResponse.getEmail();
//        Assert.assertTrue(email.isEmpty());
//    }
//
//
//    @SneakyThrows
//    @Test
//    public void CreateSeller() {
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
//        String url = "https://backend.cashwise.us/api/myaccount/sellers/";
//
//        RequestBody requestBody = new RequestBody();
//        requestBody.setCompany_name("Juice Factory");
//        requestBody.setSeller_name("Jacky");
//        requestBody.setEmail("jacky@gmail.com");
//        requestBody.setPhone_number("32456869467");
//        requestBody.setAddress("789  S Orange Ave");
//
//        Response response = RestAssured.given()
//                .auth()
//                .oauth2(token)
//                .contentType(ContentType.JSON)
//                .body(requestBody)
//                .post(url);
//
////        ObjectMapper mapper = new ObjectMapper();
////
////        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
////
////        int id = customResponse.getSeller_id();
////        String url2 = "https://backend.cashwise.us/api/myaccount/sellers/";
////
////        RestAssured.given()
////                .auth()
////                .oauth2(token)
////                .get(url2 + id);
////        String expectedCompanyName = customResponse.getCompany_name();
////        Assert.assertEquals("Juice Factory", expectedCompanyName);
////
//
//    }
//
//    @SneakyThrows
//    @Test
//    public void GetAllSellers() {
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
//        String url = "https://backend.cashwise.us/api/myaccount/sellers/";
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("isArchived", false);
//        params.put("page", 1);
//        params.put("size", 60);
//
//        Response response = RestAssured.given()
//                .auth()
//                .oauth2(token)
//                .params(params)
//                .get(url);
//
//        int status = response.getStatusCode();
//
//        Assert.assertEquals(200, status);
//
////        response.prettyPrint();
//
//        ObjectMapper mapper = new ObjectMapper();
//        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
//
//        // HOW TO GET THE SIZE OF THE LIST
//        // we are getting Responses from  CustomResponse Class in antitis package
//        int size = customResponse.getResponses().size();
//
//// Looping through to check every single email from the list
//        for (int i = 0; i < size; i++) {
//            String email = customResponse.getResponses().get(i).getEmail();
//            Assert.assertFalse(email.isEmpty());
//
//        }
//    }
//
//    @Test
//    public void ListOfProducts() throws JsonProcessingException {
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzU3NDQ1MzYsImlhdCI6MTczMzE1MjUzNiwidXNlcm5hbWUiOiJvbGlhdm9saWFuc2thN0BnbWFpbC5jb20ifQ.VK1kF1J0ir4kZd1ug4omDFGpkcb9uInAyogt3noIUqW7zZnbM4kl-vgNSxJIDImgz0fjNHk_36iC6lpJSzJx6g";
//        String url = "https://backend.cashwise.us/api/myaccount/products/";
//
//        Map<String, Object> params = new HashMap();
//        params.put("page", 1);
//        params.put("size", 20);
//
//        Response response = RestAssured.given()
//                .auth()
//                .oauth2(token)
//                .params(params)
//                .get(url);
//
//        ObjectMapper mapper = new ObjectMapper();
//        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
//
//        int size = customResponse.getResponses().size();
//        System.out.println(size);
//
//        for (int i = 0; i < size; i++) {
//            String productTitle = customResponse.getResponses().get(i).getProduct_title();
//            int id = customResponse.getResponses().get(i).getCategory_id(); // list of id
//            System.out.println(id);
//            Assert.assertFalse(productTitle.isEmpty());
//            // the code does not work, needs to work on the nested loop withing the objects
//        }
//    }
//
//    @Test
//    public void TestGet() {
//        ApiRunner.runGet("/api/myaccount/sellers" + 5998);
//        String companyName = ApiRunner.getCustomResponse().getCompany_name();
//        Assert.assertEquals("Green Company", companyName);
//    }
//
//
//    @Test
//    public void TestAllSellers() {
//        Map<String, Object> params = new HashMap<>();
//        String url = "/api/myaccount/sellers";
//        params.put("isArchived", false);
//        params.put("page", 1);
//        params.put("size", 60);
//
//        ApiRunner.runGet(url, params);
//        int size = ApiRunner.getCustomResponse().getResponses().size();
//        System.out.println(size);
//
//    }
//
//
//    @Test
//    public void PostSeller() {
//        RequestBody requestBody = new RequestBody();
//        requestBody.setCompany_name("whatever");
//        requestBody.setSeller_name("whoever");
//        requestBody.setEmail("emailwhatever@gmail.com");
//        requestBody.setPhone_number("123456789876");
//        requestBody.setAddress("wherever");
//
//        ApiRunner.runPost("/api/myaccount/sellers", requestBody);
//
//    }
//
//
//    @Test
//    public void testDelete() {
//        int id = 2711;
//        String endPoint = "/api/myaccount/products";
//
//        ApiRunner.runDelete(endPoint + id);
//
//    }
//
//    @Test
//    public void TestPut() {
//        String endPoint = "/api/myaccount/sellers" + 5998;
//
//        RequestBody requestBody = new RequestBody();
//
//        requestBody.setSeller_name("panas");
//        requestBody.setCompany_name("fridge company");
//        requestBody.setEmail("panas@gmail.com");
//        requestBody.setPhone_number("2345678998765");
//        requestBody.setAddress("Vyl. Nebo 45");
//
//        ApiRunner.runPut(endPoint, requestBody);
//
//    }
//}
//
//
