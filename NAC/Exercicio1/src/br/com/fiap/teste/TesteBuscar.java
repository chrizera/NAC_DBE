package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.dao.impl.FuncionarioDAOImpl;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class TesteBuscar {

	public static void main(String[] args) {
	
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		FuncionarioDAO dao = new FuncionarioDAOImpl(em);
		
		try {
			Funcionario funcionario = dao.pesquisar(2);
			System.out.println(funcionario.getNome() + "\n" + funcionario.getSalario());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		em.close();
		System.exit(0);
	}

}
