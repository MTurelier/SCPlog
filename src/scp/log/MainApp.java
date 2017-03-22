package scp.log;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import scp.log.view.LoginController;
import scp.log.view.NewUserController;

@SuppressWarnings("ALL")
/**
 * Main App
 */
public class MainApp extends Application {
    /**
     * Déclaration de la variable primary Stage
     */
    private Stage primaryStage;

    /**
     * Initialisation première fenêtre
     * @param primaryStage
     * Première fenêtre à apparaitre
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SCPlog");
        showLogin();

    }

    /**
     * Initialisation primary Stage
     */
    public void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
            AnchorPane login = (AnchorPane) loader.load();

            Scene scene = new Scene(login);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
            LoginController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return True
     * si Controller OK
     */
    public boolean showNUser() {
        try {


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/NewUser.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            NewUserController controller = loader.getController();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            controller.setNewUserStage(dialogStage);
            dialogStage.setResizable(false);

            dialogStage.showAndWait();

            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @return primaryStage Renvoi la première fenêtre du software
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     *
     * @param args Classe Main
     */
    public static void main(String[] args) {
        launch(args);
    }
}
