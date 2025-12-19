package com.mohamedmostafa.IMS_project.services;

import com.mohamedmostafa.IMS_project.dtos.TransactionDto;
import com.mohamedmostafa.IMS_project.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getCurrentLoggedInUser();

    UserDto getUserById(String userId);

    UserDto updateUser(String id, UserDto userDto);

    void deleteUser(String userId);

    List<TransactionDto> getUserTransactions(String userId);

    List<TransactionDto> getMyTransactions();
}
