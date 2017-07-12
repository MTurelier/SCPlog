package scp.log.util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Gestion du login
 */
public class Login {


    Connection conn;
    private ResultSet resultat;

    /**
     *
     * @param login Nom d'utilisateur
     * @param pass mot de passe
     * @return True si l'utilisateur existe
     */
    public boolean Login(final String login, final String pass) {

        System.out.println();
        try {
            try {

                Statement statement = Connect.connexionBD().createStatement();
                Connect.connexionBD();
                String sql = "SELECT password FROM user WHERE login ='" + login + "'";
                resultat = statement.executeQuery(sql);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (resultat.next()) {
                String motDePasse = resultat.getString(1);
                return motDePasse.equals(pass);
            } else {
                return false;
            }
        } catch (SQLException e4) {
            System.out.println(e4.getMessage());
        }
        return false;


    }


}
