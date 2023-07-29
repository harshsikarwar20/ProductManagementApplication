package com.Harsh.ProductManagementApplication.repository;

import com.Harsh.ProductManagementApplication.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
