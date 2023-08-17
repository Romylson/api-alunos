package br.com.procode.api.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

	@Entity
	@Data
	@Table(name="TB_ALUNO")
	public class Aluno {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(nullable=false,length=255)
	    private String nome;
	    @Column(nullable=false,length=11)
	    private String cpf;
	    @ManyToOne
	    @JoinColumn(name="id_turma")
	    private Turma turma;
	    
	    
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Turma getTurma() {
			return turma;
		}

		public void setTurma(Turma turma) {
			this.turma = turma;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}


	    }
		
	



