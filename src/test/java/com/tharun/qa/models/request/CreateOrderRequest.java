package com.tharun.qa.models.request;

import java.util.List;
import lombok.Data;

@Data
public class CreateOrderRequest {

  private List<OrderRequest> orders;
}
