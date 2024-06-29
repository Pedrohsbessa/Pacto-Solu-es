package br.com.pacto.vacancy.service;

import br.com.pacto.vacancy.dto.JobCreationDto;
import br.com.pacto.vacancy.entity.Job;

import java.util.List;

public interface JobService {
  Job createJob(JobCreationDto jobCreationDto);

  List<Job> getAllJobs();

  Job getJobById(Long id);

  Job updateJob(Long id, JobCreationDto jobUpdateDto);

  void deleteJob(Long id);
}
