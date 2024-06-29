package br.com.pacto.vacancy.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "job_id", referencedColumnName = "id")
  private Job job;

  @ManyToOne
  @JoinColumn(name = "type_id", referencedColumnName = "id")
  private NotificationType type;

  @Column(nullable = false)
  private String message;

  @Column(nullable = false)
  private Boolean read;

  @Column(nullable = false)
  private Timestamp sentAt;
}
