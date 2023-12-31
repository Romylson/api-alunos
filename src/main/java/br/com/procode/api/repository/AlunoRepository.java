package br.com.procode.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.procode.api.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long > {

	Aluno findByCpf(String cpf);


}
