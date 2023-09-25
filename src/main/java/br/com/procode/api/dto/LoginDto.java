package br.com.procode.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class LoginDto {
	@NotNull(message = "O nome de usuário não pode ser nulo.")
    @Size(min = 3, max = 20, message = "O nome de usuário deve ter entre 3 e 20 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "O nome de usuário deve conter apenas letras, números, traços e sublinhados.")
	private String login;
	@NotNull(message = "A senha não pode ser nula.")
    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres.")
	private String senha;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
