package com.Harsh.ProductManagementApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInput {
    private String adminName;
    private String adminEmail;
    private String adminPassword;
}
