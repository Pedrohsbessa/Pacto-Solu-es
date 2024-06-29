package br.com.pacto.vacancy.dto.mapper;

import br.com.pacto.vacancy.dto.ApplicationDTO;
import br.com.pacto.vacancy.entity.Application;
import br.com.pacto.vacancy.entity.Job;
import br.com.pacto.vacancy.entity.User;
import br.com.pacto.vacancy.repository.JobRepository;
import br.com.pacto.vacancy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {

  @Autowired private UserRepository userRepository;

  @Autowired private JobRepository jobRepository;

  public Application dtoToEntity(ApplicationDTO dto) {
    User user =
        userRepository
            .findById(dto.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));
    Job job =
        jobRepository
            .findById(dto.getJobId())
            .orElseThrow(() -> new RuntimeException("Job not found"));

    return Application.builder().user(user).job(job).feedback(dto.getFeedback()).build();
  }

  public ApplicationDTO entityToDto(Application application) {
    return ApplicationDTO.builder()
        .userId(application.getUser().getId())
        .jobId(application.getJob().getId())
        .feedback(application.getFeedback())
        .build();
  }
}
