package com.tharun.qa.models.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Default no-args constructor
@AllArgsConstructor // All-args constructor
public class CreateOrderResponse {

  private List<String> orders;
  private List<String> productOrderId;
  private String message;
}
