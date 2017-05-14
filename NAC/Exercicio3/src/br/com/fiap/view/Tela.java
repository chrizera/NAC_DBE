package br.com.fiap.view;

import java.util.Calendar;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ibm.icu.text.SimpleDateFormat;

import br.com.fiap.bo.FuncionarioBOStub;
import br.com.fiap.bo.FuncionarioBOStub.Buscar;
import br.com.fiap.bo.FuncionarioBOStub.BuscarResponse;
import br.com.fiap.bo.FuncionarioBOStub.Cadastrar;
import br.com.fiap.bo.FuncionarioBOStub.Funcionario;

public class Tela {

	protected Shell shell;
	private Text txtNome;
	private Text txtSalario;
	private Text txtDataDeAdmissao;
	private Text txtCodigo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(10, 22, 55, 15);
		lblNome.setText("Nome");
		
		Label lblSalario = new Label(shell, SWT.NONE);
		lblSalario.setBounds(10, 75, 55, 15);
		lblSalario.setText("Salario");
		
		Label lblDataDeAdmissao = new Label(shell, SWT.NONE);
		lblDataDeAdmissao.setBounds(10, 144, 102, 15);
		lblDataDeAdmissao.setText("Data de admissao");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(59, 22, 76, 21);
		
		txtSalario = new Text(shell, SWT.BORDER);
		txtSalario.setBounds(59, 69, 76, 21);
		
		txtDataDeAdmissao = new Text(shell, SWT.BORDER);
		txtDataDeAdmissao.setBounds(10, 171, 76, 21);
		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String nome = txtNome.getText();
				double salario = Float.parseFloat(txtSalario.getText());
				Calendar dataAdmissao = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
				dataAdmissao.setTime(sdf.parse(txtDataDeAdmissao.getText()));
				FuncionarioBOStub stub = new FuncionarioBOStub();
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(nome);
				funcionario.setSalario(salario);
				funcionario.setDataAdmissao(dataAdmissao);
				Cadastrar cadastrar = new Cadastrar();
				cadastrar.setFuncionario(funcionario);
				stub.cadastrar(cadastrar);
				System.out.println("cadastrado efetuado");
				}
				catch(Exception ee){
					ee.printStackTrace();
				}
				
			}
		});
		btnCadastrar.setBounds(37, 214, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		Label lblCodigo = new Label(shell, SWT.NONE);
		lblCodigo.setBounds(245, 22, 55, 15);
		lblCodigo.setText("Codigo");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(324, 22, 76, 21);
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Buscar buscar = new Buscar();
				buscar.setCodigo(Integer.parseInt(txtCodigo.getText()));
				try {
					FuncionarioBOStub stub = new FuncionarioBOStub();
					BuscarResponse response = stub.buscar(buscar);
					Funcionario funcionarioBuscado = response.get_return();
					txtDataDeAdmissao.setText(funcionarioBuscado.getDataAdmissao().toString());
					txtNome.setText(funcionarioBuscado.getNome());
					txtSalario.setText(String.valueOf(funcionarioBuscado.getSalario()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBuscar.setBounds(275, 75, 75, 25);
		btnBuscar.setText("Buscar");

	}
}
