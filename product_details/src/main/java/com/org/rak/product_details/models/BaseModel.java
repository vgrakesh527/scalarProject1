package com.org.rak.product_details.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
}
