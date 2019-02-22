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
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LAPTOP
 */
public class RulesController implements Initializable {

    @FXML
    TextFlow rules_text;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void back_button_pushed(ActionEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene  menuScene = new Scene(menu, 600, 400);
        menuScene.getStylesheets().add(StartGame.class.getResource("Style.css").toExternalForm());
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
}
}
