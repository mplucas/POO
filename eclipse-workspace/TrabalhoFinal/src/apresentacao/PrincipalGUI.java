package apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;

public class PrincipalGUI {

	private JFrame frmReceitaFederal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI window = new PrincipalGUI();
					window.frmReceitaFederal.setVisible(true);
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
		frmReceitaFederal.setBounds(100, 100, 650, 530);
		frmReceitaFederal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmReceitaFederal.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JTabbedPane tpContribuinte = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Contribuinte", null, tpContribuinte, null);
		
		JPanel pSelectContribuinte = new JPanel();
		tpContribuinte.addTab("Consultar", null, pSelectContribuinte, null);
		
		JPanel pInsertContribuinte = new JPanel();
		tpContribuinte.addTab("Cadastrar", null, pInsertContribuinte, null);
		pInsertContribuinte.setLayout(null);
		
		JLabel lblCadastroDeContribuinte = new JLabel("CADASTRO DE CONTRIBUINTE");
		lblCadastroDeContribuinte.setBounds(217, 12, 229, 17);
		lblCadastroDeContribuinte.setFont(new Font("Dialog", Font.BOLD, 14));
		pInsertContribuinte.add(lblCadastroDeContribuinte);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(40, 50, 70, 15);
		pInsertContribuinte.add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(40, 75, 70, 15);
		pInsertContribuinte.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(40, 102, 70, 15);
		pInsertContribuinte.add(lblIdade);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setBounds(40, 129, 70, 15);
		pInsertContribuinte.add(lblEndereo);
		
		JLabel lblNumFuncionrios = new JLabel("Num. Funcionários");
		lblNumFuncionrios.setBounds(40, 156, 151, 15);
		pInsertContribuinte.add(lblNumFuncionrios);
		
		JPanel pUpdateContribuinte = new JPanel();
		tpContribuinte.addTab("Alterar", null, pUpdateContribuinte, null);
		
		JTabbedPane tpReceita = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Receitas", null, tpReceita, null);
		
		JPanel panel_4 = new JPanel();
		tpReceita.addTab("New tab", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tpReceita.addTab("New tab", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tpReceita.addTab("New tab", null, panel_6, null);
		
		JPanel panel_7 = new JPanel();
		tpReceita.addTab("New tab", null, panel_7, null);
		
		JTabbedPane tpDespesa = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Despesas", null, tpDespesa, null);
		
		JPanel panel_8 = new JPanel();
		tpDespesa.addTab("New tab", null, panel_8, null);
		
		JPanel panel_9 = new JPanel();
		tpDespesa.addTab("New tab", null, panel_9, null);
		
		JPanel panel_10 = new JPanel();
		tpDespesa.addTab("New tab", null, panel_10, null);
		
		JPanel panel_11 = new JPanel();
		tpDespesa.addTab("New tab", null, panel_11, null);
		
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
	}
}
