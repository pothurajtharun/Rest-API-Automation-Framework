package com.tharun.qa.constants;

public class ApiConstants {

  public static final String BASE_URI = "https://rahulshettyacademy.com";
  // Login
  public static final String LOGIN_ENDPOINT = "/api/ecom/auth/login";
  public static final String USER_EMAIL = "tharunkumar1490@gmail.com";
  public static final String USER_PASSWORD = "Api@1234";
  // Add to cart
  public static final String ADD_TO_CART_ENDPOINT = "/api/ecom/user/add-to-cart";
  public static final String ADD_TO_CART_RESPONSE = "Product Added To Cart";
  public static final String COAT_PRODUCT_ID = "67a8dde5c0d3e6622a297cc8";
  public static final String SHOE_PRODUCT_ID = "67a8df1ac0d3e6622a297ccb";
  public static final String IPHONE_PRODUCT_ID = "67a8df56c0d3e6622a297ccd";
  public static final String SINGLE_PRODUCT_ID = "67a8df56c0d3e6622a297ccd";
  public static final String TWO_PRODUCT_ID = "67a8df56c0d3e6622a297ccd,67a8df1ac0d3e6622a297ccb";
  public static final String THREE_PRODUCT_ID =
      "67a8df56c0d3e6622a297ccd,67a8df1ac0d3e6622a297ccb,67a8df56c0d3e6622a297ccd";
  public static final int ONE = 1;
  public static final int TWO = 2;
  public static final int THREE = 3;

  // Get the cart products
  public static final String GET_THE_CART_ENDPOINT = "/api/ecom/user/get-cart-products/{userId}";
  // Create an order
  public static final String CREATE_ORDER_ENDPOINT = "/api/ecom/order/create-order";
  public static final String CREATE_ORDER_RESPONSE = "Order Placed Successfully";
  public static final String INDIA = "India";
  public static final String JAPAN = "Japan";
  public static final String US = "United States";
  // Get an order details
  public static final String GET_ORDER_DETAILS_ENDPOINT = "/api/ecom/order/get-orders-details";
}
