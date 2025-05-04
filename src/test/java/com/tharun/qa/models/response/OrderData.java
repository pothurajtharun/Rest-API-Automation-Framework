package com.tharun.qa.models.response;

import lombok.Data;

@Data
public class OrderData {

  private String _id;
  private String orderById;
  private String orderBy;
  private String productOrderedId;
  private String productName;
  private String country;
  private String productDescription;
  private String productImage;
  private String orderPrice;
  private int __v;
}
