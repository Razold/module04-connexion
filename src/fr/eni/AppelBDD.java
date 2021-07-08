package fr.eni;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class AppelBDD {
	
	public static void main(String args[]){
		
		try {
			DriverManager.registerDriver(new SQLServerDriver());
		} catch (SQLException e) {
			System.out.println("Un problème est survenu au chargement du driver");
			e.printStackTrace();
		}
		System.out.println("Fin du programme");
		
	}

}
