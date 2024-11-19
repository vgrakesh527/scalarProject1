package com.org.rak.product_details.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_instructor")
public class Instructor extends BaseModel{
    String position;
    String name;
}
