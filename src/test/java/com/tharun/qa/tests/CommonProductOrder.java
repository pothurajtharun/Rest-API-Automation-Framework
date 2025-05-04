package com.tharun.qa.tests;

import static com.tharun.qa.constants.ApiConstants.ADD_TO_CART_RESPONSE;
import static com.tharun.qa.constants.ApiConstants.CREATE_ORDER_RESPONSE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tharun.qa.models.response.AddToCartResponse;
import com.tharun.qa.models.response.CreateOrderResponse;
import com.tharun.qa.models.response.GetCartProductsResponse;
import com.tharun.qa.models.response.GetOrderDetailsResponse;
import com.tharun.qa.services.AddToCartService;
import com.tharun.qa.services.CreateOrderService;
import com.tharun.qa.services.GetCartProductsService;
import com.tharun.qa.services.GetOrderDetailsService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class CommonProductOrder extends TestBase {

  private static final Logger log = LogManager.getLogger(CommonProductOrder.class);

  CreateOrderResponse createOrderResponse;
  List<String> orderIds;

  public void verifyLogin() {
    Assert.assertNotNull(loginResponse.getToken(), "Token should not be null.");
    Assert.assertNotNull(loginResponse.getUserId(), "User ID should not be null.");
    log.info("Logged in successfully.");
  }

  public void addProductToCartById(String productId) {
    AddToCartService addToCartService = new AddToCartService();
    AddToCartResponse addToCartResponse =
        addToCartService.addToCart(loginResponse.getToken(), loginResponse.getUserId(), productId);
    assertThat(
        "Failed to add the product to the cart.",
        ADD_TO_CART_RESPONSE,
        equalTo(addToCartResponse.getMessage()));
    log.info("Product with id {} is added to the cart successful.", productId);
  }

  public void getCartProducts(int count) {
    GetCartProductsService getCartProductsService = new GetCartProductsService();
    GetCartProductsResponse getCartProductsResponse =
        getCartProductsService.getCardProducts(loginResponse.getToken(), loginResponse.getUserId());
    int productCount = getCartProductsResponse.getCount();
    assertThat("Product count in the cart is wrong.", count, equalTo(productCount));
    log.info("{} product/s exists in the cart.", productCount);
  }

  public void createOrder(String orderCountry, String productId) {
    CreateOrderService createOrderService = new CreateOrderService();
    createOrderResponse =
        createOrderService.createOrder(loginResponse.getToken(), orderCountry, productId);
    assertThat(
        "Order not created.", CREATE_ORDER_RESPONSE, equalTo(createOrderResponse.getMessage()));
    log.info(
        "Product with id {} is ordered successfully.", createOrderResponse.getProductOrderId());
    this.orderIds =
        Optional.ofNullable(createOrderResponse.getOrders())
            .filter(list -> !list.isEmpty())
            .orElse(Collections.emptyList());
    orderIds.forEach(orderId -> log.info("Order ID: {}", orderId));
  }

  public void getOrderDetails() {
    orderIds.forEach(
        orderId -> {
          GetOrderDetailsService getOrderDetailsService = new GetOrderDetailsService();
          GetOrderDetailsResponse getOrderDetailsResponse =
              getOrderDetailsService.getOrderDetails(loginResponse.getToken(), orderId);
          assertThat(
              "Order details are not matched.",
              getOrderDetailsResponse.getData().get_id(),
              equalTo(orderId));
          ObjectMapper mapper = new ObjectMapper();
          ObjectWriter prettyPrinter = mapper.writerWithDefaultPrettyPrinter();
          try {
            String prettyJson = prettyPrinter.writeValueAsString(getOrderDetailsResponse);
            log.info("Order details are:\n{}", prettyJson);
          } catch (Exception e) {
            log.error(e.getMessage());
          }
        });
  }
}
