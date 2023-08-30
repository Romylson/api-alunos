package br.com.procode.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.procode.api.entity.Turma;
@Repository

public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
