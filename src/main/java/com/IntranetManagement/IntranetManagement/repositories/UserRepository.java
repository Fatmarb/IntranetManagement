package com.IntranetManagement.IntranetManagement.repositories;


import com.IntranetManagement.IntranetManagement.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    @Query("SELECT u FROM User u JOIN FETCH u.rights r JOIN FETCH r.department WHERE u.username = :username")
    Optional<User> findUserWithRoles(String username);
}