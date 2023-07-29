package com.Harsh.ProductManagementApplication.Service;

import com.Harsh.ProductManagementApplication.Model.AuthenticationToken;
import com.Harsh.ProductManagementApplication.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationService {
    @Autowired
    AuthenticationRepository authenticationRepository;
    public void saveToken(AuthenticationToken token) {
        authenticationRepository.save(token);
    }
}
