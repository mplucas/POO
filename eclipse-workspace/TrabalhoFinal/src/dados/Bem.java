package dados;

public class Bem {

	private int id;	
	private String nome;
	private String tipo;
	private float valor;
	private int id_contribuinte;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getId_contribuinte() {
		return id_contribuinte;
	}

	public void setId_contribuinte(int id_contribuinte) {
		this.id_contribuinte = id_contribuinte;
	}
	
	@Override
	public String toString() {
		String aux = nome + " - " + tipo;
		return aux;
	}
	
}
