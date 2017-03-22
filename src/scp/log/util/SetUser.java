package scp.log.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import scp.log.model.User;

public class SetUser {


    Connection conn;
    private Statement statement = null;
    private ResultSet resultat;
    User user = new User();

    /**
     * Classe de sauvegarde de l'utilisateur
     * @param login nom d'utilisateur
     */
    public void setUser(String login) {


        try {

            statement = Connect.connexionBD().createStatement();
            Connect.connexionBD();
            String query = "SELECT * FROM user WHERE login ='" + login + "';";
            ResultSet result = statement.executeQuery(query);
            result.first();
            String nom;
            String prenom;
            int company;
            int statut;


            nom = result.getString("nom");
            user.setnom(nom);

            prenom = result.getString("prenom");
            user.setprenom(prenom);

            company = result.getInt("societe");
            user.setcompany(company);

            statut = result.getInt("statut");
            user.setstatus(statut);

            result.close();
            statement.close();
        } catch (SQLException e4) {
            System.out.println(e4.getMessage());

        }

    }
}
