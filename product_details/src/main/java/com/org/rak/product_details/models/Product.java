package com.org.rak.product_details.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "products")
public class Product extends BaseModel{
  private String title;
  private String description;
  private double price;
  @ManyToOne
  @JsonManagedReference
  private Category category;
}
