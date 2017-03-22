package scp.log.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final StringProperty nom;
    private final StringProperty prenom;
    private final IntegerProperty company;
    private final IntegerProperty status;



    public User() {
        this(null, null, 0, 0);
    }

    /**
     * Sauvegarde de l'utilisateur lors de l'utilisation du logiciel
     * @param nom nom d'utilisateur
     * @param prenom prénom utilisateur
     * @param company Entreprise
     * @param status Status hierarchique
     */
    private User(String nom, String prenom, int company, int status) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.company = new SimpleIntegerProperty(company);
        this.status = new SimpleIntegerProperty(status);
    }

    /**
     * Getter Nom
     * @return Nom
     */
    public String getNom() {
        return nom.get();
    }

    /**
     * Getter Prenom
     * @return Prenom
     */
    public String getPrenom() {
        return prenom.get();
    }

    /**
     * Getter company
     * @return Code de l'entreprise (1 pour SCP 2 pour SCM 3 pour les 2)
     */
    public int getCompany() {
        return company.get();
    }

    /**
     * Getter Status
     * @return Status 1 direction 2 management 3 technicien
     */
    public int getStatus() {
        return status.get();
    }

    /**
     * Setter Prenom
     * @param prenom
     */
    public void setprenom(String prenom) {
        this.prenom.set(prenom);
    }

    /**
     * Setter Nom
     * @param nom
     */
    public void setnom(String nom) {
        this.nom.set(nom);
    }

    /**
     * Setter entreprise
     * @param company
     */
    public void setcompany(int company) {
        this.company.set(company);
    }

    /**
     * Setter Status
     * @param status
     */
    public void setstatus(int status) {
        this.status.set(status);
    }


}
