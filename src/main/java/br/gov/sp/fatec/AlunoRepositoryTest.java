/**
 * 
 */
package br.gov.sp.fatec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Turma;
import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.repository.TurmaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/AlunoRepositoryTest-context.xml" })
@Transactional
public class AlunoRepositoryTest {
	
	private static final String NOME = "Usuário Teste";
	private static final String RA = "201607999";
	private static final String TURMAID = "21";
	
	@Autowired
	private AlunoRepository alunoRepo;

	public void setAlunoRepo(AlunoRepository alunoRepo) {
		this.alunoRepo = alunoRepo;
	}

	@Test
	public void testeInsercaoOk() {
		Aluno aluno = new Aluno();
		Turma turma = new Turma();
		
		turma.setId(TURMAID);
		aluno.setNome(NOME);
		aluno.setRa(RA);
		aluno.setTurma(turma);
		alunoRepo.save(aluno);
		assertNotNull(alunoRepo.buscaAluno("201607999"));
	}
	
	@Test
	public void testeBuscaOk() {
		Aluno aluno = new Aluno();
		Turma turma = new Turma();
		
		turma.setId(TURMAID);
		aluno.setNome(NOME);
		aluno.setRa(RA);
		aluno.setTurma(turma);
		alunoRepo.save(aluno);
		assertFalse(alunoRepo.buscaAluno("201607999").getRa().isEmpty());
	}

}
