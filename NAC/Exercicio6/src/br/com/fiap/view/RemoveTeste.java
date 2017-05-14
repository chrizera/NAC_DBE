package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.FuncionarioRepository;

public class RemoveTeste {

	public static void main(String[] args) {
		FuncionarioRepository repository = new FuncionarioRepository();
		try {
			repository.remover(3);
			System.out.println("removido");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
}
