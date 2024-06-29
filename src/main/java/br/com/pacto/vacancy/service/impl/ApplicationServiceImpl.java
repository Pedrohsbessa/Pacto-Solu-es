package br.com.pacto.vacancy.service.impl;

import br.com.pacto.vacancy.dto.ApplicationDTO;
import br.com.pacto.vacancy.dto.mapper.ApplicationMapper;
import br.com.pacto.vacancy.entity.Application;
import br.com.pacto.vacancy.repository.ApplicationRepository;
import br.com.pacto.vacancy.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

  private final ApplicationRepository applicationRepository;
  private final ApplicationMapper applicationMapper;

  @Autowired
  public ApplicationServiceImpl(
      ApplicationRepository applicationRepository, ApplicationMapper applicationMapper) {
    this.applicationRepository = applicationRepository;
    this.applicationMapper = applicationMapper;
  }

  @Override
  public ApplicationDTO applyForJob(ApplicationDTO applicationDTO) {
    Application application = applicationMapper.dtoToEntity(applicationDTO);
    return applicationMapper.entityToDto(applicationRepository.save(application));
  }

  @Override
  public List<ApplicationDTO> getAllApplications() {
    return applicationRepository.findAll().stream()
        .map(applicationMapper::entityToDto)
        .collect(Collectors.toList());
  }

  @Override
  public ApplicationDTO getApplicationById(Long id) {
    Application application =
        applicationRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));
    return applicationMapper.entityToDto(application);
  }

  @Override
  public ApplicationDTO updateApplication(Long id, ApplicationDTO applicationUpdateDto) {
    Application application =
        applicationRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));
    applicationMapper.dtoToEntity(applicationUpdateDto);
    return applicationMapper.entityToDto(applicationRepository.save(application));
  }

  @Override
  public void deleteApplication(Long id) {
    applicationRepository.deleteById(id);
  }
}
