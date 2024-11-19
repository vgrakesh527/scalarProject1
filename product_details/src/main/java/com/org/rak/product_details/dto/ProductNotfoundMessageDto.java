package com.org.rak.product_details.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductNotfoundMessageDto {
  private int errorCode;
  private String message;
}
