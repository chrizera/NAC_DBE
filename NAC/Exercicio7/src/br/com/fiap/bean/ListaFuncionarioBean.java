package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.FuncionarioRepository;
import br.com.fiap.to.Funcionario;

@ManagedBean
public class ListaFuncionarioBean {

	private List<Funcionario> funcionarios;
	private FuncionarioRepository repository;
	
	@PostConstruct
	public void init() {
		repository = new FuncionarioRepository();
		try {
			funcionarios = repository.listar();
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
}
