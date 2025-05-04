package com.tharun.qa.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tharun.qa.models.request.ProductRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProductFactory {

  private static final List<ProductRequest> products;

  static {
    try {
      ObjectMapper mapper = new ObjectMapper();

      // Get the path relative to the project root
      String path = "src/test/resources/config/products.json";
      File file = new File(path);

      if (!file.exists()) {
        throw new IllegalStateException(
            "products.json file not found at the specified path: " + file.getAbsolutePath());
      }

      products = mapper.readValue(file, new TypeReference<List<ProductRequest>>() {});
    } catch (IOException e) {
      throw new RuntimeException("Failed to load product data", e);
    }
  }

  // This method fetches a product by its ID and returns a ProductRequest object
  public static ProductRequest createProductRequest(String productId) {
    return products.stream()
        .filter(p -> p.get_id().equals(productId))
        .findFirst()
        .map(
            product ->
                ProductRequest.builder()
                    ._id(product.get_id())
                    .productName(product.getProductName())
                    .productCategory(product.getProductCategory())
                    .productSubCategory(product.getProductSubCategory())
                    .productPrice(product.getProductPrice())
                    .productDescription(product.getProductDescription())
                    .productImage(product.getProductImage())
                    .productRating(product.getProductRating())
                    .productTotalOrders(product.getProductTotalOrders())
                    .productStatus(product.isProductStatus())
                    .productAddedBy(product.getProductAddedBy())
                    .__v(product.get__v())
                    .productFor(product.getProductFor())
                    .build())
        .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));
  }

  public static List<ProductRequest> getAllProducts() {
    return products;
  }
}
