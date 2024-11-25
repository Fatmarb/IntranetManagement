package com.IntranetManagement.IntranetManagement.Services;

import com.IntranetManagement.IntranetManagement.Entities.User;
import com.IntranetManagement.IntranetManagement.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findUserWithRoles(username);

        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Map roles to GrantedAuthority
        List<GrantedAuthority> authorities = user.getRights().stream()
                .map(right -> new SimpleGrantedAuthority(
                        "ROLE_" + right.getDepartment().getDepartmentName() + "_" + right.getRole()
                ))
                .collect(Collectors.toList());

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // Password must be encoded
                .authorities(authorities)
                .build();
    }
}
