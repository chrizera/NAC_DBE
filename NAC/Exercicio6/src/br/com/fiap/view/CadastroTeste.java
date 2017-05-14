package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.FuncionarioRepository;
import br.com.fiap.to.Funcionario;

public class CadastroTeste {

	public static void main(String[] args) {
		FuncionarioRepository repository = new FuncionarioRepository();

		Funcionario funcionario = new Funcionario("Christian", 666, new GregorianCalendar(2017, Calendar.MAY, 2));		
		
		try {
			repository.cadastrar(funcionario);
			System.out.println("Cadastro efetuado");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
