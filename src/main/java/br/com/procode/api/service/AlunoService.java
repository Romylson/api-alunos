package br.com.procode.api.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.procode.api.dto.AlunoDto;
import br.com.procode.api.entity.Aluno;
import br.com.procode.api.entity.Turma;
import br.com.procode.api.exception.AlunoJaExistenteException;
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
    			throw new AlunoJaExistenteException("O Aluno com o cpf " + alunoDto.getCpf() + " já existe.");
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
                .orElseThrow(() -> new AlunoJaExistenteException(null));

        aluno.setNome(alunoDto.getNome());
        aluno.setCpf(alunoDto.getCpf());

        return repository.save(aluno);
    }
    public void deletar(Long id) {
    	repository.deleteById(id); ;
    }
    public class CPFValidator {

        public static boolean isCPFValid(String cpf) {
            // Remove caracteres não numéricos
            cpf = cpf.replaceAll("[^0-9]", "");

            // Verifique se o CPF tem 11 dígitos
            if (cpf.length() != 11) {
                return false;
            }

            // Verifique se o CPF é uma sequência de números repetidos (e.g., 00000000000)
            if (cpf.matches("(\\d)\\1{10}")) {
                return false;
            }

            // Calcule os dígitos verificadores
            int[] digits = new int[11];
            for (int i = 0; i < 11; i++) {
                digits[i] = Character.getNumericValue(cpf.charAt(i));
            }
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 9; i++) {
                sum1 += digits[i] * (10 - i);
                sum2 += digits[i] * (11 - i);
            }
            int remainder1 = sum1 % 11;
            int remainder2 = sum2 % 11;
            int expectedDigit1 = (remainder1 < 2) ? 0 : 11 - remainder1;
            int expectedDigit2 = (remainder2 < 2) ? 0 : 11 - remainder2;

            // Verifique se os dígitos verificadores são iguais aos esperados
            return digits[9] == expectedDigit1 && digits[10] == expectedDigit2;
        
      }
  
   }
}

