package com.tharun.qa.services;

import static com.tharun.qa.constants.ApiConstants.ADD_TO_CART_ENDPOINT;
import static io.restassured.RestAssured.given;

import com.tharun.qa.models.request.AddToCartRequest;
import com.tharun.qa.models.request.ProductRequest;
import com.tharun.qa.models.response.AddToCartResponse;
import com.tharun.qa.utils.ProductFactory;
import io.restassured.http.ContentType;

public class AddToCartService extends BaseService {

  public AddToCartResponse addToCart(String authToken, String userId, String productId) {

    ProductRequest productPayload = ProductFactory.createProductRequest(productId);

    AddToCartRequest addToCartPayload =
        AddToCartRequest.builder()._id(userId).product(productPayload).build();

    return given()
        .spec(spec)
        .header("Authorization", authToken)
        .contentType(ContentType.JSON)
        .spec(spec)
        .body(addToCartPayload)
        .when()
        .post(ADD_TO_CART_ENDPOINT)
        .then()
        .log()
        .ifValidationFails()
        .statusCode(200)
        .extract()
        .as(AddToCartResponse.class);
  }
}
