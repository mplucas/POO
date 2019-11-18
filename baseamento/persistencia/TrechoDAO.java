package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;

import dados.Aeroporto;
import dados.Trecho;

import java.sql.Connection;

public class TrechoDAO {

	private static TrechoDAO instance = null;
	private PreparedStatement sqlInsert;
	private PreparedStatement sqlDelete;
	private PreparedStatement sqlSelect;
	private PreparedStatement sqlUpdate;
	
	private TrechoDAO(){
		Connection conex = Conexao.getConexao();
		
		try {
		
			String strInsert = "INSERT INTO trecho (num_trecho, duracao, id_aero_origem) "
					+ " VALUES(?,?,?)";
			sqlInsert = conex.prepareStatement(strInsert);
			String strDelete = "DELETE FROM trecho "
					+ "WHERE id = ?";
			sqlDelete = conex.prepareStatement(strDelete);
			String strSelect = "SELECT * FROM trecho "
					+ "WHERE id = ?";
			sqlSelect = conex.prepareStatement(strSelect);
			String strUpdate = "UPDATE trecho "
					+ "SET num_trecho = ?, duracao = ? "
					+ "WHERE id = ?";
			sqlUpdate = conex.prepareStatement(strUpdate);
		
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
	}
		
	public static TrechoDAO getInstance() {
		if(instance == null) {
			instance = new TrechoDAO();
		}
		
		return instance;
	}
		
	public void insert(Trecho trecho) {
	
		try {
		
			sqlInsert.setInt(1, trecho.getNumTrecho());
			sqlInsert.setInt(2, trecho.getDuracao());
			sqlInsert.setInt(3, trecho.getOrigem().getId());
			sqlInsert.executeUpdate();
		
		}catch(SQLException e){
		
			e.printStackTrace();
		
		}
	
	}
	
	public Trecho select(int id) {
	
		Trecho trecho = null;
		
		try {
		
			sqlSelect.setInt(1, id);
			ResultSet rs = sqlSelect.executeQuery();
			
			if(rs.next()) {
			
				trecho = new Trecho();
				trecho.setId(rs.getInt("id"));
				trecho.setDuracao(rs.getInt("duracao"));
				AeroportoDAO aeroportoDAO = AeroportoDAO.getInstance();
				trecho.setOrigem( aeroportoDAO.select( rs.getInt("id_aero_origem") ) );
			
			}
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return trecho;
	
	}
	
	public void delete( int id ) {
		
		try {
			sqlDelete.setInt(1, id);
			sqlDelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update( int id, Trecho trecho ) {
		
		try {
			sqlUpdate.setInt(1, trecho.getNumTrecho() );
			sqlUpdate.setInt(2, trecho.getDuracao() );
			sqlUpdate.setInt(3, id);
			sqlUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}