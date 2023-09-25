package br.com.procode.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.procode.api.dto.AlunoDto;
import br.com.procode.api.entity.Aluno;
import br.com.procode.api.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;


	@RestController
	@RequestMapping("/api/v1/alunos")
	@Tag(name="Alunos",description = "Controlador que gerencia os dados dos alunos")
	public class AlunoController {
		@Autowired
	    private AlunoService service;

	    @PostMapping(value="/inserir")
	    @ResponseStatus(code=HttpStatus.CREATED)
	    @Operation(summary = "Ele recebe um AlunoDTo,salva no banco de dados e retorna um aluno")
	    public Aluno inserir(@RequestBody @Valid AlunoDto aluno) {
	           return service.inserir(aluno);
	    }
	    @GetMapping(value="/listar")
	    public List<Aluno> listar() {
	    	return service.listar();
	        
	    }

	    @GetMapping(value="/buscar/{id}")
	    public Aluno buscar(@PathVariable Long id) {
	        return service.buscar(id);
	       
	    }

	    @PutMapping(value="/atualizar/{id}")
	    public Aluno atualizar(@PathVariable Long id, @RequestBody AlunoDto aluno) {
	    	   return service.atualizar(id,aluno);
	    }

	    @DeleteMapping(value="/deletar/{id}")
	    public void deletar(@PathVariable Long id) {
	        service.deletar(id);
	    }
	}

