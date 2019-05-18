package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Turma;
import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.repository.TurmaRepository;

@Service("alunoService")
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;

	@Override
	@Transactional
	public void transacaoSaveAluno(String ra, String nome, String id_classe) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		Turma turma = new Turma();
		
		turma.setId(id_classe);
		aluno.setRa(ra);
		aluno.setNome(nome);
		aluno.setTurma(turma);
		
		Optional<Turma> turmaOpt = turmaRepository.findById(id_classe);
		
		if (turmaOpt.isPresent() == false)
		{
			turma = new Turma();
			turma.setId(id_classe);
			turmaRepository.save(turma);
		}
		else {
			turma = turmaOpt.get();
		}
		aluno.setTurma(turma);
		alunoRepository.save(aluno);		
	}
	

	@Override
	@Transactional
	public void transacaoDelete() {
		// TODO Auto-generated method stub
		alunoRepository.deleteAll();
		
	}

	public AlunoRepository getAlunoRepository() {
		return alunoRepository;
	}

	public void setAlunoRepository(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}


	@Override
	public void transacaoSaveClasse(String id) {
		// TODO Auto-generated method stub
		Turma t = new Turma();
		
		t.setId(id);
		turmaRepository.save(t);
	}


	//jiij
	
	
	@Override
	public Aluno buscar(String ra) {
		Aluno aluno = alunoRepository.buscaAluno(ra);
		return aluno;	
	}


	@Override
	public List<Aluno> todos() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		for (Aluno aluno : alunoRepository.findAll()) {
			alunos.add(aluno);
		}
		return alunos;
	}

	@Override
	public List<Aluno> alunosPersonalizados(String nome, String turma) {
		// TODO Auto-generated method stub
		List<Aluno> alunos = new ArrayList<Aluno>();
		for (Aluno aluno : alunoRepository.buscaAlunoPersonalizado(nome, turma)) {
			alunos.add(aluno);
		}
		return alunos;
	}


	@Override
	public Aluno salvar(Aluno aluno) {
		Optional<Turma> turmaOpt = turmaRepository.findById(aluno.getTurma().getId());
		Turma turma = new Turma();
		
		if (turmaOpt.isPresent() == false)
		{
			turma.setId(aluno.getTurma().getId());
			turmaRepository.save(turma);
		}
		return alunoRepository.save(aluno);
		
	}}
