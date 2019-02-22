/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dartsbro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author LAPTOP
 */
public class MenuController implements Initializable {

    
    @FXML
    public void game_setup_button_pushed(ActionEvent event) throws IOException {
        Parent gameSetup = FXMLLoader.load(getClass().getResource("GameSetup.fxml"));
        Scene  gameSetupScene = new Scene(gameSetup, 600, 400);
        gameSetupScene.getStylesheets().add(StartGame.class.getResource("Style.css").toExternalForm());
        Stage primaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaStage.setScene(gameSetupScene);
        primaStage.show();
}
    @FXML
    public void players_button_pushed(ActionEvent event) throws IOException {
        Parent players = FXMLLoader.load(getClass().getResource("Players.fxml"));
        Scene  playersScene = new Scene(players, 600, 400);
        playersScene.getStylesheets().add(StartGame.class.getResource("Style.css").toExternalForm());
        Stage primaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaStage.setScene(playersScene);
        primaStage.show();
}   
    @FXML
    public void rules_button_pushed(ActionEvent event) throws IOException {
        Parent rules = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        Scene  rulesScene = new Scene(rules, 600, 400);
        rulesScene.getStylesheets().add(StartGame.class.getResource("Style.css").toExternalForm());
        Stage primaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaStage.setScene(rulesScene);
        primaStage.show();
}
    @FXML
    public void exit_button_pushed(ActionEvent event) throws IOException {
        System.exit(0);
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
