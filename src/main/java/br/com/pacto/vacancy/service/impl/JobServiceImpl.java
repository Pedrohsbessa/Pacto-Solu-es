package br.com.pacto.vacancy.service.impl;

import br.com.pacto.vacancy.dto.JobCreationDto;
import br.com.pacto.vacancy.dto.mapper.JobMapper;
import br.com.pacto.vacancy.entity.Job;
import br.com.pacto.vacancy.repository.JobRepository;
import br.com.pacto.vacancy.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

  private final JobRepository jobRepository;
  private final JobMapper jobMapper;

  @Autowired
  public JobServiceImpl(JobRepository jobRepository, JobMapper jobMapper) {
    this.jobRepository = jobRepository;
    this.jobMapper = jobMapper;
  }

  @Override
  public Job createJob(JobCreationDto jobCreationDto) {
    Job job = jobMapper.toEntity(jobCreationDto);
    return jobRepository.save(job);
  }

  @Override
  public List<Job> getAllJobs() {
    return jobRepository.findAll();
  }

  @Override
  public Job getJobById(Long id) {
    Optional<Job> job = jobRepository.findById(id);
    return job.orElseThrow(() -> new RuntimeException("Job not found"));
  }

  @Override
  public Job updateJob(Long id, JobCreationDto jobUpdateDto) {
    Job job = getJobById(id);
    jobMapper.updateJobFromDto(jobUpdateDto, job);
    return jobRepository.save(job);
  }

  @Override
  public void deleteJob(Long id) {
    jobRepository.deleteById(id);
  }
}
