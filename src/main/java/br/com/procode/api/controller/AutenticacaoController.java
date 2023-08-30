package br.com.procode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.procode.api.dto.LoginDto;
import br.com.procode.api.entity.Usuario;
import br.com.procode.api.service.TokenService;



@RestController
@RequestMapping("/api/v1/auth")
public class AutenticacaoController {
	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private TokenService tokenService;
	@PostMapping
	public ResponseEntity<?> auth(@RequestBody LoginDto dto){
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha());
		Authentication authenticate = manager.authenticate(authenticationToken);
		String token = tokenService.gerarToken((Usuario) authenticate.getPrincipal());
		return ResponseEntity.ok().body(token);
		
	}
}
