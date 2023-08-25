package br.com.procode.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNotFoundException  extends RuntimeException {
	public AlunoNotFoundException(Long id) {
        super("Aluno não encontrado com ID: " + id);
    }

}
