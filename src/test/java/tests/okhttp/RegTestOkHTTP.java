package tests.okhttp;

import com.google.gson.Gson;
import dto.AuthResponseDTO;
import dto.ErrorDTO;
import dto.ErrorDTOReg;
import dto.UserDtoLombok;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.UUID;

public class RegTestOkHTTP  {
    public static String generateRandomEmail() {
        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        String domain = "example.com";
        return randomString + "@" + domain;
    }
        String email = generateRandomEmail();
    UserDtoLombok user = UserDtoLombok.builder()
            .username(email)
            .password("123456Aa$")
            .build();
    public static final MediaType JSON = MediaType.get("application/json");
    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();
    String baseUrl = "https://contactapp-telran-backend.herokuapp.com";
   
    @Test
    public void registrationPositive(){
        RequestBody requestBody = RequestBody.create(gson.toJson(user), JSON);
        Request request = new Request.Builder()
                .url(baseUrl + "/v1/user/registration/usernamepassword")
                .post(requestBody)
                .build();
        Response response;
        try {
            response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(response == null) {
            Assert.fail("got null response");
        } else if (response.isSuccessful()) { //  return OK 200 and token
            String responseJson;
            try {
                responseJson = response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            AuthResponseDTO authResponseDTO = gson.fromJson(responseJson, AuthResponseDTO.class);
            System.out.println(authResponseDTO.getToken());
            System.out.println(response.code());
            System.out.println(response.message());
            Assert.assertEquals(response.code(), 200, "response not 200");
        } else {
            System.out.println(response.code() + " error");
            Assert.fail("response not successfully");
        }
    }
    @Test
    public void negativeRegistration (){
        UserDtoLombok userNegative = UserDtoLombok.builder()
                .username("extern@gmail.com")
                .password("123456Aa")
                .build();
        RequestBody requestBody = RequestBody.create(gson.toJson(userNegative), JSON);
        Request request = new Request.Builder()
                .url(baseUrl + "/v1/user/registration/usernamepassword")
                .post(requestBody)
                .build();
        Response response;
        try {
            response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(response == null) {
            Assert.fail("got null response");
        } else if (response.isSuccessful()) { //  return OK 200 and token
            Assert.fail("got response with status code : " + response.code());
        } else {
            String responseJson;
            try {
                responseJson = response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ErrorDTOReg errorDTO = gson.fromJson(responseJson, ErrorDTOReg.class);
            System.out.println(response.code());
            System.out.println(response.message());
            System.out.println("string error: " + errorDTO.getError());
            System.out.println("int status " + errorDTO.getStatus());
            Assert.assertEquals(response.code(), 400, "response not 400");
        }

    }

}
