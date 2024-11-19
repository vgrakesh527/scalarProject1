package com.org.rak.product_details.models.jointable;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "jt_student")
public class Student extends User{
    private String batch;
    private String course;
}
