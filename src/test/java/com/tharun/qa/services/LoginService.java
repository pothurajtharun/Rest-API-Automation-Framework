package com.tharun.qa.services;

import static com.tharun.qa.constants.ApiConstants.LOGIN_ENDPOINT;
import static com.tharun.qa.constants.ApiConstants.USER_EMAIL;
import static com.tharun.qa.constants.ApiConstants.USER_PASSWORD;
import static io.restassured.RestAssured.given;

import com.tharun.qa.models.request.LoginRequest;
import com.tharun.qa.models.response.LoginResponse;
import io.restassured.http.ContentType;

public class LoginService extends BaseService {

  public LoginResponse login() {
    LoginRequest loginPayload =
        LoginRequest.builder().userEmail(USER_EMAIL).userPassword(USER_PASSWORD).build();

    return given()
        .spec(spec)
        .contentType(ContentType.JSON)
        .body(loginPayload)
        .when()
        .post(LOGIN_ENDPOINT)
        .then()
        .log()
        .ifValidationFails()
        .statusCode(200)
        .extract()
        .as(LoginResponse.class);
  }
}
