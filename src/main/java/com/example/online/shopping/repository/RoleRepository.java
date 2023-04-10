package com.example.online.shopping.repository;

import com.example.online.shopping.model.ERole;
import com.example.online.shopping.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole roleUser);
}
