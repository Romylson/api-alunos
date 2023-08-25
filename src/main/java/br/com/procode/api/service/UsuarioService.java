package br.com.procode.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.procode.api.dto.UsuarioCriadoDto;
import br.com.procode.api.dto.UsuarioDto;
import br.com.procode.api.entity.Usuario;
import br.com.procode.api.repository.UsuarioRepository;



@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PasswordEncoder passwordencoder;
	
	public UsuarioCriadoDto inserir(UsuarioDto dto) {
		Usuario usuario = new Usuario();
		usuario.setLogin(dto.getLogin());
		usuario.setSenha(passwordencoder.encode(dto.getSenha()));
		repository.save(usuario);
		UsuarioCriadoDto usuarioCriado = new UsuarioCriadoDto();
		usuarioCriado.setId(usuario.getId());
		usuarioCriado.setLogin(usuario.getLogin());
		
		return usuarioCriado;
	}

}
