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

	public User(){
		this(null,null,0,0);
	}

	public User(String nom, String prenom, int company,int status) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom=new SimpleStringProperty(prenom);
		this.company=new SimpleIntegerProperty(company);
		this.status=new SimpleIntegerProperty(status);
	}

    public String getNom() {
        return nom.get();
    }

    public String getPrenom() {
        return prenom.get();
    }


    public int getCompany() {
        return company.get();
    }

    public int getStatus() {
        return status.get();
    }

    public void setprenom(String prenom) {
        this.prenom.set(prenom);
    }

    public void setnom(String nom) {
        this.nom.set(nom);
    }

    public void setcompany(int company) {
        this.company.set(company);
    }

    public void setstatus(int status) {
        this.status.set(status);
    }






}
