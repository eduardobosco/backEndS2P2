package br.com.neki.s2p2backend.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.s2p2backend.model.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {

}
