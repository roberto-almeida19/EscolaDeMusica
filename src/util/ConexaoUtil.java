package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para gera��o de conex�o com o banco de dados
 * 
 * @author Carlos
 */
public class ConexaoUtil {

	public static Connection getConexao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/escola_de_musica?useSSL=false", "root","root");

	}	
}
