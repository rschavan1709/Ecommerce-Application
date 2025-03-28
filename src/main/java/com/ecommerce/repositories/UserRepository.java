package com.ecommerce.repositories;

import com.ecommerce.enums.Role;
import com.ecommerce.enums.Status;
import com.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAllByStatusAndRole(Status status, Role role);
    Optional<User> findByIdAndStatus(Integer id,Status status);
    Optional<User> findByEmailAndStatus(String email, Status status);
}
