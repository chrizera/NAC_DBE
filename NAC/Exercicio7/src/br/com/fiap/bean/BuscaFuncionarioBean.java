package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.repository.FuncionarioRepository;
import br.com.fiap.to.Funcionario;

@ManagedBean
public class BuscaFuncionarioBean {

	private Funcionario funcionario;
	private FuncionarioRepository repository;
	
	@PostConstruct
	public void init() {
		
	}
}
