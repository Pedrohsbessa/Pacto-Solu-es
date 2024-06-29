package br.com.pacto.vacancy.service.impl;

import br.com.pacto.vacancy.dto.UserCreationDTO;
import br.com.pacto.vacancy.dto.mapper.UserMapper;
import br.com.pacto.vacancy.entity.Role;
import br.com.pacto.vacancy.entity.User;
import br.com.pacto.vacancy.repository.RoleRepository;
import br.com.pacto.vacancy.repository.UserRepository;
import br.com.pacto.vacancy.service.UserService;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(
      UserRepository userRepository,
      UserMapper userMapper,
      RoleRepository roleRepository,
      @Lazy PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User createUser(UserCreationDTO userCreationDTO) {
    userCreationDTO.setPassword(passwordEncoder.encode(userCreationDTO.getPassword()));
    User user = UserMapper.fromDto(userCreationDTO);
    // Assuming the role is set in the DTO or fetched/assigned in some manner
    Optional<Role> role = roleRepository.findByName("USER"); // Example role fetch
    role.ifPresent(user::setRole);
    return userRepository.save(user);
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  @Override
  public User updateUser(Long id, UserCreationDTO userCreationDTO) {
    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    user.setUsername(userCreationDTO.getUsername());
    user.setPassword(passwordEncoder.encode(userCreationDTO.getPassword()));
    user.setEmail(userCreationDTO.getEmail());
    // Handle role update if necessary
    return userRepository.save(user);
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  @PostConstruct
  public void initAdminUser() {
    String username = "admin";
    Optional<User> adminUser = userRepository.findByUsername(username);

    if (adminUser.isEmpty()) {
      Role adminRole =
          roleRepository
              .findByName("ADMIN")
              .orElseThrow(() -> new RuntimeException("Role ADMIN not found"));

      User admin = new User();
      admin.setUsername(username);
      admin.setPassword(passwordEncoder.encode("admin"));
      admin.setEmail("admin@example.com");
      admin.setRole(adminRole);

      userRepository.save(admin);
    }
  }
}
