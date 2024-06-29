package br.com.pacto.vacancy.dto.mapper;

import br.com.pacto.vacancy.dto.JobCreationDto;
import br.com.pacto.vacancy.entity.Job;
import br.com.pacto.vacancy.entity.User;
import br.com.pacto.vacancy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {

  private final UserRepository userRepository;

  @Autowired
  public JobMapper(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public JobCreationDto toDto(Job job) {
    return JobCreationDto.builder()
        .title(job.getTitle())
        .description(job.getDescription())
        .createdById(job.getCreatedBy().getId())
        .build();
  }

  public Job toEntity(JobCreationDto dto) {
    User user =
        userRepository
            .findById(dto.getCreatedById())
            .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

    return Job.builder()
        .title(dto.getTitle())
        .description(dto.getDescription())
        .createdBy(user)
        .build();
  }

  public void updateJobFromDto(JobCreationDto dto, Job job) {
    User user =
        userRepository
            .findById(dto.getCreatedById())
            .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

    job.setTitle(dto.getTitle());
    job.setDescription(dto.getDescription());
    job.setCreatedBy(user);
  }
}
