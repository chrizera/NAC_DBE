package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.FuncionarioRepository;
import br.com.fiap.to.Funcionario;

public class AtualizaTeste {

	public static void main(String[] args) {
		FuncionarioRepository repository = new FuncionarioRepository();
		
		try {
			Funcionario funcionario = repository.buscar(2);
			System.out.println(funcionario.getNome());
			funcionario.setNome("Maria");
			repository.atualizar(funcionario);
			System.out.println("Atualizado - " + funcionario.getNome());
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
