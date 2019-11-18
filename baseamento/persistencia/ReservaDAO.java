package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;

import dados.Aeroporto;
import dados.Reserva;

import java.sql.Connection;

public class ReservaDAO {

	private static ReservaDAO instance = null;
	private PreparedStatement sqlInsert;
	private PreparedStatement sqlDelete;
	private PreparedStatement sqlSelect;
	private PreparedStatement sqlUpdate;
	
	private ReservaDAO(){
		Connection conex = Conexao.getConexao();
		
		try {
		
			String strInsert = "INSERT INTO reserva (numreserva, preco, id_cliente) "
					+ " VALUES(?,?,?)";
			sqlInsert = conex.prepareStatement(strInsert);
			String strDelete = "DELETE FROM reserva "
					+ "WHERE id = ?";
			sqlDelete = conex.prepareStatement(strDelete);
			String strSelect = "SELECT * FROM reserva "
					+ "WHERE id = ?";
			sqlSelect = conex.prepareStatement(strSelect);
			String strUpdate = "UPDATE reserva "
					+ "SET numreserva = ?, preco = ? "
					+ "WHERE id = ?";
			sqlUpdate = conex.prepareStatement(strUpdate);
		
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
	}
		
	public static ReservaDAO getInstance() {
		if(instance == null) {
			instance = new ReservaDAO();
		}
		
		return instance;
	}
		
	public void insert(Reserva reserva) {
	
		try {
		
			sqlInsert.setInt(1, reserva.getNumReserva());
			sqlInsert.setDouble(2, reserva.getPreco());
			sqlInsert.setInt(3, reserva.getCliente().getId());
			sqlInsert.executeUpdate();
		
		}catch(SQLException e){
		
			e.printStackTrace();
		
		}
	
	}
	
	public Reserva select(int id) {
	
		Reserva reserva = null;
		
		try {
		
			sqlSelect.setInt(1, id);
			ResultSet rs = sqlSelect.executeQuery();
			
			if(rs.next()) {
			
				reserva = new Reserva();
				reserva.setId(rs.getInt("id"));
				reserva.setNumReserva(rs.getInt("numreserva"));
				ClienteDAO clienteDAO = ClienteDAO.getInstance();
				reserva.setCliente( clienteDAO.select( rs.getInt("id_cliente") ) );
			
			}
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return reserva;
	
	}
	
	public void delete( int id ) {
		
		try {
			sqlDelete.setInt(1, id);
			sqlDelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update( int id, Reserva reserva ) {
		
		try {
			sqlUpdate.setInt(1, reserva.getNumReserva() );
			sqlUpdate.setDouble(2, reserva.getPreco() );
			sqlUpdate.setInt(3, id);
			sqlUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}