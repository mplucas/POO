package apresentacao;

import java.util.Scanner;

import dados.*;
import persistencia.*;

public class Principal {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String aux;
		
		// INSERTS
		Cidade cidade = new Cidade();
		CidadeDAO cidadeDAO = CidadeDAO.getInstance();
		cidade.setNome("Joinville");
		cidade.setEstado("SC");
		cidadeDAO.insert(cidade);
		Cidade novaCidade = cidadeDAO.select(1);
		
		Aeroporto aeroporto = new Aeroporto();
		AeroportoDAO aeroportoDAO = AeroportoDAO.getInstance();
		aeroporto.setCodigo("1111");
		aeroporto.setNome("aero");
		aeroporto.setCidade(novaCidade);
		aeroportoDAO.insert(aeroporto);
		Aeroporto novoAeroporto = aeroportoDAO.select(1);
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = ClienteDAO.getInstance();
		cliente.setNome("Takeo");
		cliente.setCpf(999999);
		clienteDAO.insert(cliente);
		Cliente novoCliente = clienteDAO.select(1);
		
		Trecho trecho = new Trecho();
		TrechoDAO trechoDAO = TrechoDAO.getInstance();
		trecho.setNumTrecho(8888);
		trecho.setDuracao(5);
		trecho.setOrigem(novoAeroporto);
		trechoDAO.insert(trecho);
		Trecho novoTrecho = trechoDAO.select(1);
		
		Reserva reserva = new Reserva();
		ReservaDAO reservaDAO = ReservaDAO.getInstance();
		reserva.setNumReserva(6666);
		reserva.setPreco(105.5);
		reserva.setCliente(novoCliente);
		reservaDAO.insert(reserva);
		Reserva novaReserva = reservaDAO.select(1);
				
		System.out.println("Verifique no banco os inserts realizados, escreva qualquer coisa para seguir com os updates.");
		aux = in.nextLine();
		
		// UPDATES
		novaCidade.setNome("Florianópolis");
		cidadeDAO.update(novaCidade.getId(), novaCidade);
		
		novoAeroporto.setNome("teste");
		aeroportoDAO.update(novoAeroporto.getId(), novoAeroporto);
		
		novoCliente.setNome("Lucas");
		clienteDAO.update(novoCliente.getId(), novoCliente);
		
		novoTrecho.setDuracao(10);
		trechoDAO.update(novoTrecho.getId(), novoTrecho);
		
		novaReserva.setNumReserva(999999);
		reservaDAO.update(novaReserva.getId(), novaReserva);
		
		System.out.println("Verifique no banco os updates realizados, escreva qualquer coisa para seguir com os deletes.");
		aux = in.nextLine();
		
		// DELETES
		
		reservaDAO.delete(novaReserva.getId());
		
		trechoDAO.delete(novoTrecho.getId());
		
		clienteDAO.delete(novoCliente.getId());
		
		aeroportoDAO.delete(novoAeroporto.getId());
		
		cidadeDAO.delete(novaCidade.getId());
		
		System.out.println("Para rodar o programa novamente resete os auto increment do banco de dados utilizando:"
				+ " ALTER SEQUENCE *nome da tabela*_id_seq RESTART WITH 1");
		
	}
	
}
