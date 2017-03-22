package scp.log.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    /**
     * Connection BDD
     */
    private static Connection conn;

    /**
     * Classe de connection base de données
     */
    private Connect() {

        //URL de connexion
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception e) {
                System.out.println("erreur de chargement de la BDD");
                e.getMessage();
                System.exit(0);
            }
            //Connection MySQL

            try {
                String url = "jdbc:mysql://localhost/SCP";
                String user = "root";
                String passwd = "root";

                conn = DriverManager.getConnection(url, user, passwd);
                System.out.println("Connexion effective !");


            } catch (Exception e) {
                System.out.println("erreur de chargement de la BDD");
            }
        }
    }


    /**
     *
     * @return conn (connection BDD) Vérification du patern de connection
     */
    public static Connection connexionBD() {
        if (conn == null) {
            new Connect();
        }
        return conn;
    }

    /**
     * Deconnection base de données
     */
    public void Deconnexion() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Deconnexion Impossible");
        }
    }


}



