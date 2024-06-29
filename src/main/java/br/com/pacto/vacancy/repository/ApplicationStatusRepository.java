package br.com.pacto.vacancy.repository;

import br.com.pacto.vacancy.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatus, Long> {
  Optional<Object> findByStatus(String applied);
}
