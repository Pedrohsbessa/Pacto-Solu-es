package br.com.pacto.vacancy.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationDTO {
  private Long userId;
  private Long jobId;
  private String feedback;
}
