package com.tharun.qa.services;

import static com.tharun.qa.constants.ApiConstants.GET_THE_CART_ENDPOINT;
import static io.restassured.RestAssured.given;

import com.tharun.qa.models.response.GetCartProductsResponse;

public class GetCartProductsService extends BaseService {

  public GetCartProductsResponse getCardProducts(String authToken, String userId) {

    return given()
        .spec(spec)
        .pathParam("userId", userId)
        .header("Authorization", authToken)
        .when()
        .get(GET_THE_CART_ENDPOINT)
        .then()
        .log()
        .ifValidationFails()
        .statusCode(200)
        .extract()
        .as(GetCartProductsResponse.class);
  }
}
