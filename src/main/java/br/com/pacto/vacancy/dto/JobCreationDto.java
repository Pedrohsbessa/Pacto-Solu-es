package br.com.pacto.vacancy.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobCreationDto {
  private String title;
  private String description;
  private Long createdById;
}
