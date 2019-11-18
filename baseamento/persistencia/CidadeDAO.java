package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;
import dados.Cidade;

import java.sql.Connection;

public class CidadeDAO {

	private static CidadeDAO instance = null;
	private PreparedStatement sqlInsert;
	private PreparedStatement sqlDelete;
	private PreparedStatement sqlSelect;
	private PreparedStatement sqlUpdate;
	
	private CidadeDAO(){
		Connection conex = Conexao.getConexao();
		
		try {
		
			String strInsert = "INSERT INTO cidade (nome, estado) "
					+ " VALUES(?,?)";
			sqlInsert = conex.prepareStatement(strInsert);
			String strDelete = "DELETE FROM cidade "
					+ "WHERE id = ?";
			sqlDelete = conex.prepareStatement(strDelete);
			String strSelect = "SELECT * FROM cidade "
					+ "WHERE id = ?";
			sqlSelect = conex.prepareStatement(strSelect);
			String strUpdate = "UPDATE cidade "
					+ "SET nome = ?, estado = ? "
					+ "WHERE id = ?";
			sqlUpdate = conex.prepareStatement(strUpdate);
		
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
	}
		
	public static CidadeDAO getInstance() {
		if(instance == null) {
			instance = new CidadeDAO();
		}
		
		return instance;
	}
		
	public void insert(Cidade cidade) {
	
		try {
		
			sqlInsert.setString(1, cidade.getNome());
			sqlInsert.setString(2, cidade.getEstado());
			sqlInsert.executeUpdate();
		
		}catch(SQLException e){
		
			e.printStackTrace();
		
		}
	
	}
	
	public Cidade select(int id) {
	
		Cidade cidade = null;
		
		try {
		
			sqlSelect.setInt(1, id);
			ResultSet rs = sqlSelect.executeQuery();
			
			if(rs.next()) {
			
				cidade = new Cidade();
				cidade.setId(rs.getInt("id"));
				cidade.setNome(rs.getString("nome"));
				cidade.setEstado(rs.getString("estado"));
			
			
			}
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return cidade;
	
	}
	
	public void delete( int id ) {
		
		try {
			sqlDelete.setInt(1, id);
			sqlDelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update( int id, Cidade cidade ) {
		
		try {
			sqlUpdate.setString(1, cidade.getNome() );
			sqlUpdate.setString(2, cidade.getEstado() );
			sqlUpdate.setInt(3, id);
			sqlUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}