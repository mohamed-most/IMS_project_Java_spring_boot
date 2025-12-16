package com.mohamedmostafa.IMS_project.security;

import com.mohamedmostafa.IMS_project.exceptions.NotFoundException;
import com.mohamedmostafa.IMS_project.models.User;
import com.mohamedmostafa.IMS_project.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User Email Not Found"));
        return AuthUser.builder().user(user).build();
    }
}