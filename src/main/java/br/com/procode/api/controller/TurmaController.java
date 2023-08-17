package br.com.procode.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.procode.api.entity.Turma;
import br.com.procode.api.service.TurmaService;
@RestController
@RequestMapping("/api/v1/turma")
public class TurmaController {
	@Autowired
    private TurmaService service;

    @PostMapping(value="/inserir")
    @ResponseStatus(code=HttpStatus.CREATED)
    public Turma inserir(@RequestBody Turma turma) {
           return service.inserir(turma);
    }
    @GetMapping(value="/listar")
    public List<Turma> listar() {
    	return service.listar();
        
    }

    @GetMapping(value="/buscar/{id}")
    public Turma buscar(@PathVariable Long id) {
        return service.buscar(id);
       
    }

    @PutMapping(value="/atualizar/{id}")
    public Turma atualizar(@RequestBody Turma turma) {
    	   return service.atualizar(turma);
    }

    @DeleteMapping(value="/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}


