package br.com.pacto.vacancy.repository;

import br.com.pacto.vacancy.entity.JobRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRequirementRepository extends JpaRepository<JobRequirement, Long> {}
