package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.dao.impl.FuncionarioDAOImpl;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class FuncionarioBO {

	private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	public void cadastrar(Funcionario funcionario) {
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
		FuncionarioDAO dao = new FuncionarioDAOImpl(em);
		em.close();
		return dao.pesquisar(codigo);
	}
	
	public List<Funcionario> listar() {
		FuncionarioDAO dao = new FuncionarioDAOImpl(em);
		em.close();
		return dao.listar();
	}
	
	public void remover(int codigo) {
		FuncionarioDAO dao = new FuncionarioDAOImpl(em);
		try {
			dao.remover(codigo);
			dao.salvar();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAOImpl(em);
		dao.alterar(funcionario);
		try {
			dao.salvar();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		em.close();
	}
}
