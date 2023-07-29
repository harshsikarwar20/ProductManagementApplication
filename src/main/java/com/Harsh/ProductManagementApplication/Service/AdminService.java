package com.Harsh.ProductManagementApplication.Service;

import com.Harsh.ProductManagementApplication.Model.Admin;
import com.Harsh.ProductManagementApplication.Model.AuthenticationToken;
import com.Harsh.ProductManagementApplication.dto.SignUpInput;
import com.Harsh.ProductManagementApplication.dto.SignUpOutput;
import com.Harsh.ProductManagementApplication.repository.AdminRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AuthenticationService authenticationService;
    public SignUpOutput signUp(SignUpInput signUpDto) {
        Admin admin = adminRepository.findFirstByAdminEmail(signUpDto.getAdminEmail());

        if(admin != null){
            throw new IllegalStateException("Admin already exist!! so signIn instead");
        }

        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(signUpDto.getAdminPassword());
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        // Save the admin

        admin = new Admin(signUpDto.getAdminName(),
        signUpDto.getAdminEmail(),encryptedPassword);

        adminRepository.save(admin);

        // token creation and saving
        AuthenticationToken token = new AuthenticationToken(admin);

        authenticationService.saveToken(token);
        return new SignUpOutput("Admin registered","Admin created successfully");
    }

    private String encryptPassword(String adminPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(adminPassword.getBytes());
        byte[] digested =  md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }
}
