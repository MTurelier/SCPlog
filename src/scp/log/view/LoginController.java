package scp.log.view;

import javafx.fxml.FXML;
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

public class LoginController {

	public String login=new String();
	public String pass=new String();

	@FXML
	public  TextField Unamefield;
	@FXML
	public PasswordField Pwordfield;
	private Stage loginStage;
	private boolean okClicked = false;
	private MainApp mainApp;
	@FXML
	public Button ok;

	@FXML
	private void initialize(){

	}

	public void setloginStage (Stage loginStage){
		this.loginStage = loginStage;
	}

    public boolean isOkClicked() {
        return okClicked;
    }

    public void setMainApp(MainApp mainApp){
    	this.mainApp = mainApp;
    }


    @FXML
    private void handleCancel() {
    	System.exit(0);

    }

    @FXML
    private void handleNew(){
    	login = Unamefield.getText();
    	pass = Pwordfield.getText();
    	Login log = new Login();
    	if (log.Login(login, pass) == true){
    	boolean okClicked = mainApp.showNUser();
    	}    	else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(loginStage);
            alert.setHeaderText("Please correct invalid fields");
            alert.setTitle("IDs Incorrect");
            alert.setContentText("Identifiants incorrect");

            alert.showAndWait();

    	}
    }

    @FXML
    private void handleOk() {
    	login = Unamefield.getText();
    	pass = Pwordfield.getText();
    	Login log = new Login();
    	SetUser setUser = new SetUser();
    	if (log.Login(login, pass) == true){
    		
    	setUser.setUser(login);	
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.initOwner(loginStage);
        alert.setTitle("Login OK");
        alert.setContentText("Login OK");
        

        alert.showAndWait();
    	}
    	else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(loginStage);
            alert.setHeaderText("Please correct invalid fields");
            alert.setTitle("IDs Incorrect");
            alert.setContentText("Identifiants incorrect");

            alert.showAndWait();

    	}
    }
}