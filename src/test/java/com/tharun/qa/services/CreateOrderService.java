package com.tharun.qa.services;

import static com.diffplug.common.collect.Immutables.toList;
import static com.tharun.qa.constants.ApiConstants.CREATE_ORDER_ENDPOINT;
import static io.restassured.RestAssured.given;

import com.tharun.qa.models.request.CreateOrderRequest;
import com.tharun.qa.models.request.OrderRequest;
import com.tharun.qa.models.response.CreateOrderResponse;
import io.restassured.http.ContentType;
import java.util.Arrays;
import java.util.List;

public class CreateOrderService extends BaseService {

  public CreateOrderResponse createOrder(String token, String orderCountry, String productId) {
    List<String> productIds = Arrays.asList(productId.split(","));
    List<OrderRequest> orders =
        productIds.stream().map(id -> new OrderRequest(orderCountry, id)).collect(toList());

    CreateOrderRequest createOrderPayload = new CreateOrderRequest();
    createOrderPayload.setOrders(orders);

    return given()
        .spec(spec)
        .header("Authorization", token)
        .contentType(ContentType.JSON)
        .body(createOrderPayload)
        .when()
        .post(CREATE_ORDER_ENDPOINT)
        .then()
        .log()
        .ifValidationFails()
        .statusCode(201)
        .extract()
        .as(CreateOrderResponse.class);
  }
}
