package com.tharun.qa.services;

import com.tharun.qa.base.BaseRequestSpec;
import io.restassured.specification.RequestSpecification;

public abstract class BaseService {

  protected final RequestSpecification spec;

  public BaseService() {
    this.spec = BaseRequestSpec.getJsonRequestSpec();
  }
}
