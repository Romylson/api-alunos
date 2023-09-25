package br.com.procode.api.dto;

import lombok.Data;

@Data
public class ErroDto {
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String campo;
	public String mensagem;
}
