package com.IntranetManagement.IntranetManagement.Entities;

import jakarta.persistence.*;
import java.util.Set;

    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        @Column(nullable = false, unique = true)
        public String username;

        @Column(nullable = false)
        public String password;
        @Column(nullable = false)
        public String FirstName;
        @Column(nullable = false)
        public String LastName;
        @Column(nullable = false)
        public int IsAdmin;
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private Set<Rights> rights;

        // Getters and Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public int getIsAdmin() {
            return IsAdmin;
        }

        public void setIsAdmin(int isAdmin) {
            IsAdmin = isAdmin;
        }
        public Set<Rights> getRights() {
            return rights;
        }

        public void setRights(Set<Rights> rights) {
            this.rights = rights;
        }
    }

