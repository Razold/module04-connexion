package fr.eni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AppleBDDForNameResource {
	
	public static void main(String[] args){
		
		final String URL="jdbc:sqlserver://localhost:1433;databaseName=BDD_DEMO";
		final String USER="sa";
		final String PASSW="Pa$$w0rd";
		final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";

		final String FINDALL ="SELECT noStagiaire,nom,prenom,dateDeNaissance,motDePasse FROM Stagiaires";

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Le driver na pas été trouvé");
		}
		
		try(
			 Connection cnx=DriverManager.getConnection(URL, USER, PASSW);
			 Statement stt= cnx.createStatement();
				
			) 
		{
			//Traitements
			
			//Liste des stagiaires de la base
			ResultSet rs = stt.executeQuery(FINDALL);
			
			//si l'on veut faire un setDate() sur la bdd a partir d'eclipse on doit transformer notre date qui est en java.util.Date sous eclipse en java.sql.Date pour sqlDeveloper
			//java.sql.date jsd= new java.util.Date(new java.sql.Date());
			 while (rs.next()) {
				 int noStagiaire= rs.getInt("noStagiaire");//possibilité d'utiliser aussi getInt(numColonne) qui renvoi l'attribut en fonction de sa position dans la requete commence par un
				 String nom=rs.getString(2);
				 String prenom=rs.getString("prenom");
				 Date dateDeNaissance= rs.getDate("dateDeNaissance");
				 String motDePasse=rs.getString("motDePasse");
				 
				 System.out.println(noStagiaire+" : "+nom+" "+prenom+" né(e) le "+dateDeNaissance+" mot de passe:"+motDePasse+"");
			 }
			
		
			//pas de try catch nécessaire pour ce close() là
			rs.close();
			
		} catch (SQLException e) {
			System.out.println("La connexion n'a pas eu lieu");
			e.printStackTrace();
		}		
		System.out.println("Fin du programme");
	}
	
}
