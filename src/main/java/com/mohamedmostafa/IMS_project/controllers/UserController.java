package com.mohamedmostafa.IMS_project.controllers;


import com.mohamedmostafa.IMS_project.dtos.Response;
import com.mohamedmostafa.IMS_project.dtos.TransactionDto;
import com.mohamedmostafa.IMS_project.dtos.UserDto;
import com.mohamedmostafa.IMS_project.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Only Admin can fetch all users
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<List<UserDto>>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(Response.success("All users fetched ", userService.getAllUsers()));
    }

    // Admin or Manager can fetch any user by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public ResponseEntity<Response<UserDto>> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(Response.success(null, userService.getUserById(id)));
    }

    // Admin or Manager can update users
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public ResponseEntity<Response<UserDto>> updateUser(@PathVariable String id, @RequestBody UserDto userDTO) {
        return ResponseEntity.ok(
                Response.success("User Updated Successfully", userService.updateUser(id, userDTO))
        );
    }

    // Only Admin can delete users
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<?>> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(Response.success("User Deleted Successfully", null));
    }

    // Admin or Manager can see transactions of any user
    @GetMapping("/transactions/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public ResponseEntity<Response<List<TransactionDto>>> getUserTransactions(@PathVariable String userId) {
        return ResponseEntity.ok(Response.success("All Transactions", userService.getUserTransactions(userId)));
    }

    // STAFF, MANAGER, ADMIN can see their own transactions
    @GetMapping("/transactions/me")
    @PreAuthorize("hasAnyAuthority('STAFF','MANAGER','ADMIN')")
    public ResponseEntity<Response<List<TransactionDto>>> getCurrentUserTransactions() {
        return ResponseEntity.ok(Response.success(null, userService.getMyTransactions()));
    }

    // Anyone logged in can see their own profile
    @GetMapping("/me")
    @PreAuthorize("hasAnyAuthority('STAFF','MANAGER','ADMIN','SUPPLIER')")
    public ResponseEntity<Response<UserDto>> getCurrentUser() {
        return ResponseEntity.ok(Response.success(null, userService.getCurrentLoggedInUser()));
    }
}
