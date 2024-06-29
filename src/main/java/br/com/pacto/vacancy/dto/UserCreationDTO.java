package br.com.pacto.vacancy.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreationDTO {
  private String username;
  private String password;
  private String email;
}
