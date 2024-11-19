package com.org.rak.product_details.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "Categories")
public class Category extends BaseModel {
    String name;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JsonBackReference
    private List<Product> products;
}
