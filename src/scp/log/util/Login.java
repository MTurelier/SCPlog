package scp.log.util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	//Classe de gestion de login
public class Login{


	Connection conn;
	Statement statement = null;
	ResultSet resultat;
	

public boolean Login(String login, String pass) { 
	
	System.out.println();
		try{
			try{
				//add comment to commit
			statement = Connect.connexionBD().createStatement();
			Connect.connexionBD();			
			String sql = "SELECT password FROM user WHERE login ='"+login+"'";
			resultat = statement.executeQuery(sql);
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			if(resultat.next()){
				String motDePasse = resultat.getString(1);
			if(motDePasse.equals(pass)){
				return true;
			}else{
				return false;
			}
			}else{
				return false;
			}
		}catch (SQLException e4){
			System.out.println(e4.getMessage());
		}
		return false;


	}



}
