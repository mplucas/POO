package apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import dados.Bem;
import dados.Contribuinte;
import negocio.GerenciarReceita;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.postgresql.util.PSQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BensGUI {

	private JFrame frame;
	private JTextField txtBemInsertNome;
	private JTextField txtBemInsertTipo;
	private JTextField txtBemInsertValor;
	private static int id_contribuinte;
	private GerenciarReceita gerenciarReceita = new GerenciarReceita();

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//System.out.println(id_contribuinte);
					BensGUI window = new BensGUI(id_contribuinte);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BensGUI( int id_contribuinte ) {
		this.id_contribuinte = id_contribuinte;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pBemInsert = new JPanel();
		tabbedPane.addTab("Cadastrar", null, pBemInsert, null);
		pBemInsert.setLayout(new FormLayout(new ColumnSpec[] {
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
		
		JLabel lblCadastroDeBem = new JLabel("CADASTRO DE BEM");
		lblCadastroDeBem.setFont(new Font("Dialog", Font.BOLD, 14));
		pBemInsert.add(lblCadastroDeBem, "4, 4");
		
		JLabel lblNome = new JLabel("Nome:");
		pBemInsert.add(lblNome, "4, 6");
		
		txtBemInsertNome = new JTextField();
		pBemInsert.add(txtBemInsertNome, "4, 8, left, center");
		txtBemInsertNome.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		pBemInsert.add(lblTipo, "4, 10");
		
		txtBemInsertTipo = new JTextField();
		pBemInsert.add(txtBemInsertTipo, "4, 12, left, center");
		txtBemInsertTipo.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		pBemInsert.add(lblValor, "4, 14");
		
		txtBemInsertValor = new JTextField();
		pBemInsert.add(txtBemInsertValor, "4, 16, left, center");
		txtBemInsertValor.setColumns(10);
		
		JButton btBemInsert = new JButton("Cadastrar");
		btBemInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bem novoBem = new Bem();
				novoBem.setNome(txtBemInsertNome.getText());
				novoBem.setTipo(txtBemInsertTipo.getText());
				novoBem.setValor(Float.parseFloat(txtBemInsertValor.getText()));
				novoBem.setId_contribuinte(id_contribuinte);
				try {
					gerenciarReceita.insertBem(novoBem);
				}catch(SQLException e1){
					
					e1.printStackTrace();
				
				}finally {
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
				}	
			}
		});
		pBemInsert.add(btBemInsert, "4, 18, left, center");
		
		JButton btBemCadastrarLimpar = new JButton("Limpar");
		btBemCadastrarLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtBemInsertNome.setText("");
				txtBemInsertTipo.setText("");
				txtBemInsertValor.setText("");
			}
		});
		pBemInsert.add(btBemCadastrarLimpar, "4, 20, left, center");
		
		JPanel pBemSelect = new JPanel();
		tabbedPane.addTab("Consultar", null, pBemSelect, null);
		pBemSelect.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("250px"),
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("200px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				RowSpec.decode("250px:grow"),
				RowSpec.decode("30px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblCadastro = new JLabel("CONSULTA DE BEM");
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 14));
		pBemSelect.add(lblCadastro, "2, 2");
		
		JLabel lblDados = new JLabel("Dados:");
		pBemSelect.add(lblDados, "4, 2");
		
		DefaultListModel mSelectBem = new DefaultListModel();
		ArrayList<Bem> aBem = new ArrayList<Bem>();
		
		JList listBemSelect = new JList(mSelectBem);
		pBemSelect.add(listBemSelect, "2, 3, fill, fill");
		
		JTextArea txtBemSelect = new JTextArea();
		pBemSelect.add(txtBemSelect, "4, 3, fill, fill");
		
		JPanel pBemDelete = new JPanel();
		tabbedPane.addTab("Excluir", null, pBemDelete, null);
		pBemDelete.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("250px"),
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("200px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				RowSpec.decode("250px"),
				RowSpec.decode("30px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblExclusoDeBens = new JLabel("EXCLUSÃO DE BEM");
		pBemDelete.add(lblExclusoDeBens, "2, 2");
		
		JList listBem = new JList(mSelectBem);
		pBemDelete.add(listBem, "2, 3, fill, fill");
		
		JButton btnBemDelete = new JButton("Excluir");
		btnBemDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int iSelectionado = listBem.getSelectedIndex();
            	if(iSelectionado >= 0 && iSelectionado < aBem.size()) {
            		gerenciarReceita.deleteBem(aBem.get(iSelectionado).getId());
            		tabbedPane.setSelectedIndex(1);
            		tabbedPane.setSelectedIndex(2);
            		JOptionPane.showMessageDialog(null, "Excluido com sucesso.");
            	}
			}
		});
		pBemDelete.add(btnBemDelete, "2, 6, left, center");
		
		//refresh de listas
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	            if(tabbedPane.getSelectedIndex() == 1 || tabbedPane.getSelectedIndex() == 2) {
	            	mSelectBem.clear();
	            	aBem.clear();
	            	aBem.addAll(gerenciarReceita.selectBem(id_contribuinte));
	            	for(Bem val : aBem)
	                    mSelectBem.addElement(val);
	            	txtBemSelect.setText("");
	            }
	        }
	    });
		listBemSelect.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	int iSelectionado = listBemSelect.getSelectedIndex();
                	if(iSelectionado >= 0 && iSelectionado < aBem.size()) {
                		Bem aux = aBem.get(iSelectionado);
                		String sAux = "Nome: " + aux.getNome() + "\nTipo: " + aux.getTipo();
                		sAux += "\nValor: " + aux.getValor();
                		txtBemSelect.setText(sAux);
                	}
                }
            }
        });
		
	}

}
