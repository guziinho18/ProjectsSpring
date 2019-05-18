package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Turma;

public interface AlunoRepository extends CrudRepository<Aluno, String>{
	
	public Aluno findByNome(String nome);
		
	@Query("select a from Aluno a where a.ra = ?1")
	public Aluno buscaAluno(String ra);
	
	@Query("select a from Aluno a join a.turma t where a.nome = ?1 and t.id = ?2")
	public List<Aluno> buscaAlunoPersonalizado(String nome, String turma);
}
