package br.com.pacto.vacancy.dto.mapper;

import br.com.pacto.vacancy.dto.UserCreationDTO;
import br.com.pacto.vacancy.entity.Role;
import br.com.pacto.vacancy.entity.User;
import br.com.pacto.vacancy.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  private static RoleRepository roleRepository;

  public UserMapper(RoleRepository roleRepository) {
    UserMapper.roleRepository = roleRepository;
  }

  public static User fromDto(UserCreationDTO dto) {
    Role candidateRole =
        roleRepository
            .findByName("CANDIDATE")
            .orElseThrow(() -> new RuntimeException("Role CANDIDATE not found"));

    return User.builder()
        .username(dto.getUsername())
        .password(dto.getPassword())
        .email(dto.getEmail())
        .role(candidateRole)
        .build();
  }
}
