package br.com.procode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.procode.api.dto.UsuarioCriadoDto;
import br.com.procode.api.dto.UsuarioDto;
import br.com.procode.api.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
	@Autowired 
	private UsuarioService service;
	
	 @PostMapping(value="/inserir")
	    public UsuarioCriadoDto inserir(@RequestBody UsuarioDto dto) {
	           return service.inserir(dto);
	    }
	
}
