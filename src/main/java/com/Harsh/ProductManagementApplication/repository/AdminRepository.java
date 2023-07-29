package com.Harsh.ProductManagementApplication.repository;

import com.Harsh.ProductManagementApplication.Model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

    Admin findFirstByAdminEmail(String adminEmail);
}
