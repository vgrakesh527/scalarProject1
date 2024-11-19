package com.org.rak.product_details.services;

import com.org.rak.product_details.exceptions.ProductNotFoundException;
import com.org.rak.product_details.models.Category;
import com.org.rak.product_details.models.Product;
import com.org.rak.product_details.repository.CategoryRepository;
import com.org.rak.product_details.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductServiceImpl")
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public Product getProduct(int id) throws ProductNotFoundException {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() > 0){
            category = categoryRepository.findById(category.getId()).orElseThrow();
            product.setCategory(category);
        } else {
            category = categoryRepository.save(product.getCategory());
            product.setCategory(category);
        }
        return productRepository.save(product);
    }
}
