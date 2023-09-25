package br.com.procode.api.dto;

import br.com.procode.api.entity.Aluno;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoDto {
	@Size(min=10, message="O nome deve ter pelo menos 10 caracteres.")
	private String nome;
	
	@Pattern(regexp ="^[0-9]{11}$", message="O CPF deve conter exatamente 11 caracteres(Apenas números).")
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
