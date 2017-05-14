package br.com.fiap.bean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.FuncionarioBOStub;
import br.com.fiap.bo.FuncionarioBOStub.Funcionario;
import br.com.fiap.bo.FuncionarioBOStub.Listar;
import br.com.fiap.bo.FuncionarioBOStub.ListarResponse;

@ManagedBean
public class ListaFuncionarioBean {

	private FuncionarioBOStub stub;
	private List<Funcionario> funcionarios;
	
	@PostConstruct
	public void init() {
		Listar listar = new Listar();
		
		try {
			stub = new FuncionarioBOStub();
			ListarResponse response = stub.listar(listar);
			funcionarios = Arrays.asList(response.get_return());

			
		} catch (Exception e) {
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
