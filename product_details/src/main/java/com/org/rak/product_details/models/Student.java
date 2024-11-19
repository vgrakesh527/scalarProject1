package com.org.rak.product_details.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_student")
public class Student extends BaseModel{
    String batch;
}
