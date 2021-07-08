package fr.eni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AppelBDDAjout {
	
	public static void main(String[] args){
		
		final String URL="jdbc:sqlserver://localhost:1433;databaseName=BDD_DEMO";
		final String USER="sa";
		final String PASSW="Pa$$w0rd";
		final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";

		final String INSERT ="INSERT INTO Stagiaires(nom, prenom, dateDeNaissance, motDePasse) VALUES(?,?,?,?)";
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Le driver na pas été trouvé");
		}
		
		try(
			 Connection cnx=DriverManager.getConnection(URL, USER, PASSW);
				//preparedStatement nécessaire pour une insertion
			 PreparedStatement pstt= cnx.prepareStatement(INSERT);
				
			) 
		{
			//Traitements
			 
			 String nom = "Leblanc";
			 String prenom = "Juste";
			 java.util.Date dateDeNaissance = new Date(100, 4, 12);// ce format de date commence à 1900 erreur ici car on rajoute 100 plutôt que 2000 ans pour arriver au années 2000
			 String motDePasse = "123456";
			//insertion dans la table stagiaire
			
			 pstt.setString(1, nom);
			 pstt.setString(2, prenom);
			 pstt.setDate(3, new java.sql.Date(dateDeNaissance.getTime()));
			 pstt.setString(4,motDePasse);
			 pstt.executeUpdate();
			 
		} catch (SQLException e) {
			System.out.println("La connexion n'a pas eu lieu");
			e.printStackTrace();
		}		
		System.out.println("Fin du programme");
	}
	
}
