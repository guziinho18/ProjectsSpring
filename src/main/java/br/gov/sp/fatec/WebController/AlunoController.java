package br.gov.sp.fatec.WebController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.id.IdentifierGenerationException;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Turma;
import br.gov.sp.fatec.service.AlunoService;
import br.gov.sp.fatec.View.*;

@RequestMapping(value = "/aluno")
@RestController
public class AlunoController {
	@Autowired
	private AlunoService alunoService;

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@RequestMapping(value = "/")
	public String hello() {
		return ("Olá Mundo");
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@JsonView(View.AlunoCompleto.class)
	public ResponseEntity get(String ra) {
		Aluno aluno = alunoService.buscar(ra);
		if (aluno == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado aluno com esse RA.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@JsonView(View.AlunoResumo.class)
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(alunoService.todos());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado registro !");
		}
	}
	
	@RequestMapping(value = "/getStudents", method = RequestMethod.GET)
	@JsonView(View.AlunoResumo.class)
	public ResponseEntity getStudents(String nome, String turma) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos = alunoService.alunosPersonalizados(nome, turma);
		if (alunos.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foram encontrado alunos com os seguintes parâmetros !");
		}
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	@JsonView(View.AlunoCompleto.class)
	public ResponseEntity save(@RequestBody Aluno aluno, HttpServletRequest request, HttpServletResponse response) {
		if (aluno.getNome() == null || aluno.getRa() == null || aluno.getTurma().getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Os campos obrigatórios não foram preenchidos");
		}
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/usuario/getById?id=" + aluno.getRa());
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(aluno));
	}
}
