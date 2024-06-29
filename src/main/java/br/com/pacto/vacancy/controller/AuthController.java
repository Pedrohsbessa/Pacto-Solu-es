package br.com.pacto.vacancy.controller;

import br.com.pacto.vacancy.config.JwtUtil;
import br.com.pacto.vacancy.dto.LoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

  @Autowired private AuthenticationManager authenticationManager;

  @Autowired private JwtUtil jwtUtil;

  @Autowired private UserDetailsService userDetailsService;

  @PostMapping("/login")
  @Operation(
      summary = "Authenticate user and return JWT",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Authentication successful",
            content = @Content(schema = @Schema(implementation = AuthenticationResponse.class))),
        @ApiResponse(responseCode = "401", description = "Authentication failed")
      })
  public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginDTO loginDTO) {
    try {
      Authentication authentication =
          authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                  loginDTO.getUsername(), loginDTO.getPassword()));

      UserDetails userDetails = (UserDetails) authentication.getPrincipal();
      String jwt = jwtUtil.generateToken(userDetails);

      return ResponseEntity.ok(new AuthenticationResponse(jwt));
    } catch (AuthenticationException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body("Erro na autenticação: " + e.getMessage());
    }
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/testLoadByUsername/{username}")
  @Operation(
      summary = "Test load user by username",
      security = @SecurityRequirement(name = "bearerAuth"),
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "User details loaded successfully",
            content = @Content(schema = @Schema(implementation = UserDetails.class))),
        @ApiResponse(responseCode = "404", description = "User not found")
      })
  public ResponseEntity<?> testLoadByUsername(@PathVariable String username) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    return ResponseEntity.ok(userDetails);
  }

  private static class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
      this.jwt = jwt;
    }

    public String getJwt() {
      return jwt;
    }
  }
}
