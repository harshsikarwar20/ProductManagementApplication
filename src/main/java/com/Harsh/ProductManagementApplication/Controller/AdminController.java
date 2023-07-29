package com.Harsh.ProductManagementApplication.Controller;

import com.Harsh.ProductManagementApplication.Model.Product;
import com.Harsh.ProductManagementApplication.Service.AdminService;
import com.Harsh.ProductManagementApplication.Service.ProductService;
import com.Harsh.ProductManagementApplication.dto.SignUpInput;
import com.Harsh.ProductManagementApplication.dto.SignUpOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    ProductService productService;

    @Autowired
    AdminService adminService;

    @PostMapping(value = "/SignUp")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return adminService.signUp(signUpDto);
    }

    @PostMapping(value = "/add/products")
    private String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
}
