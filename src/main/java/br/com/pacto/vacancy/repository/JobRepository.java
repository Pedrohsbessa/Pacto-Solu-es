package br.com.pacto.vacancy.repository;

import br.com.pacto.vacancy.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {}
