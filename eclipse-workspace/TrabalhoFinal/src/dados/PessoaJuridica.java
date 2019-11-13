package dados;

import java.util.ArrayList;

public class PessoaJuridica {

	private int id;
	private String cnpj;
	private String nomePJ;
	private String endereco;
	private int numFuncionarios;
	private ArrayList<NotaFiscal> notasFiscais;
	private ArrayList<ContraCheque> contraCheques;
	
	public PessoaJuridica() {
		notasFiscais = new ArrayList<NotaFiscal>();
		contraCheques = new ArrayList<ContraCheque>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomePJ() {
		return nomePJ;
	}

	public void setNomePJ(String nomePJ) {
		this.nomePJ = nomePJ;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(int numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	public ArrayList<NotaFiscal> getNotasFiscais() {
		return notasFiscais;
	}

	public void setNotasFiscais(ArrayList<NotaFiscal> notasFiscais) {
		this.notasFiscais = notasFiscais;
	}

	public ArrayList<ContraCheque> getContraCheques() {
		return contraCheques;
	}

	public void setContraCheques(ArrayList<ContraCheque> contraCheques) {
		this.contraCheques = contraCheques;
	}
	
}
