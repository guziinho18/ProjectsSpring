package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.View.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "aluno")
public class Aluno {
	
	@Id
    @Column(name = "ra", length=20, nullable = false)
	@JsonView(View.AlunoResumo.class)
	private String ra;
	
	@Column(name = "curso", length = 50)
	@JsonView(View.AlunoCompleto.class)
    private String curso;
	
	@Column(name = "nome", length = 50, nullable = false)
	@JsonView(View.AlunoResumo.class)
    private String nome;
	
	@Column(name = "sexo", length = 20)
	@JsonView(View.AlunoCompleto.class)
    private String sexo;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_classe", nullable = false)
	@JsonView(View.AlunoCompleto.class)
    private Turma turma;

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}		
}
