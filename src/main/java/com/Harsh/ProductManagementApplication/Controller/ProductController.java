package com.Harsh.ProductManagementApplication.Controller;

import com.Harsh.ProductManagementApplication.Model.Product;
import com.Harsh.ProductManagementApplication.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

//    @PostMapping(value = "/add/products")
//    private String addProduct(@RequestBody Product product){
//        return productService.addProduct(product);
//    }

    @GetMapping(value = "get/product/by/{productId}")
    private Optional<Product> getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }
}
