package br.com.procode.api.dto;

import lombok.Data;

@Data
public class UsuarioDto {
	private String Login;
	private String Senha;
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	
}
