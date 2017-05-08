package br.com.fiap.teste;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.bo.FuncionarioBOStub;
import br.com.fiap.bo.FuncionarioBOStub.Buscar;
import br.com.fiap.bo.FuncionarioBOStub.BuscarResponse;
import br.com.fiap.bo.FuncionarioBOStub.Cadastrar;
import br.com.fiap.bo.FuncionarioBOStub.Funcionario;
import br.com.fiap.bo.FuncionarioBOStub.Listar;
import br.com.fiap.bo.FuncionarioBOStub.ListarResponse;

public class Teste {

	public static void main(String[] args) throws Exception {

		FuncionarioBOStub stub = new FuncionarioBOStub();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("1- Cadastrar\n2- Buscar\n3- Listar");
		int numero = entrada.nextInt();
		
		switch (numero) {
			case 1:
				Funcionario funcionario = new Funcionario();
				funcionario.setDataAdmissao(new GregorianCalendar(2017, Calendar.MAY, 14));
				funcionario.setNome("Roberto");
				funcionario.setSalario(1233);
				Cadastrar cadastrar = new Cadastrar();
				cadastrar.setFuncionario(funcionario);
				stub.cadastrar(cadastrar);
				System.out.println("Cadastro efetuado");
				break;
				
			case 2:
				Buscar buscar = new Buscar();
				buscar.setCodigo(1);
				BuscarResponse response = stub.buscar(buscar);
				Funcionario funcionarioBuscado = response.get_return();
				System.out.println(funcionarioBuscado.getNome() + "\n" + funcionarioBuscado.getSalario());
				break;
				
			case 3:
				Listar listar = new Listar();
				ListarResponse listarResponse = stub.listar(listar);
				List<Funcionario> funcionarios = Arrays.asList(listarResponse.get_return());
				for (Funcionario funcionarioListado : funcionarios) {
					System.out.println(funcionarioListado.getNome() + "\n" + funcionarioListado.getSalario());
				}
				
				break;
				
			default:
				System.out.println("Erro");
				break;
		}
		
		entrada.close();
	}

}
