package scp.log.view;


import java.sql.Connection;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scp.log.util.Connect;

/**
 * Gestion de la fenêtre nouvel utilisateur
 */
public class NewUserController {

    private ObservableList<String> companyList = FXCollections.observableArrayList("SCP", "SCM", "SCPM");
    private ObservableList<String> statusList = FXCollections.observableArrayList("Direction", "Admin", "Employ�");

    Connection conn;
    private Statement statement = null;

    @FXML
    private Stage NewUserStage;
    private boolean OkClicked = false;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private TextField Login;
    @FXML
    private TextField Password;
    @FXML
    private ComboBox<String> Company;
    @FXML
    private ComboBox<String> Statut;

    /**
     * Initialisation
     */
    @FXML
    private void initialize() {
        Company.setItems(companyList);
        Statut.setItems(statusList);
        Statut.setValue("Direction");
        Company.setValue("SCP");


    }

    /**
     *
     * @param NewUserStage Fenetre nouvel utilisateur
     */
    public void setNewUserStage(Stage NewUserStage) {
        this.NewUserStage = NewUserStage;
    }

    /**
     *
     * @return true si OkClicked
     */
    public boolean isOkClicked() {
        return OkClicked;
    }

    /**
     * Gestion du bouton Cancel
     */
    @FXML
    private void handleCancel() {
        try {
            NewUserStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return true si les données sont corrects
     * Verification de tout les champs de textes
     */
    private boolean isInputValid() {
        String errorMessage = "";
        if (Nom.getText() == null || Nom.getText().length() == 0) {
            errorMessage += "No valid last name !\n";
        }
        if (Prenom.getText() == null || Prenom.getText().length() == 0) {
            errorMessage += "No valid first name !\n";
        }
        if (Login.getText() == null || Login.getText().length() == 0) {
            errorMessage += "No valid login !\n";
        }
        if (Password.getText() == null || Password.getText().length() == 0) {
            errorMessage += "No valid Password !\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(NewUserStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            return false;
        }
    }
/**
 * Gestion bouton OK
 */
    @FXML
    private void HandleOK() {
        if (isInputValid()) {
            int comp = 0;
            int stat = 0;
            String nom = Nom.getText();
            String prenom = Prenom.getText();
            String login = Login.getText();
            String pass = Password.getText();
            String company = Company.getSelectionModel().getSelectedItem();
            String statut = Statut.getSelectionModel().getSelectedItem().toString();
            switch (company) {
                case "SCP":
                    comp = 1;
                    break;
                case "SCM":
                    comp = 2;
                    break;
                case "SCPM":
                    comp = 3;
                    break;
            }
            switch (statut) {
                case "Direction":
                    stat = 1;
                    break;
                case "Admin":
                    stat = 2;
                    break;
                case "Employ�":
                    stat = 3;
                    break;
            }
            Connect.connexionBD();
            try {
                statement = Connect.connexionBD().createStatement();
                Connect.connexionBD();
                String sql = "INSERT INTO user SET nom='" + nom + "',prenom='" + prenom + "',login='" + login + "',password='" + pass + "',societe=" + comp + ",statut=" + stat + ";";
                statement.executeUpdate(sql);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                OkClicked = true;
                NewUserStage.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }


}
