package com.org.rak.product_details.models.jointable;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "jt_instructor")
public class Instructor extends User{
    private String specialization;
}
