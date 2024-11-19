package com.org.rak.product_details.utils;

import com.org.rak.product_details.dto.ProductFakeApiDto;
import com.org.rak.product_details.models.Product;

public class ProductConverter {
  public static Product convertToProduct(ProductFakeApiDto dto) {
    if (dto == null) {
      return null;
    }

    Product product = new Product();
    product.setId(dto.getId());
    product.setTitle(dto.getTitle());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());
    //product.setCategory(dto.getCategory());

    return product;
  }
}
