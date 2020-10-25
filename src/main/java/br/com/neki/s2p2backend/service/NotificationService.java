package br.com.neki.s2p2backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.s2p2backend.exception.NotificationNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Notification;
import br.com.neki.s2p2backend.respository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	public Notification inserir(Notification notification) {
		Notification notificationSalvoNoBd = notificationRepository.save(notification);
		return notificationSalvoNoBd;

	}

	public List<Notification> listar() {
		return notificationRepository.findAll();
	}

	public Notification listarPorId(Integer id) throws NotificationNotFoundException {
		Optional<Notification> optionalNotification = notificationRepository.findById(id);

		if (optionalNotification.isPresent()) {
			return optionalNotification.get();
		}
		throw new NotificationNotFoundException("Notification com id " + id + " não encontrada");
	}

	public Notification substituir(Integer id, Notification notification)
			throws ParametroObrigatorioException, NotificationNotFoundException {
		if (notification == null)
			throw new ParametroObrigatorioException("Campo 'notification' é obrigatório");

		Notification notificationNoBanco = listarPorId(id);

		if (notification.getManager_Comment() != null) {
			notificationNoBanco.setManager_Comment(notification.getManager_Comment());
		}

		if (notification.getNotification_Status() != null) {
			notificationNoBanco.setNotification_Status(notification.getNotification_Status());
		}
		
		return notificationRepository.save(notificationNoBanco);
	}

	public void deletar(Integer id) throws NotificationNotFoundException {
		Notification notificationNoBanco = listarPorId(id);
		notificationRepository.delete(notificationNoBanco);
	}

	
}
