package br.com.pacto.vacancy.service;

import br.com.pacto.vacancy.dto.UserCreationDTO;
import br.com.pacto.vacancy.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
  User createUser(UserCreationDTO userCreationDTO);

  List<User> getAllUsers();

  Optional<User> getUserById(Long id);

  User updateUser(Long id, UserCreationDTO userCreationDTO);

  void deleteUser(Long id);
}
