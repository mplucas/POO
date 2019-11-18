package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

private static Connection conex = null;

private Conexao() {

}

public static Connection getConexao() {

	if(conex == null) {
	
		String url = "jdbc:postgresql://localhost:5432/ReservaPassagem";
		String user = "postgres";
		String password = "udesc";
		
		try {
		
			Class.forName("org.postgresql.Driver");
			conex = DriverManager.getConnection(url, user, password);
			
		}catch (ClassNotFoundException e) {
		
			System.out.println("Driver de conexão ao BD não encontrado.");
		
		} catch (SQLException e) {
		
			System.out.println("Erro na conexão com BD."+e);
		
		}
	}
	
	return conex;
	
	}
}