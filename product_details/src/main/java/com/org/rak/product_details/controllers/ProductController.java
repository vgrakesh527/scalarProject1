package com.org.rak.product_details.controllers;

import com.org.rak.product_details.exceptions.ProductNotFoundException;
import com.org.rak.product_details.models.Product;
import com.org.rak.product_details.services.ProductService;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController {

  private ProductService productService;

  public ProductController(@Qualifier("ProductServiceImpl") ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable("id") int id)
      throws ProductNotFoundException {
    var product = productService.getProduct(id);
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @GetMapping
  public List<Product> getAllProduct() {
    return productService.getAllProduct();
  }

  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
    return productService.updateProduct(id, product);
  }

  @PostMapping
  public Product saveProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }
}
