package com.org.rak.product_details.repository;

import com.org.rak.product_details.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
