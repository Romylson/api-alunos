package br.com.procode.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.procode.api.entity.Aluno;
import br.com.procode.api.service.AlunoService;

import java.util.List;


	@RestController
	@RequestMapping("/api/v1/alunos")
	public class AlunoController {
		@Autowired
	    private AlunoService service;

	    @PostMapping(value="/inserir")
	    public Aluno inserir(@RequestBody Aluno aluno) {
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
	    public Aluno atualizar(@RequestBody Aluno aluno) {
	    	   return service.atualizar(aluno);
	    }

	    @DeleteMapping(value="/deletar/{id}")
	    public void deletar(@PathVariable Long id) {
	        service.deletar(id);
	    }
	}

