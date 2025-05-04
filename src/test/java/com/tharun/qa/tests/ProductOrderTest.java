package com.tharun.qa.tests;

import static com.tharun.qa.constants.ApiConstants.COAT_PRODUCT_ID;
import static com.tharun.qa.constants.ApiConstants.INDIA;
import static com.tharun.qa.constants.ApiConstants.IPHONE_PRODUCT_ID;
import static com.tharun.qa.constants.ApiConstants.ONE;
import static com.tharun.qa.constants.ApiConstants.SHOE_PRODUCT_ID;
import static com.tharun.qa.constants.ApiConstants.SINGLE_PRODUCT_ID;
import static com.tharun.qa.constants.ApiConstants.THREE;
import static com.tharun.qa.constants.ApiConstants.THREE_PRODUCT_ID;
import static com.tharun.qa.constants.ApiConstants.TWO;
import static com.tharun.qa.constants.ApiConstants.TWO_PRODUCT_ID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ProductOrderTest extends TestBase {

  private static final Logger log = LogManager.getLogger(ProductOrderTest.class);

  CommonProductOrder commonProductOrder = new CommonProductOrder();

  @Test
  public void verifyLoginTest() {
    commonProductOrder.verifyLogin();
  }

  @Test
  public void verifyAddSingleProductToCartById() {
    commonProductOrder.addProductToCartById(COAT_PRODUCT_ID);
  }

  @Test
  public void verifySingleProductInTheCart() {
    commonProductOrder.getCartProducts(ONE);
  }

  @Test
  public void verifyCreateOrderWithSingleProduct() {
    commonProductOrder.createOrder(INDIA, SINGLE_PRODUCT_ID);
  }

  @Test
  public void verifyGetOrderDetailsForSingleProduct() {
    commonProductOrder.getOrderDetails();
  }

  @Test
  public void verifyAddTwoProductsToCartById() {
    commonProductOrder.addProductToCartById(COAT_PRODUCT_ID);
    commonProductOrder.addProductToCartById(SHOE_PRODUCT_ID);
  }

  @Test
  public void verifyTwoProductsInTheCart() {
    commonProductOrder.getCartProducts(TWO);
  }

  @Test
  public void verifyCreateOrderWithTwoProducts() {
    commonProductOrder.createOrder(INDIA, TWO_PRODUCT_ID);
  }

  @Test
  public void verifyGetOrderDetailsForTwoProducts() {
    commonProductOrder.getOrderDetails();
  }

  @Test
  public void verifyAddThreeProductsToCartById() {
    commonProductOrder.addProductToCartById(COAT_PRODUCT_ID);
    commonProductOrder.addProductToCartById(SHOE_PRODUCT_ID);
    commonProductOrder.addProductToCartById(IPHONE_PRODUCT_ID);
  }

  @Test
  public void verifyThreeProductsInTheCart() {
    commonProductOrder.getCartProducts(THREE);
  }

  @Test
  public void verifyCreateOrderWithThreeProducts() {
    commonProductOrder.createOrder(INDIA, THREE_PRODUCT_ID);
  }

  @Test
  public void verifyGetOrderDetailsForThreeProducts() {
    commonProductOrder.getOrderDetails();
  }
}
