package apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import dados.Contribuinte;
import negocio.GerenciarReceita;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class PrincipalGUI {

	private JFrame frmReceitaFederal;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtIdade;
	private JTextField txtEndereco;
	private JTextField txtContaBancaria;
	private GerenciarReceita gerenciarReceita = new GerenciarReceita();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtReceitaNumProtocolo;
	private JTextField txtReceitaCNPJ;
	private JTextField txtReceitaValor;
	private JTextField txtDespesaNumProtocolo;
	private JTextField txtDespesaCNPJ;
	private JTextField txtDespesaValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI window = new PrincipalGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReceitaFederal = new JFrame();
		frmReceitaFederal.setTitle("Receita Federal");
		frmReceitaFederal.setBounds(100, 100, 550, 490);
		frmReceitaFederal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReceitaFederal.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("550px"),},
			new RowSpec[] {
				RowSpec.decode("460px"),}));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmReceitaFederal.getContentPane().add(tabbedPane, "1, 1, fill, fill");
		
		JTabbedPane tpContribuinte = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Contribuinte", null, tpContribuinte, null);
		
		JPanel pSelectContribuinte = new JPanel();
		tpContribuinte.addTab("Consultar", null, pSelectContribuinte, null);
		pSelectContribuinte.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("250px"),
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("200px"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("30px"),
				RowSpec.decode("250px"),
				RowSpec.decode("30px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblConsultaDeContribuinte = new JLabel("CONSULTA DE CONTRIBUINTE");
		lblConsultaDeContribuinte.setFont(new Font("Dialog", Font.BOLD, 14));
		pSelectContribuinte.add(lblConsultaDeContribuinte, "2, 2");
		
		JLabel lblContribuinteDados = new JLabel("Dados:");
		pSelectContribuinte.add(lblContribuinteDados, "4, 2, left, center");
		
		JList listContribuinte = new JList();
		pSelectContribuinte.add(listContribuinte, "2, 3, fill, fill");
		
		JLabel lblContribuinte = new JLabel("");
		pSelectContribuinte.add(lblContribuinte, "4, 3");
		
		JButton btnVerificarBens = new JButton("Verificar Bens");
		pSelectContribuinte.add(btnVerificarBens, "2, 4");
		
		JButton btnVerificarDependentes = new JButton("Verificar Dependentes");
		pSelectContribuinte.add(btnVerificarDependentes, "2, 6");
		
		JPanel pInsertContribuinte = new JPanel();
		tpContribuinte.addTab("Cadastrar", null, pInsertContribuinte, null);
		pInsertContribuinte.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("300px"),
				ColumnSpec.decode("25px"),
				ColumnSpec.decode("230px"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("17px"),
				RowSpec.decode("21px"),
				RowSpec.decode("15px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCadastroDeContribuinte = new JLabel("CADASTRO DE CONTRIBUINTE");
		lblCadastroDeContribuinte.setFont(new Font("Dialog", Font.BOLD, 14));
		pInsertContribuinte.add(lblCadastroDeContribuinte, "2, 2, left, center");
		
		JLabel lblCpf = new JLabel("CPF");
		pInsertContribuinte.add(lblCpf, "2, 4, left, center");
		
		txtCpf = new JTextField();
		pInsertContribuinte.add(txtCpf, "2, 6, left, center");
		txtCpf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		pInsertContribuinte.add(lblNome, "2, 8, left, center");
		
		txtNome = new JTextField();
		pInsertContribuinte.add(txtNome, "2, 10, left, center");
		txtNome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		pInsertContribuinte.add(lblIdade, "2, 12, left, center");
		
		txtIdade = new JTextField();
		pInsertContribuinte.add(txtIdade, "2, 14, left, center");
		txtIdade.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço");
		pInsertContribuinte.add(lblEndereo, "2, 16, left, center");
		
		txtEndereco = new JTextField();
		pInsertContribuinte.add(txtEndereco, "2, 18, left, center");
		txtEndereco.setColumns(10);
		
		JLabel lblNumFuncionrios = new JLabel("Conta Bancária");
		pInsertContribuinte.add(lblNumFuncionrios, "2, 20, fill, center");
		
		txtContaBancaria = new JTextField();
		pInsertContribuinte.add(txtContaBancaria, "2, 22, left, center");
		txtContaBancaria.setColumns(10);
		
		JButton btnContribuinteCadastrar = new JButton("Cadastrar");
		btnContribuinteCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contribuinte contribuinte = new Contribuinte();
				contribuinte.setCpf(txtCpf.getText());
				contribuinte.setNome(txtNome.getText());
				contribuinte.setIdade(Integer.parseInt(txtIdade.getText()));
				contribuinte.setEndereco(txtEndereco.getText());
				contribuinte.setContaBancaria(Integer.parseInt(txtContaBancaria.getText()));
				gerenciarReceita.insertContribuinte(contribuinte);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
			}
		});
		pInsertContribuinte.add(btnContribuinteCadastrar, "2, 24, left, center");
		
		JButton btnContribuinteLimpar = new JButton("Limpar");
		pInsertContribuinte.add(btnContribuinteLimpar, "2, 26, left, center");
		
		JPanel pUpdateContribuinte = new JPanel();
		tpContribuinte.addTab("Alterar", null, pUpdateContribuinte, null);
		pUpdateContribuinte.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("300px"),
				ColumnSpec.decode("25px"),
				ColumnSpec.decode("230px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel label = new JLabel("CADASTRO DE CONTRIBUINTE");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		pUpdateContribuinte.add(label, "2, 2, fill, center");
		
		JLabel label_1 = new JLabel("Nome");
		pUpdateContribuinte.add(label_1, "2, 4, left, center");
		
		textField = new JTextField();
		textField.setColumns(10);
		pUpdateContribuinte.add(textField, "2, 6, left, top");
		
		JLabel label_2 = new JLabel("Idade");
		pUpdateContribuinte.add(label_2, "2, 8, left, center");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		pUpdateContribuinte.add(textField_1, "2, 10, left, top");
		
		JLabel label_3 = new JLabel("Endereço");
		pUpdateContribuinte.add(label_3, "2, 12, left, center");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		pUpdateContribuinte.add(textField_3, "2, 14, left, center");
		
		JLabel label_4 = new JLabel("Conta Bancária");
		pUpdateContribuinte.add(label_4, "2, 16, left, center");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		pUpdateContribuinte.add(textField_2, "2, 18, left, center");
		
		JButton button = new JButton("Cadastrar");
		pUpdateContribuinte.add(button, "2, 20, left, top");
		
		JButton button_1 = new JButton("Limpar");
		pUpdateContribuinte.add(button_1, "2, 22, left, top");
		
		JTabbedPane tpReceita = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Receitas", null, tpReceita, null);
		
		JPanel pSelectReceita = new JPanel();
		tpReceita.addTab("Consultar", null, pSelectReceita, null);
		pSelectReceita.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("250px"),
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("200px"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("30px"),
				RowSpec.decode("40px"),
				RowSpec.decode("125px"),
				RowSpec.decode("30px"),
				RowSpec.decode("125px"),}));
		
		JLabel lblConsultarReceita = new JLabel("CONSULTAR RECEITA");
		lblConsultarReceita.setFont(new Font("Dialog", Font.BOLD, 14));
		pSelectReceita.add(lblConsultarReceita, "2, 2");
		
		JLabel lblContribuinte_1 = new JLabel("Contribuinte:");
		pSelectReceita.add(lblContribuinte_1, "2, 3, left, center");
		
		JLabel lblDados_1 = new JLabel("Dados:");
		pSelectReceita.add(lblDados_1, "4, 3");
		
		JList listReceitaContribuinte = new JList();
		pSelectReceita.add(listReceitaContribuinte, "2, 4, fill, fill");
		
		JLabel lblReceitaDados = new JLabel("");
		pSelectReceita.add(lblReceitaDados, "4, 4");
		
		JLabel lblReceitas = new JLabel("Receitas:");
		pSelectReceita.add(lblReceitas, "2, 5");
		
		JList listReceita = new JList();
		pSelectReceita.add(listReceita, "2, 6, fill, fill");
		
		JPanel pInsertReceita = new JPanel();
		tpReceita.addTab("Cadastrar", null, pInsertReceita, null);
		pInsertReceita.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("250px"),
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("200px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCadastroDeReceitas = new JLabel("CADASTRO DE RECEITAS");
		lblCadastroDeReceitas.setFont(new Font("Dialog", Font.BOLD, 14));
		pInsertReceita.add(lblCadastroDeReceitas, "2, 2, left, center");
		
		JLabel lblNum = new JLabel("Núm.  Protocolo");
		pInsertReceita.add(lblNum, "2, 6");
		
		txtReceitaNumProtocolo = new JTextField();
		pInsertReceita.add(txtReceitaNumProtocolo, "2, 8, left, center");
		txtReceitaNumProtocolo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CNPJ");
		pInsertReceita.add(lblNewLabel, "2, 10");
		
		txtReceitaCNPJ = new JTextField();
		pInsertReceita.add(txtReceitaCNPJ, "2, 12, left, center");
		txtReceitaCNPJ.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		pInsertReceita.add(lblValor, "2, 14");
		
		txtReceitaValor = new JTextField();
		pInsertReceita.add(txtReceitaValor, "2, 16, left, center");
		txtReceitaValor.setColumns(10);
		
		JButton btnReceitaCadastrar = new JButton("Cadastrar");
		pInsertReceita.add(btnReceitaCadastrar, "2, 18, left, center");
		
		JButton btnReceitaLimpar = new JButton("Limpar");
		pInsertReceita.add(btnReceitaLimpar, "2, 20, left, center");
		
		JPanel pDeleteReceita = new JPanel();
		tpReceita.addTab("Excluir", null, pDeleteReceita, null);
		pDeleteReceita.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("250px"),
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("200px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				RowSpec.decode("250px"),
				RowSpec.decode("30px"),}));
		
		JLabel lblExcluirReceitas = new JLabel("EXCLUIR RECEITAS");
		lblExcluirReceitas.setFont(new Font("Dialog", Font.BOLD, 14));
		pDeleteReceita.add(lblExcluirReceitas, "2, 2");
		
		JList listReceitaExcluir = new JList();
		pDeleteReceita.add(listReceitaExcluir, "2, 3, fill, fill");
		
		JButton btnReceitaExcluir = new JButton("Excluir");
		pDeleteReceita.add(btnReceitaExcluir, "2, 4, left, center");
		
		JTabbedPane tpDespesa = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Despesas", null, tpDespesa, null);
		
		JPanel pSelectDespesa = new JPanel();
		tpDespesa.addTab("Consulta", null, pSelectDespesa, null);
		pSelectDespesa.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("250px"),
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("200px"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("30px"),
				RowSpec.decode("40px"),
				RowSpec.decode("125px"),
				RowSpec.decode("30px"),
				RowSpec.decode("125px"),}));
		
		JLabel lblConsultaDespesa = new JLabel("CONSULTA DESPESA");
		lblConsultaDespesa.setFont(new Font("Dialog", Font.BOLD, 14));
		pSelectDespesa.add(lblConsultaDespesa, "2, 2");
		
		JLabel lblContribuinte_2 = new JLabel("Contribuinte");
		pSelectDespesa.add(lblContribuinte_2, "2, 3");
		
		JLabel lblDados = new JLabel("Dados:");
		pSelectDespesa.add(lblDados, "4, 3");
		
		JList listDespesaContribuinte = new JList();
		pSelectDespesa.add(listDespesaContribuinte, "2, 4, fill, fill");
		
		JLabel lblDespesaDados = new JLabel("");
		pSelectDespesa.add(lblDespesaDados, "4, 4");
		
		JLabel lblDespesas = new JLabel("Despesas");
		pSelectDespesa.add(lblDespesas, "2, 5");
		
		JList listDespesa = new JList();
		pSelectDespesa.add(listDespesa, "2, 6, fill, fill");
		
		JPanel pInsertDespesa = new JPanel();
		tpDespesa.addTab("Cadastro", null, pInsertDespesa, null);
		pInsertDespesa.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCadastroDeDespesas = new JLabel("CADASTRO DE DESPESAS");
		lblCadastroDeDespesas.setFont(new Font("Dialog", Font.BOLD, 14));
		pInsertDespesa.add(lblCadastroDeDespesas, "4, 2");
		
		JLabel label_5 = new JLabel("Núm.  Protocolo");
		pInsertDespesa.add(label_5, "4, 6");
		
		txtDespesaNumProtocolo = new JTextField();
		txtDespesaNumProtocolo.setColumns(10);
		pInsertDespesa.add(txtDespesaNumProtocolo, "4, 8, left, center");
		
		JLabel label_6 = new JLabel("CNPJ");
		pInsertDespesa.add(label_6, "4, 10");
		
		txtDespesaCNPJ = new JTextField();
		txtDespesaCNPJ.setColumns(10);
		pInsertDespesa.add(txtDespesaCNPJ, "4, 12, left, center");
		
		JLabel lblValor_1 = new JLabel("Valor");
		pInsertDespesa.add(lblValor_1, "4, 14");
		
		txtDespesaValor = new JTextField();
		txtDespesaValor.setColumns(10);
		pInsertDespesa.add(txtDespesaValor, "4, 16, left, center");
		
		JButton btnDespesaCadastrar = new JButton("Cadastrar");
		pInsertDespesa.add(btnDespesaCadastrar, "4, 18, left, center");
		
		JButton btnBtnDespesaLimpar = new JButton("Limpar");
		pInsertDespesa.add(btnBtnDespesaLimpar, "4, 20, left, center");
		
		JPanel pDeleteDespesa = new JPanel();
		tpDespesa.addTab("Excluir", null, pDeleteDespesa, null);
		pDeleteDespesa.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("250px"),
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("200px:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				RowSpec.decode("250px"),
				RowSpec.decode("30px:grow"),}));
		
		JLabel label_7 = new JLabel("EXCLUIR RECEITAS");
		label_7.setFont(new Font("Dialog", Font.BOLD, 14));
		pDeleteDespesa.add(label_7, "2, 2");
		
		JList listDespesaExcluir = new JList();
		pDeleteDespesa.add(listDespesaExcluir, "2, 3, fill, fill");
		
		JButton btnDespesaExcluir = new JButton("Excluir");
		pDeleteDespesa.add(btnDespesaExcluir, "2, 4, left, center");
		
		JTabbedPane tpPJ = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Pessoa Jurídica", null, tpPJ, null);
		
		JPanel panel_12 = new JPanel();
		tpPJ.addTab("New tab", null, panel_12, null);
		
		JPanel panel_13 = new JPanel();
		tpPJ.addTab("New tab", null, panel_13, null);
		
		JPanel panel_14 = new JPanel();
		tpPJ.addTab("New tab", null, panel_14, null);
		
		JPanel panel_15 = new JPanel();
		tpPJ.addTab("New tab", null, panel_15, null);
		
		frmReceitaFederal.setVisible(true);
	}
}
