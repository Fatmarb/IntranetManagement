package com.IntranetManagement.IntranetManagement.Entities;

import jakarta.persistence.*;
import java.util.Set;

    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String password;

        @ElementCollection(fetch = FetchType.EAGER)
        private Set<String> roles;

        // Getters and Setters
    }

