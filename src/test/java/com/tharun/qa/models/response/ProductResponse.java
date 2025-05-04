package com.tharun.qa.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

  private String _id;
  private String productName;
  private String productCategory;
  private String productSubCategory;
  private double productPrice; // Assuming product price is a double
  private String productDescription;
  private String productImage;
  private String productRating;
  private String productTotalOrders;
  private boolean productStatus;
  private String productFor;
  private String productAddedBy;
  private int __v;
}
