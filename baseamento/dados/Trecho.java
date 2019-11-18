package dados;

import java.util.Date;

public class Trecho {

	private int id;
	private int numTrecho;
	private int duracao;
	private String dataPartida;
	private String dataChegada;
	private String horaPartida;
	private String horaChegada;
	private String classeVoo;
	private int numPoltrona;
	private Aeroporto origem;
	private Aeroporto destino;
	private Trecho proximoTrecho;
	
	public int getId() {
		return id;
	}
	
	public String getDataPartida() {
		return dataPartida;
	}
	
	public String getHoraPartida() {
		return horaPartida;
	}
	
	public Aeroporto getOrigem() {
		return origem;
	}
	
	public Aeroporto getDestino() {
		return destino;
	}
	
	public int getNumTrecho() {
		return numTrecho;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNumTrecho(int numTrecho) {
		this.numTrecho = numTrecho;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public void setDataPartida(String dataPartida) {
		this.dataPartida = dataPartida;
	}
	
	public void setDataChegada(String dataChegada) {
		this.dataChegada = dataChegada;
	}
	
	public void setHoraPartida(String horaPartida) {
		this.horaPartida = horaPartida;
	}
	
	public void setHoraChegada(String horaChegada) {
		this.horaChegada = horaChegada;
	}
	
	public void setClasseVoo(String classeVoo) {
		this.classeVoo = classeVoo;
	}
	
	public void setOrigem(Aeroporto origem) {
		this.origem = origem;
	}
	
	public void setDestino(Aeroporto destino) {
		this.destino = destino;
	}
	
	public void setProximoTrecho(Trecho proximoTrecho) {
		this.proximoTrecho = proximoTrecho;
	}
	
	public void reservarPoltrona(int numPoltrona) {
		this.numPoltrona = numPoltrona;
	}
	
}
