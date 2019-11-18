package dados;

public class Aeroporto {

	private int id;
	private String codigo;
	private String nome;
	private Cidade cidade;
	
	public Aeroporto() {
		// TODO Auto-generated constructor stub
	}
	
	public Aeroporto( Cidade cidade ) {
		this.cidade = cidade;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
}
