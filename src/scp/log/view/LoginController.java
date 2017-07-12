package scp.log.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import scp.log.MainApp;
import scp.log.util.Connect;
import scp.log.util.Login;
import scp.log.util.SetUser;

import java.io.IOException;

public class LoginController {

    private String login = new String();
    private String pass = new String();

    @FXML
    private TextField Unamefield;
    @FXML
    private PasswordField Pwordfield;
    private Stage loginStage;
    private boolean okClicked = false;
    @FXML
    public Button ok;

    /**
     *
     * @param mainApp Appelle Classe MainApp
     */
    public void setMainApp(MainApp mainApp) {
    }

    /**
     * Sortie de la fenêtre
     */
    @FXML
    private void handleCancel() {


        System.exit(0);

    }

    /**
     * Gestion du boutton New
     */
    @FXML
    private void handleNew() {
        login = Unamefield.getText();
        pass = Pwordfield.getText();
        Login log = new Login();
        if (log.Login(login, pass)) {
            MainApp mainApp = new MainApp();
            mainApp.showNUser();

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(loginStage);
            alert.setHeaderText("Please correct invalid fields");
            alert.setTitle("IDs Incorrect");
            alert.setContentText("Identifiants incorrect");

            alert.showAndWait();

        }
    }

    /**
     * Gestion du bouton Ok
     */
    @FXML
    private void handleOk(ActionEvent event) throws IOException {

        Stage stage = new Stage();

        Parent root;
        login = Unamefield.getText();
        pass = Pwordfield.getText();
        Login log = new Login();
        SetUser setUser = new SetUser();
       if (log.Login(login, pass)) {


         /*  setUser.setUser(login);
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.initOwner(loginStage);
           alert.setTitle("Login OK");
           alert.setContentText("Login OK");
           alert.showAndWait();*/
               try {
                   loginStage.close();
                   root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
                   Scene scene = new Scene(root);
                   stage.setScene(scene);
                   stage.show();

               } catch (IOException e) {
                   e.printStackTrace();
               }



       } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(loginStage);
            alert.setHeaderText("Please correct invalid fields");
            alert.setTitle("IDs Incorrect");
            alert.setContentText("Identifiants incorrect");

            alert.showAndWait();

        }
    }

    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }
}