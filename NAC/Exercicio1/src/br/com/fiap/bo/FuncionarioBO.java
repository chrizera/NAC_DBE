package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.dao.impl.FuncionarioDAOImpl;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class FuncionarioBO {

	private EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
	
	public void cadastrar(Funcionario funcionario) {
		EntityManager em = fabrica.createEntityManager();

		FuncionarioDAO dao = new FuncionarioDAOImpl(em);
		
		dao.cadastrar(funcionario);
		
		try {
			dao.salvar();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		em.close();
	}
	
	public Funcionario buscar(int codigo) {
		EntityManager em = fabrica.createEntityManager();
		FuncionarioDAO dao = new FuncionarioDAOImpl(em);
		Funcionario funcionario = dao.pesquisar(codigo);
		em.close();
		return funcionario;
	}
	
	public List<Funcionario> listar() {
		EntityManager em = fabrica.createEntityManager();
		FuncionarioDAO dao = new FuncionarioDAOImpl(em);
		List<Funcionario> funcionarios = dao.listar();
		em.close();
		return funcionarios;
	}
}
