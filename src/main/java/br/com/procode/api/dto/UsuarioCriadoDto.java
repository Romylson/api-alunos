package br.com.procode.api.dto;
import lombok.Data;

@Data
public class UsuarioCriadoDto {
	private long id;
	private String login;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
