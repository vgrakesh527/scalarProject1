package com.org.rak.product_details.models.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tpc_student")
public class Student extends User {
    private String batch;
    private String course;
}