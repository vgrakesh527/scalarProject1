package com.org.rak.product_details.models.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tpc_instructor")
public class Instructor extends User {
    private String specialization;
}
