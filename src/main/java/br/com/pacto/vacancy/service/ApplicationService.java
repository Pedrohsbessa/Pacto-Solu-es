package br.com.pacto.vacancy.service;

import br.com.pacto.vacancy.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {
  ApplicationDTO applyForJob(ApplicationDTO applicationDTO);

  List<ApplicationDTO> getAllApplications();

  ApplicationDTO getApplicationById(Long id);

  ApplicationDTO updateApplication(Long id, ApplicationDTO applicationUpdateDto);

  void deleteApplication(Long id);
}
