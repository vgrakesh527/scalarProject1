package com.org.rak.product_details.models.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "st_student")
@DiscriminatorValue(value = "1")
public class Student extends User {
    private String batch;
    private String course;
}