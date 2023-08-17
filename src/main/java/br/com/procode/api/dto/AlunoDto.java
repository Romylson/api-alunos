package br.com.procode.api.dto;

import br.com.procode.api.entity.Aluno;
import lombok.Data;

@Data
public class AlunoDto {
	
	private String nome;
	private String cpf;
	

	private Long idTurma;
	
	public Aluno toModel() {
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		return aluno;
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}
	
}
