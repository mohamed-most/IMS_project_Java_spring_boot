package com.mohamedmostafa.IMS_project.services.impl;

import com.mohamedmostafa.IMS_project.dtos.TransactionDto;
import com.mohamedmostafa.IMS_project.dtos.UserDto;
import com.mohamedmostafa.IMS_project.exceptions.NotFoundException;
import com.mohamedmostafa.IMS_project.mappers.TransactionMapper;
import com.mohamedmostafa.IMS_project.mappers.UserMapper;
import com.mohamedmostafa.IMS_project.models.User;
import com.mohamedmostafa.IMS_project.repos.UserRepository;
import com.mohamedmostafa.IMS_project.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
@Primary
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::toDto).toList();
    }

    @Override
    public UserDto getCurrentLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NotFoundException("No authenticated user found");
        }

        String email = authentication.getName();
        return userRepository
                .findByEmail(email).map(UserMapper::toDto)
                .orElseThrow(() -> new NotFoundException("User Not Found "));
    }

    @Override
    public UserDto getUserById(String userId) {
        return userRepository.findById(userId)
                .map(UserMapper::toDto)
                .orElseThrow(() -> new NotFoundException("User Not Found "));
    }

    @Override
    public UserDto updateUser(String id, UserDto userDto) {

        User existingUser = userRepository.findById(id.toString())
                .orElseThrow(() -> new NotFoundException("User with ID " + id + " not found"));


        User updatedUser = User.builder()
                .id(existingUser.getId())                 // keep the same ID
                .name(userDto.getName() != null ? userDto.getName() : existingUser.getName())
                .email(existingUser.getEmail()) //keep email as it because this is unique
                .phoneNumber(userDto.getPhoneNumber() != null ? userDto.getPhoneNumber() : existingUser.getPhoneNumber())
                .role(existingUser.getRole()) // can't update roles
                .password(existingUser.getPassword())     // do not overwrite password
                .transactions(existingUser.getTransactions()) // keep existing transactions
                .createdAt(existingUser.getCreatedAt())
                .updatedAt(existingUser.getUpdatedAt())
                .build();

        User savedUser = userRepository.save(updatedUser);


        return UserMapper.toDto(savedUser);
    }

    @Override
    public void deleteUser(String userId) {
        if (!userRepository.existsById(userId)) throw new NotFoundException("User Not Found");
        userRepository.deleteById(userId);
    }

    @Override
    public List<TransactionDto> getUserTransactions(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User Not Found"));


        return user.getTransactions().stream()
                .map(TransactionMapper::toDto)
                .toList();
    }


    public List<TransactionDto> getMyTransactions() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return user.getTransactions().stream()
                .map(TransactionMapper::toDto) // map entity to DTO
                .toList();
    }

}
