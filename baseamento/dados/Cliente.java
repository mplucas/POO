package dados;

import java.util.ArrayList;

public class Cliente {

	private int id;
	private int cpf;
	private String nome;
	private String endereco;
	private int telefone;
	private ArrayList<Reserva> reservas;
	
	public Cliente() {
		this.reservas = new ArrayList<Reserva>();
	}
	
	public int getId() {
		return id;
	}

	public int getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
	public void reservarIda( Reserva reserva ) {
		this.reservas.add(reserva);
	}
	
	public void reservarVolta( Reserva ida, Reserva volta ) {
		ida.setVolta(volta);
		this.reservarIda(ida);
	}
	
	public void reservarTrecho( Reserva reserva, Trecho trecho ) {
		reserva.reservarTrecho(trecho);
	}
	
	public void reservarPoltrona( Reserva reserva, Trecho trecho, int poltrona ) {
		reserva.reservarPoltrona(trecho, poltrona);
	}
	
}
