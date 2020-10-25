package br.com.neki.s2p2backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.s2p2backend.exception.DepartamentNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Departament;
import br.com.neki.s2p2backend.respository.DepartamentRepository;

@Service
public class DepartamentService {

	@Autowired
	private DepartamentRepository departamentRepository;
	
	public Departament inserir(Departament departament) {
		Departament departamentSalvoNoBd = departamentRepository.save(departament);
		return departamentSalvoNoBd;

	}

	public List<Departament> listar() {
		return departamentRepository.findAll();
	}

	public Departament listarPorId(Integer id) throws DepartamentNotFoundException {
		Optional<Departament> optionalDepartament = departamentRepository.findById(id);

		if (optionalDepartament.isPresent()) {
			return optionalDepartament.get();
		}
		throw new DepartamentNotFoundException("Departament com id " + id + " não encontrada");
	}

	public Departament substituir(Integer id, Departament departament)
			throws ParametroObrigatorioException, DepartamentNotFoundException {
		if (departament == null)
			throw new ParametroObrigatorioException("Campo 'departament' é obrigatório");

		Departament departamentNoBanco = listarPorId(id);

		if (departament.getDepartamentName() != null) {
			departamentNoBanco.setDepartamentName(departament.getDepartamentName());
		}
		
		return departamentRepository.save(departamentNoBanco);
	}

	public void deletar(Integer id) throws DepartamentNotFoundException {
		Departament departamentNoBanco = listarPorId(id);
		departamentRepository.delete(departamentNoBanco);
	}

	
}
