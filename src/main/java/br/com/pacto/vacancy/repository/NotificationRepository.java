package br.com.pacto.vacancy.repository;

import br.com.pacto.vacancy.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {}
