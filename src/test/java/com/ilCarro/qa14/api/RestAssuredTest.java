package com.ilCarro.qa14.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredTest {
    private String baseURL = "https://java-3-ilcarro-team-b.herokuapp.com";
    @Test
    public void registrationNewUserPositiveTest(){
        RequestSpecification httpRequest = io.restassured.RestAssured.given();

        Response response = httpRequest.
                given().contentType(ContentType.JSON)
                .given().header("Authorization", "Basic YW55YUBnbS5jb206eXVld3llZ3NkeXc3NjZBNiE=")
                .request().body("{\n" +
                        "  \"first_name\": \"Tester\",\n" +
                        "  \"second_name\": \"Tester\"\n" +
                        "}")
                .when().post(baseURL+ "/registration");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        //JsonElement parsed = new JsonParser().parse(responseBody);
        JsonObject parsedObject = JsonParser.parseString(responseBody).getAsJsonObject();
       // String fName = parsedObject.getAsJsonObject().get("first_name").toString();
        JsonElement fName = parsedObject.get("first_name");
        System.out.println(fName);

        Assert.assertEquals(statusCode,200, "Bug:status code is coming different");
    }

    @Test
    public void deleteRegestatedUserPositiveTest(){
        RequestSpecification httpRequest = io.restassured.RestAssured.given();
        Response response = httpRequest.given().header("Authorization", "Basic YW55YUBnbS5jb206eXVld3llZ3NkeXc3NjZBNiE=")
                .request().when().delete(baseURL+"/user");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "OK!");
    }
}
