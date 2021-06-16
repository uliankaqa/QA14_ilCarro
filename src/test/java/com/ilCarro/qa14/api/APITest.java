package com.ilCarro.qa14.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class APITest {
    private String baseURL = "https://java-3-ilcarro-team-b.herokuapp.com";
    @Test
    public void loginRegisteredUserPositiveTest() throws IOException {
        String response = getAuthorisationUser("/user/login", "Authorization", "dWxpdHJ1bGlAdWxpLmNvbTpVbGlUUlVMSTIzNDUh");
        System.out.println("RESPONSE: "  + response);
        //JsonElement parser = new JsonParser().parse(response);
       // JsonElement name = parser.getAsJsonObject().get("first_name");
        JsonObject parsedObject = JsonParser.parseString(response).getAsJsonObject();
        JsonElement name = parsedObject.get("first_name");
        Assert.assertEquals(name.toString(), "\"uli\"");

        //"registration_date":"2021-05-25"
        JsonElement registrationData = parsedObject.getAsJsonObject().get("registration_date");
        Assert.assertEquals(registrationData.toString(), "\"2021-05-25\"");



    }

    @Test
    public void  loginRegisteredUserNegativeTest() throws IOException {
       int statusCod =  Request.Get(baseURL+"/user/login")
                .addHeader("Authorization", "dWxpdHJ1bGlAdWxpLmNvbTpVbGlUUlVMSTIzND")
                .execute().returnResponse().getStatusLine().getStatusCode();
       Assert.assertEquals(statusCod, 401);
    }

    @Test
    public void postNewUserRegistrationTest() throws IOException {
        String response = Request.Post(baseURL + "/registration")
                .addHeader("Authorization", "YW55YUxpbUBnbWFpbC5jb206c0Y0NTU2IXdldzY2")
                .bodyString("{\n" +
                        "  \"first_name\": \"anya\",\n" +
                        "  \"second_name\": \"liman\"\n" +
                        "}", ContentType.APPLICATION_JSON)
                .execute().returnContent().asString();
        System.out.println(response);
    }

    @Test
    public void deleteRegestretedUserPositiveTest() throws IOException {
        int response = Request.Delete(baseURL + "/user" )
                .addHeader("Authorization","YW55YUxpbUBnbWFpbC5jb206c0Y0NTU2IXdldzY2")
                .execute().returnResponse().getStatusLine().getStatusCode();
        Assert.assertEquals(response, 200,"OK!");
    }

    @Test
    public void deleteRegestretedUserWithWrongEmailNegativeTest() throws IOException {
        int response = Request.Delete(baseURL + "/user" )
                .addHeader("Authorization","YW55YUxpbS5jb206c0Y0NTU2IXdldzY2")
                .execute().returnResponse().getStatusLine().getStatusCode();
        Assert.assertEquals(response, 400, "Error! Bad request");
    }

    @Test
    public void deleteRegestretedUserWithWrongPassNegativeTest() throws IOException {
        int response = Request.Delete(baseURL + "/user" )
                .addHeader("Authorization","YW55YUxpbUBnbWFpbC5jb206c0Y0NTU2IXdzZ2Ro")
                .execute().returnResponse().getStatusLine().getStatusCode();
        Assert.assertEquals(response, 401, "Error! User unauthorized");
    }

    private String getAuthorisationUser(String controller, String key, String value) throws IOException {
        return Request.Get(baseURL + controller)
                .addHeader(key, value)
                .execute().returnContent().asString();
    }
}
