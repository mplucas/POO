package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;
import dados.Cliente;

import java.sql.Connection;

public class ClienteDAO {

	private static ClienteDAO instance = null;
	private PreparedStatement sqlInsert;
	private PreparedStatement sqlDelete;
	private PreparedStatement sqlSelect;
	private PreparedStatement sqlUpdate;
	
	private ClienteDAO(){
		Connection conex = Conexao.getConexao();
		
		try {
		
			String strInsert = "INSERT INTO cliente (cpf, nome) "
					+ " VALUES(?,?)";
			sqlInsert = conex.prepareStatement(strInsert);
			String strDelete = "DELETE FROM cliente "
					+ "WHERE id = ?";
			sqlDelete = conex.prepareStatement(strDelete);
			String strSelect = "SELECT * FROM cliente "
					+ "WHERE id = ?";
			sqlSelect = conex.prepareStatement(strSelect);
			String strUpdate = "UPDATE cliente "
					+ "SET cpf = ?, nome = ? "
					+ "WHERE id = ?";
			sqlUpdate = conex.prepareStatement(strUpdate);
		
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
	}
		
	public static ClienteDAO getInstance() {
		if(instance == null) {
			instance = new ClienteDAO();
		}
		
		return instance;
	}
		
	public void insert(Cliente cliente) {
	
		try {
		
			sqlInsert.setString(1, String.valueOf(cliente.getCpf()));
			sqlInsert.setString(2, cliente.getNome());
			sqlInsert.executeUpdate();
		
		}catch(SQLException e){
		
			e.printStackTrace();
		
		}
	
	}
	
	public Cliente select(int id) {
	
		Cliente cliente = null;
		
		try {
		
			sqlSelect.setInt(1, id);
			ResultSet rs = sqlSelect.executeQuery();
			
			if(rs.next()) {
			
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf( rs.getInt("cpf")  );
			
			}
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return cliente;
	
	}
	
	public void delete( int id ) {
		
		try {
			sqlDelete.setInt(1, id);
			sqlDelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update( int id, Cliente cliente ) {
		
		try {
			sqlUpdate.setString(1, String.valueOf(cliente.getCpf()) );
			sqlUpdate.setString(2, cliente.getNome() );
			sqlUpdate.setInt(3, id);
			sqlUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}