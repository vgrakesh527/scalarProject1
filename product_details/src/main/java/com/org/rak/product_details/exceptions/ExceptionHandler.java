package com.org.rak.product_details.exceptions;

import com.org.rak.product_details.dto.ProductNotfoundMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler
  public ResponseEntity<ProductNotfoundMessageDto> productNotfoundMessage(
      ProductNotFoundException productNotFoundException) {
    ProductNotfoundMessageDto productNotfoundMessageDto = new ProductNotfoundMessageDto();
    productNotfoundMessageDto.setErrorCode(productNotFoundException.getErrorCode());
    productNotfoundMessageDto.setMessage(productNotFoundException.getMessage());
    return new ResponseEntity<>(productNotfoundMessageDto, HttpStatus.NOT_FOUND);
  }
}
