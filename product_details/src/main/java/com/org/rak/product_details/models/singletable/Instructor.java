package com.org.rak.product_details.models.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "st_instructor")
@DiscriminatorValue(value = "2")
public class Instructor extends User {
    private String specialization;
}
