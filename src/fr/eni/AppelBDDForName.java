package fr.eni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class AppelBDDForName {
	
	public static void main(String[] args){
		
		final String URL="jdbc:sqlserver://localhost:1433;databaseName=BDD_DEMO";
		final String USER="sa";
		final String PASSW="Pa$$w0rd";
		final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		Connection cnx=null;
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Le driver n'a pas été trouvé");
		}
		
		try {
			cnx=DriverManager.getConnection(URL, USER, PASSW);
		} catch (SQLException e) {
			System.out.println("La connexion n'a pas eu lieu");
			e.printStackTrace();
		}finally {
			if(cnx != null) {
				try {
					cnx.close();
				} catch (SQLException e) {
					System.out.println("La connexion n'a pas réussi à fermer ");
					e.printStackTrace();
				}				
			}
		}
		
		System.out.println("Fin du programme");
		
	}

}
