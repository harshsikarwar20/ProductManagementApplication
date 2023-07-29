package com.Harsh.ProductManagementApplication.Service;

import com.Harsh.ProductManagementApplication.Model.Product;
import com.Harsh.ProductManagementApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String addProduct(Product product) {
        Product ans = productRepository.save(product);
        if(ans==null){
            return "Product Not added!!";
        }
        return "Product added successfully!!";
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }
}
