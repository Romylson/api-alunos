package br.com.procode.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.procode.api.entity.Turma;
import br.com.procode.api.repository.TurmaRepository;
@Service
public class TurmaService {
	@Autowired
    private  TurmaRepository repository;
	

    public Turma inserir(Turma turma) {
          return repository.save(turma);
    }
  
    public List<Turma> listar() {
        return repository.findAll();
    }

    public Turma buscar(Long id) {
        Optional<Turma> optional= repository.findById(id);
        if(optional.isPresent()) {
        	return optional.get();
        }
        return null;
    }

    public Turma atualizar(Turma turma) {
           return repository.save(turma);
       
    }
    public void deletar(Long id) {
    	repository.deleteById(id); ;
    }
}
