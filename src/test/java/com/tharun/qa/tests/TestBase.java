package com.tharun.qa.tests;

import com.tharun.qa.models.response.LoginResponse;
import com.tharun.qa.services.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  private static final Logger log = LogManager.getLogger(TestBase.class);

  protected static LoginResponse loginResponse;

  @BeforeSuite(alwaysRun = true)
  public void suiteSetupLogin() {
    LoginService loginService = new LoginService();
    loginResponse = loginService.login();
    loginResponse.setToken(loginResponse.getToken());
    loginResponse.setUserId(loginResponse.getUserId());
    log.debug("Token & UserID are set for the suite.");
  }
}
