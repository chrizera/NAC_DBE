package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Funcionario;

public interface FuncionarioDAO extends GenericDAO<Funcionario, Integer> {

	List<Funcionario> listar();
}
