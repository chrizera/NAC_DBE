package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entity.Funcionario;

public class FuncionarioDAOImpl extends GenericDAOImpl<Funcionario, Integer> implements FuncionarioDAO {

	public FuncionarioDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Funcionario> listar() {
		return em.createQuery("from Funcionario", Funcionario.class).getResultList();
	}
}
