package br.com.neki.s2p2backend.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.s2p2backend.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
