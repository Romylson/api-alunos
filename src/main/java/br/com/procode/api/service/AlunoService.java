package br.com.procode.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.procode.api.entity.Aluno;
import br.com.procode.api.repository.AlunoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
	@Autowired
    private  AlunoRepository repository;


    public Aluno inserir(Aluno aluno) {
          return repository.save(aluno);
    }
  
    public List<Aluno> listar() {
        return repository.findAll();
    }

    public Aluno buscar(Long id) {
        Optional<Aluno> optional= repository.findById(id);
        if(optional.isPresent()) {
        	return optional.get();
        }
        return null;
    }

    public Aluno atualizar(Aluno aluno) {
           return repository.save(aluno);
       
    }
    public void deletar(Long id) {
    	repository.deleteById(id); ;
    }
}

