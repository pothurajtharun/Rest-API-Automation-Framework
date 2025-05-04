package com.tharun.qa.models.response;

import lombok.Data;

@Data
public class GetOrderDetailsResponse {

  private OrderData data;
  private String message;
}
