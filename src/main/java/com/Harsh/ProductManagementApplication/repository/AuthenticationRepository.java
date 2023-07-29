package com.Harsh.ProductManagementApplication.repository;

import com.Harsh.ProductManagementApplication.Model.AuthenticationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends CrudRepository<AuthenticationToken, Long> {
}
