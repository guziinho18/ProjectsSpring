package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.View.View;



@Entity
@Table(name = "turma")
public class Turma {
	@Id 
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", length=5, nullable = false)
	@JsonView(View.AlunoResumo.class)
	private String id;
	
	@Column(name = "qtd_disciplinas")
	private int qtd_disciplinas;
	
	@Column(name = "qtd_prof")
	private int qtd_prof;
	
	@Column(name = "media_turma")
	private int media_turma;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="turma")
    private List<Aluno> aluno;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQtd_disciplinas() {
		return qtd_disciplinas;
	}

	public void setQtd_disciplinas(int qtd_disciplinas) {
		this.qtd_disciplinas = qtd_disciplinas;
	}

	public int getQtd_prof() {
		return qtd_prof;
	}

	public void setQtd_prof(int qtd_prof) {
		this.qtd_prof = qtd_prof;
	}

	public int getMedia_turma() {
		return media_turma;
	}

	public void setMedia_turma(int media_turma) {
		this.media_turma = media_turma;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}

	
	
	
	
	

	
	

}
