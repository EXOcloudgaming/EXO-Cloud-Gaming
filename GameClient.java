package name.fredericomba.lava;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author fredericomba
 */
public class GameClient extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane logInRoot, homeRoot;
        logInRoot = null;
        homeRoot = null;

        TextField emailInput;
        emailInput = null;

        PasswordField passwordInput;
        passwordInput = null;

        Button logInButton;
        logInButton = null;

        FXMLLoader logInLoader = new FXMLLoader(getClass().getResource("panels/log-in.fxml"));
        FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("panels/home.fxml"));

        try {

            logInRoot = logInLoader.load();
            homeRoot = homeLoader.load();

            emailInput = (TextField) logInLoader.getNamespace().get("EMAIL_INPUT");
            passwordInput = (PasswordField) logInLoader.getNamespace().get("PASSWORD_INPUT");
            logInButton = (Button) logInLoader.getNamespace().get("LOG_IN_BUTTON");

        } catch (IOException ex) {

            Logger.getLogger(GameClient.class.getName()).log(Level.SEVERE, null, ex);

        }        

        Scene logInScene = new Scene(logInRoot, 800, 600);
        Scene homeScene = new Scene(homeRoot, 1024, 768);
        
        logInButton.setOnAction((ActionEvent event) -> {
            primaryStage.hide();
            primaryStage.setTitle("Lava Game Client — Home");
            primaryStage.setScene(homeScene);
            primaryStage.show();
        });

        primaryStage.setTitle("Lava Game Client — Log In");
        primaryStage.setScene(logInScene);
        primaryStage.show();   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
