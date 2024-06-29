package br.com.pacto.vacancy.repository;

import br.com.pacto.vacancy.entity.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationTypeRepository extends JpaRepository<NotificationType, Long> {}
