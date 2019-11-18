package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;
import dados.Aeroporto;

import java.sql.Connection;

public class AeroportoDAO {

	private static AeroportoDAO instance = null;
	private PreparedStatement sqlInsert;
	private PreparedStatement sqlDelete;
	private PreparedStatement sqlSelect;
	private PreparedStatement sqlUpdate;
	
	private AeroportoDAO(){
		Connection conex = Conexao.getConexao();
		
		try {
		
			String strInsert = "INSERT INTO aeroporto (codigo, nome, id_cidade) "
					+ " VALUES(?,?,?)";
			sqlInsert = conex.prepareStatement(strInsert);
			String strDelete = "DELETE FROM aeroporto "
					+ "WHERE id = ?";
			sqlDelete = conex.prepareStatement(strDelete);
			String strSelect = "SELECT * FROM aeroporto "
					+ "WHERE id = ?";
			sqlSelect = conex.prepareStatement(strSelect);
			String strUpdate = "UPDATE aeroporto "
					+ "SET codigo = ?, nome = ? "
					+ "WHERE id = ?";
			sqlUpdate = conex.prepareStatement(strUpdate);
		
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
	}
		
	public static AeroportoDAO getInstance() {
		if(instance == null) {
			instance = new AeroportoDAO();
		}
		
		return instance;
	}
		
	public void insert(Aeroporto aeroporto) {
	
		try {
		
			sqlInsert.setString(1, aeroporto.getCodigo());
			sqlInsert.setString(2, aeroporto.getNome());
			sqlInsert.setInt(3, aeroporto.getCidade().getId());
			sqlInsert.executeUpdate();
		
		}catch(SQLException e){
		
			e.printStackTrace();
		
		}
	
	}
	
	public Aeroporto select(int id) {
	
		Aeroporto aeroporto = null;
		
		try {
		
			sqlSelect.setInt(1, id);
			ResultSet rs = sqlSelect.executeQuery();
			
			if(rs.next()) {
			
				aeroporto = new Aeroporto();
				aeroporto.setId(rs.getInt("id"));
				aeroporto.setNome(rs.getString("nome"));
				aeroporto.setCodigo(rs.getString("codigo"));
				CidadeDAO cidadeDAO = CidadeDAO.getInstance();
				aeroporto.setCidade(cidadeDAO.select(rs.getInt("id_cidade")));
			
			
			}
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return aeroporto;
	
	}
	
	public void delete( int id ) {
		
		try {
			sqlDelete.setInt(1, id);
			sqlDelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update( int id, Aeroporto aeroporto ) {
		
		try {
			sqlUpdate.setString(1, aeroporto.getCodigo() );
			sqlUpdate.setString(2, aeroporto.getNome() );
			sqlUpdate.setInt(3, id);
			sqlUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}