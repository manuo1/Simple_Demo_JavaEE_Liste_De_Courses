package gestion_listes_courses.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataBaseConnection {
	
	private static DataSource dataSource;

	static {
		
		try {
			Context context = new InitialContext();
			DataBaseConnection.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'obtenir une connexion à la base de donnée");
		}
		
	}
	
	public static Connection getConnection() throws SQLException
	{
		return DataBaseConnection.dataSource.getConnection();
	}
	
}