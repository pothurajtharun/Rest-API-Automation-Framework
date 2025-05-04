package com.tharun.qa.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

  private String token;
  private String userId;
  private String message;
}
