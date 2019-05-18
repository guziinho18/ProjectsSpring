package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Turma;

public interface AlunoService {
	
	public void transacaoSaveAluno(String ra, String nome, String id_classe);
	public void transacaoSaveClasse(String id);
	public void transacaoDelete();
	public List<Aluno> todos ();
	public Aluno buscar(String ra);
	public List<Aluno> alunosPersonalizados(String nome, String turma);
	public Aluno salvar(Aluno aluno);

}
