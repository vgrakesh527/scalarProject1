package com.org.rak.product_details.services;

import com.org.rak.product_details.dto.ProductFakeApiDto;
import com.org.rak.product_details.exceptions.ProductNotFoundException;
import com.org.rak.product_details.models.Product;
import com.org.rak.product_details.utils.ProductConverter;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreApiProductService implements ProductService {
  private RestTemplate restTemplate;
  private final String PRODUCT_URL = "https://fakestoreapi.com/products/";

  public FakeStoreApiProductService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public Product getProduct(int id) throws ProductNotFoundException {
    var productDetails = restTemplate.getForObject(PRODUCT_URL + id, ProductFakeApiDto.class);
    if(productDetails == null){
      throw new ProductNotFoundException(100, "invalid product Id "+id);
    }
    return ProductConverter.convertToProduct(productDetails);
  }

  @Override
  public List<Product> getAllProduct() {
    var productDetailsList = restTemplate.getForObject(PRODUCT_URL, ProductFakeApiDto[].class);
    return productDetailsList != null ?
        Arrays.stream(productDetailsList).map(ProductConverter::convertToProduct).toList() : null;
  }

  @Override
  public Product updateProduct(int id, Product product) {

    ProductFakeApiDto productFakeApiDto = new ProductFakeApiDto();
    //productFakeApiDto.setCategory(product.getCategory());
    productFakeApiDto.setTitle(product.getTitle());
    productFakeApiDto.setPrice(product.getPrice());
    productFakeApiDto.setDescription(product.getDescription());

    ResponseExtractor<ResponseEntity<ProductFakeApiDto>> responseExtractor =
        restTemplate.responseEntityExtractor(ProductFakeApiDto.class);
    RequestCallback requestCallback = restTemplate.httpEntityCallback(productFakeApiDto);
    var result =
        restTemplate.execute(PRODUCT_URL + id, HttpMethod.PUT, requestCallback, responseExtractor);
    return result != null ? ProductConverter.convertToProduct(result.getBody()) : null;
  }

  @Override
  public Product addProduct(Product product) {
    return null;
  }
}
