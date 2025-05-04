package com.tharun.qa.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

  private String _id;
  private String productName;
  private String productCategory;
  private String productSubCategory;
  private int productPrice;
  private String productDescription;
  private String productImage;
  private String productRating;
  private String productTotalOrders;
  private boolean productStatus;
  private String productAddedBy;
  private int __v;
  private String productFor;
}
