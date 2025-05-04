package com.tharun.qa.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddToCartRequest {
  private String _id;
  private ProductRequest product;
}
