package com.org.rak.product_details.repository;

import com.org.rak.product_details.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
