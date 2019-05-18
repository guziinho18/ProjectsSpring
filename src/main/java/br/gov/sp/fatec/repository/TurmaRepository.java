package br.gov.sp.fatec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Turma;

public interface TurmaRepository extends CrudRepository<Turma, String>{
	
	public Optional<Turma> findById (String id);
	
	@Query("select distinct a from Aluno a join a.turma t where t.id = ?1")
	public List<Aluno> buscaAlunos (String id);
	
}
