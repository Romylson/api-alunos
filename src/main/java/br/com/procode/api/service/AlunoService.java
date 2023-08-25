package br.com.procode.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.procode.api.dto.AlunoDto;
import br.com.procode.api.entity.Aluno;
import br.com.procode.api.entity.Turma;
import br.com.procode.api.exception.AlunoNotFoundException;
import br.com.procode.api.repository.AlunoRepository;
import br.com.procode.api.repository.TurmaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
	@Autowired
    private  AlunoRepository repository;
	@Autowired
	private TurmaRepository turmaRepository;

    public Aluno inserir(AlunoDto alunoDto) {
    	Aluno alunoComCpf = repository.findByCpf(alunoDto.getCpf());
    		if(alunoComCpf !=null) {
    			return null;
    		}else {
    			Aluno aluno = alunoDto.toModel();
    			Optional<Turma> turma = turmaRepository.findById(alunoDto.getIdTurma());
    			if(turma.isPresent()) {
    			   aluno.setTurma(turma.get());
    			}
    			
    			return repository.save(aluno);
    		}
          
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

    public Aluno atualizar(Long id,AlunoDto alunoDto) {
    	Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException(id));

        aluno.setNome(alunoDto.getNome());
        aluno.setCpf(alunoDto.getCpf());

        return repository.save(aluno);
    }
    public void deletar(Long id) {
    	repository.deleteById(id); ;
    }
}

