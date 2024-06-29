package br.com.pacto.vacancy.repository;

import br.com.pacto.vacancy.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {}
