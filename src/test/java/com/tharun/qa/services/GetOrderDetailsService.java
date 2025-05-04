package com.tharun.qa.services;

import static com.tharun.qa.constants.ApiConstants.GET_ORDER_DETAILS_ENDPOINT;
import static io.restassured.RestAssured.given;

import com.tharun.qa.models.response.GetOrderDetailsResponse;

public class GetOrderDetailsService extends BaseService {

  public GetOrderDetailsResponse getOrderDetails(String authToken, String orderId) {

    return given()
        .spec(spec)
        .queryParam("id", orderId)
        .header("Authorization", authToken)
        .when()
        .get(GET_ORDER_DETAILS_ENDPOINT)
        .then()
        .log()
        .ifValidationFails()
        .statusCode(200)
        .extract()
        .as(GetOrderDetailsResponse.class);
  }
}
