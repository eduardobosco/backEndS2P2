package br.com.neki.s2p2backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.s2p2backend.exception.CollaboratorNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Collaborator;
import br.com.neki.s2p2backend.respository.CollaboratorRepository;

@Service
public class CollaboratorService {

	@Autowired
	private CollaboratorRepository collaboratorRepository;
	
	public Collaborator inserir(Collaborator collaborator) {
		Collaborator collaboratorSalvoNoBd = collaboratorRepository.save(collaborator);
		return collaboratorSalvoNoBd;

	}

	public List<Collaborator> listar() {
		return collaboratorRepository.findAll();
	}

	public Collaborator listarPorId(Integer id) throws CollaboratorNotFoundException {
		Optional<Collaborator> optionalCollaborator = collaboratorRepository.findById(id);

		if (optionalCollaborator.isPresent()) {
			return optionalCollaborator.get();
		}
		throw new CollaboratorNotFoundException("Collaborator com id " + id + " não encontrada");
	}

	public Collaborator substituir(Integer id, Collaborator collaborator)
			throws ParametroObrigatorioException, CollaboratorNotFoundException {
		if (collaborator == null)
			throw new ParametroObrigatorioException("Campo 'collaborator' é obrigatório");

		Collaborator collaboratorNoBanco = listarPorId(id);

		if (collaborator.getNome() != null) {
			collaboratorNoBanco.setNome(collaborator.getNome());
		}

		if (collaborator.getC_password() != null) {
			collaboratorNoBanco.setC_password(collaborator.getC_password());
		}
		
		return collaboratorRepository.save(collaboratorNoBanco);
	}

	public void deletar(Integer id) throws CollaboratorNotFoundException {
		Collaborator collaboratorNoBanco = listarPorId(id);
		collaboratorRepository.delete(collaboratorNoBanco);
	}

	
}
