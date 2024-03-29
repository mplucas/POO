package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Contribuinte;

public class ContribuinteDAO {

	private static ContribuinteDAO instance = null;
	private PreparedStatement sqlInsert;
	private PreparedStatement sqlSelect;
	private PreparedStatement sqlSelectAll;
	private PreparedStatement sqlUpdate;
	
	private ContribuinteDAO(){
		Connection conex = Conexao.getConexao();
		
		try {
		
			String strInsert = "INSERT INTO contribuinte (cpf, nome, idade, endereco, contabancaria) "
					+ " VALUES(?,?,?,?,?)";
			sqlInsert = conex.prepareStatement(strInsert);
			
			String strSelect = "SELECT * FROM contribuinte "
					+ "WHERE id = ?";
			sqlSelect = conex.prepareStatement(strSelect);
			
			String strSelectAll = "SELECT * FROM contribuinte";
			sqlSelectAll = conex.prepareStatement(strSelectAll);
			
			String strUpdate = "UPDATE contribuinte "
					+ "SET nome = ?, idade = ?, endereco = ?, contabancaria = ?"
					+ "WHERE id = ?";
			sqlUpdate = conex.prepareStatement(strUpdate);
		
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
	}
		
	public static ContribuinteDAO getInstance() {
		if(instance == null) {
			instance = new ContribuinteDAO();
		}
		
		return instance;
	}
		
	public void insert(Contribuinte contribuinte) {
	
		try {
		
			sqlInsert.setString(1, contribuinte.getCpf());
			sqlInsert.setString(2, contribuinte.getNome());
			sqlInsert.setInt(3, contribuinte.getIdade());
			sqlInsert.setString(4, contribuinte.getEndereco());
			sqlInsert.setInt(5, contribuinte.getContaBancaria());
			sqlInsert.executeUpdate();
		
		}catch(SQLException e){
		
			e.printStackTrace();
		
		}
	
	}
	
	public Contribuinte select(int id) {
		
		Contribuinte contribuinte = null;
		
		try {
		
			sqlSelect.setInt(1, id);
			ResultSet rs = sqlSelect.executeQuery();
			
			if(rs.next()) {
			
				contribuinte = new Contribuinte();
				contribuinte.setId(rs.getInt("id"));
				contribuinte.setCpf(rs.getString("cpf"));
				contribuinte.setNome(rs.getString("nome"));
				contribuinte.setIdade(rs.getInt("idade"));
				contribuinte.setEndereco(rs.getString("endereco"));
				contribuinte.setContaBancaria(rs.getInt("contabancaria"));
			
			}
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return contribuinte;
	
	}
	
	public ArrayList<Contribuinte> selectAll() {
		
		ArrayList<Contribuinte> contribuintes = new ArrayList<Contribuinte>();
		Contribuinte contribuinte = null;
		
		try {
		
			ResultSet rs = sqlSelectAll.executeQuery();
			
			while(rs.next()) {
			
				contribuinte = new Contribuinte();
				contribuinte.setId(rs.getInt("id"));
				contribuinte.setCpf(rs.getString("cpf"));
				contribuinte.setNome(rs.getString("nome"));
				contribuinte.setIdade(rs.getInt("idade"));
				contribuinte.setEndereco(rs.getString("endereco"));
				contribuinte.setContaBancaria(rs.getInt("contabancaria"));
				contribuintes.add(contribuinte);
			
			}
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return contribuintes;
	
	}
	
	public void update( Contribuinte contribuinte ) {
		
		try {
			sqlUpdate.setString(1, contribuinte.getNome() );
			sqlUpdate.setInt(2, contribuinte.getIdade() );
			sqlUpdate.setString(3, contribuinte.getEndereco());
			sqlUpdate.setInt(4, contribuinte.getContaBancaria());
			sqlUpdate.setInt(5, contribuinte.getId());
			sqlUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
