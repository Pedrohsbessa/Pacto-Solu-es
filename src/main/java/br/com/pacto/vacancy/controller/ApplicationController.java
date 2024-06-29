package br.com.pacto.vacancy.controller;

import br.com.pacto.vacancy.dto.ApplicationDTO;
import br.com.pacto.vacancy.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

  private final ApplicationService applicationService;

  @Autowired
  public ApplicationController(ApplicationService applicationService) {
    this.applicationService = applicationService;
  }

  @PostMapping
  @Operation(summary = "Apply for a job", responses = {
          @ApiResponse(responseCode = "200", description = "Application successful", content = @Content(schema = @Schema(implementation = ApplicationDTO.class))),
          @ApiResponse(responseCode = "400", description = "Invalid application details")
  })
  public ResponseEntity<ApplicationDTO> applyForJob(@RequestBody ApplicationDTO applicationDTO) {
    ApplicationDTO application = applicationService.applyForJob(applicationDTO);
    return ResponseEntity.ok(application);
  }

  @GetMapping
  @Operation(summary = "Get all applications", responses = {
          @ApiResponse(responseCode = "200", description = "Found all applications", content = @Content(schema = @Schema(implementation = ApplicationDTO.class)))
  })
  public ResponseEntity<List<ApplicationDTO>> getAllApplications() {
    List<ApplicationDTO> applications = applicationService.getAllApplications();
    return ResponseEntity.ok(applications);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get application by ID", responses = {
          @ApiResponse(responseCode = "200", description = "Found application", content = @Content(schema = @Schema(implementation = ApplicationDTO.class))),
          @ApiResponse(responseCode = "404", description = "Application not found")
  })
  public ResponseEntity<ApplicationDTO> getApplicationById(@PathVariable Long id) {
    ApplicationDTO application = applicationService.getApplicationById(id);
    return ResponseEntity.ok(application);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update an application", responses = {
          @ApiResponse(responseCode = "200", description = "Application updated", content = @Content(schema = @Schema(implementation = ApplicationDTO.class))),
          @ApiResponse(responseCode = "404", description = "Application not found"),
          @ApiResponse(responseCode = "400", description = "Invalid update details")
  })
  public ResponseEntity<ApplicationDTO> updateApplication(
          @PathVariable Long id, @RequestBody ApplicationDTO applicationUpdateDto) {
    ApplicationDTO application = applicationService.updateApplication(id, applicationUpdateDto);
    return ResponseEntity.ok(application);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete an application", responses = {
          @ApiResponse(responseCode = "204", description = "Application deleted"),
          @ApiResponse(responseCode = "404", description = "Application not found")
  })
  public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
    applicationService.deleteApplication(id);
    return ResponseEntity.noContent().build();
  }
}