package com.example.springsecurity6_thymeleaf.repository;

import com.example.springsecurity6_thymeleaf.entiry.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository {
    @Query("SELECT u FROM Role u WHERE u.name = :name")
    public Role getUserByName(@Param("name") String name);
    Optional<Role> findByName(String name);
}
