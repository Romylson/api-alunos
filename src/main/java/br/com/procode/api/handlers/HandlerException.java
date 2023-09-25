package br.com.procode.api.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import br.com.procode.api.dto.ErroDto;
import br.com.procode.api.exception.AlunoJaExistenteException;

@RestController
public class HandlerException {
	@ExceptionHandler(AlunoJaExistenteException.class)
	public ResponseEntity<String> alunoJaExistenteException(AlunoJaExistenteException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity <List<ErroDto>> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		List<ErroDto> erros = new ArrayList<>();
		for(FieldError error : ex.getBindingResult().getFieldErrors()) {
			ErroDto erro = new ErroDto();
			erro.setCampo(error.getField());
			erro.setMensagem(error.getField());
			erros.add(erro);
		}
		for(ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			ErroDto erro = new ErroDto();
			erro.setCampo(error.getObjectName());
			erro.setMensagem(error.getDefaultMessage());
			erros.add(erro);
		}
				return ResponseEntity.badRequest().body(erros);
	}
}

