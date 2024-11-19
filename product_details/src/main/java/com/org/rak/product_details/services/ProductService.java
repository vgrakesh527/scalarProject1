package com.org.rak.product_details.services;

import com.org.rak.product_details.exceptions.ProductNotFoundException;
import com.org.rak.product_details.models.Product;
import java.util.List;

public interface ProductService  {
  Product getProduct(int id) throws ProductNotFoundException;
  List<Product> getAllProduct();
  Product updateProduct(int id, Product product);
  Product addProduct(Product product);
}
