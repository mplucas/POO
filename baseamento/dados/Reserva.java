package dados;

import java.util.ArrayList;

public class Reserva {

	private int id;
	private int numReserva;
	private String dataVoo;
	private String horaVoo;
	private double preco;
	private String classeVoo;
	private boolean idaEvolta;
	private ArrayList<Trecho> trechos;
	private Reserva volta;
	private Aeroporto origem;
	private Aeroporto destino;
	private Cliente cliente;
	
	public Reserva() {
		this.trechos = new ArrayList<Trecho>();
		this.idaEvolta = false;
	}
	
	public int getId() {
		return id;
	}
	
	public String getClasseVoo() {
		return classeVoo;
	}
	
	public int getNumReserva() {
		return numReserva;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}
	
	public void setDataVoo(String dataVoo) {
		this.dataVoo = dataVoo;
	}
	
	public void setHoraVoo(String horaVoo) {
		this.horaVoo = horaVoo;
	}
	
	public void setPreco(double d) {
		this.preco = d;
	}
	
	public void setClasseVoo(String classeVoo) {
		this.classeVoo = classeVoo;
	}
	
	public void setVolta(Reserva volta) {
		this.idaEvolta = true;
		this.volta = volta;
	}
	
	public void reservarTrecho(Trecho trecho) {
		
		this.trechos.add(trecho);
		
		int tam = this.trechos.size();
		
		if( tam > 1 ) {
			this.trechos.get( tam - 2).setProximoTrecho( this.trechos.get( tam - 1 ) );
			this.destino = trecho.getDestino();
		}else {
			this.dataVoo = this.trechos.get(tam - 1).getDataPartida();
			this.horaVoo = this.trechos.get(tam - 1).getHoraPartida();
			this.origem = trecho.getOrigem();
			this.destino = trecho.getDestino();
		}
		
	}
	
	public void reservarPoltrona(Trecho trecho, int poltrona) {
		trecho.reservarPoltrona(poltrona);
		this.trechos.add(trecho);
	}
	
	public String toString() {
		
	    String s = "Nº: " + this.numReserva + "\nData:" + this.dataVoo + "\nHora:" + this.horaVoo + "\nPreco:" + this.preco + "\nClasse:" + this.classeVoo;
	
	    if( this.idaEvolta ) {
	    	s += "\n\nReserva de volta:\n" + this.volta.toString();
	    }
	    
	    return s;
	}
	
}
