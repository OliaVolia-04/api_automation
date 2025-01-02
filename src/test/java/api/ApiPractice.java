package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CashWiseAuthorization;

import java.util.HashMap;
import java.util.Map;

public class ApiPractice {
    @Test
    public void TestEmail() {
        String token = CashWiseAuthorization.getToken();
        String url = "https://backend.cashwise.us/api/myaccount/sellers";

        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 10);

        Response response = RestAssured.given().
                auth().
                oauth2(token).
                params(params).
                get(url);

        String email = response.jsonPath().getString("responses[0].email");
        String email2 = response.jsonPath().getString("responses[1].email");
        String email3 = response.jsonPath().getString("responses[2].email");


        int status = response.statusCode();
        Assert.assertEquals(200, status);
        Assert.assertFalse(email.isEmpty());
        Assert.assertFalse(email2.isEmpty());
        Assert.assertFalse(email3.isEmpty());
    }


    @Test
    public void improvedAllSellers() {
        String token = CashWiseAuthorization.getToken();
        String url = "https://backend.cashwise.us/api/myaccount/sellers";

        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 100);

        Response response = RestAssured.given().
                auth().
                oauth2(token).
                params(params).
                get(url);

        int size = response.jsonPath().getList("responses").size();

        int status = response.statusCode();
        Assert.assertEquals(200, status);


        for (int i = 0; i < size; i++) {
            String email = response.jsonPath().getString("responses[" + i + "].email");
            Assert.assertFalse(email.isEmpty());

        }
    }

    @Test
    public void getAllBankAccounts() {
        String token = CashWiseAuthorization.getToken();
        String url = "https://backend.cashwise.us/api/myaccount/bankaccount";

        Response response = RestAssured.given().
                auth().
                oauth2(token).
                get(url);

        int statusCode = response.statusCode();
        Assert.assertEquals(200, statusCode);

        int size = response.jsonPath().getList("JSON").size();
    }

    @Test
    public void postBankAccount() {
        String token = CashWiseAuthorization.getToken();
        String url = "https://backend.cashwise.us/api/myaccount/bankaccount";

        RequestBody requestBody = new RequestBody();

        requestBody.setType_of_pay("CASH");
        requestBody.setBank_account_name("Selfreliance Union");
        requestBody.setDescription("This is my checking account");
        requestBody.setBalance(7000);

        Response response = RestAssured.given().
                auth().
                oauth2(token).
                contentType(ContentType.JSON).
                body(requestBody).
                post(url);

        int status = response.statusCode();
        Assert.assertEquals(200, response.getStatusCode());

        int size = response.jsonPath().getList("JSON").size();

        String expectedBankAccountName = "Selfreliance Union";
        boolean isPresent = false;
        for (int i = 0; i < size; i++) {
            String bankAccountName = response.jsonPath().getString("[" + i + "].bank_account_name");
            if (bankAccountName.equalsIgnoreCase(expectedBankAccountName)) {
                isPresent = true;
            }
        }
        Assert.assertTrue(isPresent);
    }
}





