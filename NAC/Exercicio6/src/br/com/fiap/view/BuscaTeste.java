package br.com.fiap.view;

import java.util.List;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.FuncionarioRepository;
import br.com.fiap.to.Funcionario;

public class BuscaTeste {

	public static void main(String[] args) {
		FuncionarioRepository repository = new FuncionarioRepository();
		
		try {
			System.out.println("Listagem");
			List<Funcionario> funcionarios = repository.listar();
			for (Funcionario funcionario : funcionarios) {
				System.out.println(funcionario.getNome());
			}
			
			System.out.println("Busca por c�digo");
			Funcionario funcionario = repository.buscar(2);
			System.out.println(funcionario.getNome());
			
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
