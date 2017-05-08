package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_NAC_FUNCIONARIO")
@SequenceGenerator(allocationSize = 1, name = "seqFuncionario", sequenceName = "SQ_T_NAC_FUNCIONARIO")
public class Funcionario {

	@Id
	@Column(name = "CD_FUNCIONARIO")
	@GeneratedValue(generator = "seqFuncionario", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_FUNCIONARIO")
	private String nome;
	
	@Column(name = "VL_SALARIO")
	private double salario;
	
	@Column(name = "DT_ADMISSAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataAdmissao;

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, double salario, Calendar dataAdmissao) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	
}
