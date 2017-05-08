package br.com.fiap.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.dao.impl.FuncionarioDAOImpl;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class TesteListar {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		FuncionarioDAO dao = new FuncionarioDAOImpl(em);
		
		List<Funcionario> funcionarios = dao.listar();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getNome());
		}
	}

}
