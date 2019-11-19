package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Dependente;

public class DependenteDAO {

	private static DependenteDAO instance = null;
	private PreparedStatement sqlInsert;
	private PreparedStatement sqlDelete;
	private PreparedStatement sqlSelect;
	private PreparedStatement sqlUpdate;
	
	private DependenteDAO(){
		Connection conex = Conexao.getConexao();
		
		try {
		
			String strInsert = "INSERT INTO dependente (cpf, nome, idade, endereco, id_contribuinte) "
					+ " VALUES(?,?,?,?,?)";
			sqlInsert = conex.prepareStatement(strInsert);
			
			String strDelete = "DELETE FROM dependente "
					+ "WHERE id = ?";
			sqlDelete = conex.prepareStatement(strDelete);
			
			String strSelect = "SELECT * FROM dependente "
					+ "WHERE id_contribuinte = ?";
			sqlSelect = conex.prepareStatement(strSelect);
			
			String strUpdate = "UPDATE dependente "
					+ "SET nome = ?, idade = ?, endereco = ?, id_contribuinte = ?"
					+ "WHERE id = ?";
			sqlUpdate = conex.prepareStatement(strUpdate);
		
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
	}
		
	public static DependenteDAO getInstance() {
		if(instance == null) {
			instance = new DependenteDAO();
		}
		
		return instance;
	}
		
	public void insert(Dependente dependente) {
	
		try {
		
			sqlInsert.setString(1, dependente.getCpf());
			sqlInsert.setString(2, dependente.getNome());
			sqlInsert.setInt(3, dependente.getIdade());
			sqlInsert.setString(4, dependente.getEndereco());
			sqlInsert.setInt(5, dependente.getId_contribuinte());
			sqlInsert.executeUpdate();
		
		}catch(SQLException e){
		
			e.printStackTrace();
		
		}
	
	}
	
	public ArrayList<Dependente> select(int id) {
	
		ArrayList<Dependente> dependentes = new ArrayList<Dependente>();
		Dependente dependente = null;
		
		try {
		
			sqlSelect.setInt(1, id);
			ResultSet rs = sqlSelect.executeQuery();
			
			if(rs.next()) {
			
				dependente = new Dependente();
				dependente.setId(rs.getInt("id"));
				dependente.setCpf(rs.getString("cpf"));
				dependente.setNome(rs.getString("nome"));
				dependente.setIdade(rs.getInt("idade"));
				dependente.setEndereco(rs.getString("endereco"));
				dependente.setId_contribuinte(rs.getInt("id_contribuinte"));
				dependentes.add(dependente);
			
			}
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return dependentes;
	
	}
	
	public void delete( int id ) {
		
		try {
			sqlDelete.setInt(1, id);
			sqlDelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update( int id, Dependente dependente ) {
		
		try {
			sqlUpdate.setString(1, dependente.getCpf() );
			sqlUpdate.setString(2, dependente.getNome() );
			sqlUpdate.setInt(3, id);
			sqlUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
