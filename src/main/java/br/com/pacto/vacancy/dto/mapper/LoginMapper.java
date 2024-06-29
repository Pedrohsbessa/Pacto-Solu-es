package br.com.pacto.vacancy.dto.mapper;

import br.com.pacto.vacancy.dto.LoginDTO;
import br.com.pacto.vacancy.entity.User;

public class LoginMapper {
  public static LoginDTO toDTO(User user) {
    return br.com.pacto.vacancy.dto.LoginDTO.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .build();
  }

  public static User toEntity(LoginDTO loginDTO) {
    return br.com.pacto.vacancy.entity.User.builder()
        .username(loginDTO.getUsername())
        .password(loginDTO.getPassword())
        .build();
  }
}
