package api;

import com.jayway.restassured.response.Response;
import dto.AuthResponseDTO;
import dto.UserDtoLombok;

import static com.jayway.restassured.RestAssured.given;

public class UserApi extends BaseApi {

    Response responseLogin = null;

    private Response loginRequest(UserDtoLombok user) {
        responseLogin = given().body(user)
                .when()
                .post(baseUrl + "/v1/user/login/usernamepassword")
                .thenReturn();
        return responseLogin;
    }

    public void setResponseLoginNull() {
        responseLogin = null;
    }

    public int getStatusCodeResponseLogin(UserDtoLombok user) {
        if(responseLogin == null) {
            responseLogin = loginRequest(user);
        }
        return responseLogin.getStatusCode();
    }

    public String getTokenFromLoginResponse(UserDtoLombok user) {
        if(responseLogin == null) {
            responseLogin = loginRequest(user);
        }
        return responseLogin.getBody().as(AuthResponseDTO.class).getToken();
    }

}
