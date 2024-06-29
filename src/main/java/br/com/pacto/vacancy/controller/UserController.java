package br.com.pacto.vacancy.controller;

import br.com.pacto.vacancy.dto.UserCreationDTO;
import br.com.pacto.vacancy.entity.User;
import br.com.pacto.vacancy.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "The User API")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  @Operation(
      summary = "Create a new user",
      responses = {
        @ApiResponse(
            responseCode = "201",
            description = "User created",
            content = @Content(schema = @Schema(implementation = User.class)))
      })
  public ResponseEntity<User> createUser(@RequestBody UserCreationDTO userCreationDTO) {
    User user = userService.createUser(userCreationDTO);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

  @GetMapping
  @Operation(
      summary = "Get all users",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "List of users",
            content = @Content(schema = @Schema(implementation = User.class)))
      })
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @Operation(
      summary = "Get a user by ID",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "User found",
            content = @Content(schema = @Schema(implementation = User.class))),
        @ApiResponse(responseCode = "404", description = "User not found")
      })
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user =
        userService
            .getUserById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  @Operation(
      summary = "Update a user",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "User updated",
            content = @Content(schema = @Schema(implementation = User.class)))
      })
  public ResponseEntity<User> updateUser(
      @PathVariable Long id, @RequestBody UserCreationDTO userCreationDTO) {
    User updatedUser = userService.updateUser(id, userCreationDTO);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  @Operation(
      summary = "Delete a user",
      responses = {@ApiResponse(responseCode = "204", description = "User deleted")})
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
