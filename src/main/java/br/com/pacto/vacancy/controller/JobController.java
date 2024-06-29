package br.com.pacto.vacancy.controller;

import br.com.pacto.vacancy.dto.JobCreationDto;
import br.com.pacto.vacancy.entity.Job;
import br.com.pacto.vacancy.service.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

  private final JobService jobService;

  @Autowired
  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @PostMapping
  @Operation(summary = "Create a new job", responses = {
          @ApiResponse(description = "The created job", content = @Content(schema = @Schema(implementation = Job.class)))
  })
  public ResponseEntity<Job> createJob(@RequestBody JobCreationDto jobCreationDto) {
    Job job = jobService.createJob(jobCreationDto);
    return ResponseEntity.ok(job);
  }

  @GetMapping
  @Operation(summary = "List all jobs", responses = {
          @ApiResponse(description = "List of jobs", content = @Content(schema = @Schema(implementation = Job.class)))
  })
  public ResponseEntity<List<Job>> getAllJobs() {
    List<Job> jobs = jobService.getAllJobs();
    return ResponseEntity.ok(jobs);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get a job by ID", responses = {
          @ApiResponse(description = "The job", content = @Content(schema = @Schema(implementation = Job.class)))
  })
  public ResponseEntity<Job> getJobById(@Parameter(description = "ID of the job to get") @PathVariable Long id) {
    Job job = jobService.getJobById(id);
    return ResponseEntity.ok(job);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update a job", responses = {
          @ApiResponse(description = "The updated job", content = @Content(schema = @Schema(implementation = Job.class)))
  })
  public ResponseEntity<Job> updateJob(
          @Parameter(description = "ID of the job to update") @PathVariable Long id,
          @RequestBody JobCreationDto jobUpdateDto) {
    Job job = jobService.updateJob(id, jobUpdateDto);
    return ResponseEntity.ok(job);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a job", responses = {
          @ApiResponse(description = "No content", responseCode = "204")
  })
  public ResponseEntity<Void> deleteJob(@Parameter(description = "ID of the job to delete") @PathVariable Long id) {
    jobService.deleteJob(id);
    return ResponseEntity.noContent().build();
  }
}