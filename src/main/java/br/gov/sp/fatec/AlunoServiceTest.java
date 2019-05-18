/**
 * 
 */
package br.gov.sp.fatec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.service.AlunoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/AlunoRepositoryTest-context.xml" })
@Transactional
public class AlunoServiceTest {
	
	private static final String NOME = "Usuário Teste";
	private static final String RA = "201607999";
	private static final String TURMAID = "21";
	
	@Autowired
	private AlunoRepository alunoRepo;

	public void setAlunoRepo(AlunoRepository alunoRepo) {
		this.alunoRepo = alunoRepo;
	}
	
	@Autowired
	private AlunoService alunoService;

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@Test
	public void Teste1 () {
		assertTrue(alunoService.todos().isEmpty());
	}

}
