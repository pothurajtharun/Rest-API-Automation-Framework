package com.tharun.qa.base;

import com.tharun.qa.constants.ApiConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseRequestSpec {

  private static RequestSpecification requestSpecification;

  public static RequestSpecification getJsonRequestSpec() {
    if (requestSpecification == null) {
      requestSpecification = new RequestSpecBuilder().setBaseUri(ApiConstants.BASE_URI).build();
    }
    return requestSpecification;
  }
}
