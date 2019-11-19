package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.ContraCheque;

public class ContraChequeDAO {

	private static ContraChequeDAO instance = null;
	private PreparedStatement sqlInsert;
	private PreparedStatement sqlDelete;
	private PreparedStatement sqlSelContribuinte;
	private PreparedStatement sqlSelPJ;
	
	private ContraChequeDAO(){
		Connection conex = Conexao.getConexao();
		
		try {
		
			String strInsert = "INSERT INTO contraCheque (numprotocolo, cnpj, valor, id_contribuinte, id_pessoajuridica) "
					+ " VALUES(?,?,?,?,?)";
			sqlInsert = conex.prepareStatement(strInsert);
			
			String strDelete = "DELETE FROM contraCheque "
					+ "WHERE id = ?";
			sqlDelete = conex.prepareStatement(strDelete);
			
			String strSelContribuinte = "SELECT * FROM contraCheque "
					+ "WHERE id_contribuinte = ?";
			sqlSelContribuinte = conex.prepareStatement(strSelContribuinte);
			
			String strSelPJ = "SELECT * FROM contraCheque "
					+ "WHERE id_pessoajuridica = ?";
			sqlSelPJ = conex.prepareStatement(strSelPJ);
		
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
	}
		
	public static ContraChequeDAO getInstance() {
		if(instance == null) {
			instance = new ContraChequeDAO();
		}
		
		return instance;
	}
		
	public void insert(ContraCheque contraCheque) {
	
		try {
		
			sqlInsert.setInt(1, contraCheque.getNumProtocolo());
			sqlInsert.setString(2, contraCheque.getCnpj());
			sqlInsert.setFloat(3, contraCheque.getValor());
			sqlInsert.setInt(4, contraCheque.getId_contribuinte());
			sqlInsert.setInt(5, contraCheque.getId_pessoajuridica());
			sqlInsert.executeUpdate();
		
		}catch(SQLException e){
		
			e.printStackTrace();
		
		}
	
	}
	
	public ArrayList<ContraCheque> selectByContribuinte(int id_contribuinte) {
	
		ArrayList<ContraCheque> notasFiscais = new ArrayList<ContraCheque>();
		ContraCheque contraCheque = null;
		
		try {
		
			sqlSelContribuinte.setInt(1, id_contribuinte);
			ResultSet rs = sqlSelContribuinte.executeQuery();
			
			if(rs.next()) {
			
				contraCheque = new ContraCheque();
				contraCheque.setId(rs.getInt("id"));
				contraCheque.setNumProtocolo(rs.getInt("numprotocolo"));
				contraCheque.setCnpj(rs.getString("cnpj"));
				contraCheque.setValor(rs.getFloat("valor"));
				contraCheque.setId_contribuinte(rs.getInt("id_contribuinte"));
				contraCheque.setId_pessoajuridica(rs.getInt("id_pessoajuridica"));
				notasFiscais.add(contraCheque);
			
			}
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return notasFiscais;
	
	}
	
	public ArrayList<ContraCheque> selectByPJ(int id_pessoajuridica) {
		
		ArrayList<ContraCheque> notasFiscais = new ArrayList<ContraCheque>();
		ContraCheque contraCheque = null;
		
		try {
		
			sqlSelPJ.setInt(1, id_pessoajuridica);
			ResultSet rs = sqlSelPJ.executeQuery();
			
			if(rs.next()) {
			
				contraCheque = new ContraCheque();
				contraCheque.setId(rs.getInt("id"));
				contraCheque.setNumProtocolo(rs.getInt("numprotocolo"));
				contraCheque.setCnpj(rs.getString("cnpj"));
				contraCheque.setValor(rs.getFloat("valor"));
				contraCheque.setId_contribuinte(rs.getInt("id_contribuinte"));
				contraCheque.setId_pessoajuridica(rs.getInt("id_pessoajuridica"));
				notasFiscais.add(contraCheque);
			
			}
		}catch(SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return notasFiscais;
	
	}
	
	public void delete( int id ) {
		
		try {
			sqlDelete.setInt(1, id);
			sqlDelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
