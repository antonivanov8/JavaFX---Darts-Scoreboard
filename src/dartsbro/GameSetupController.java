/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dartsbro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LAPTOP
 */
public class GameSetupController implements Initializable {    
    
    @FXML private TableView<Player> tableView;
    @FXML private TableColumn<Player, String> nicknameColumn;
    
    @FXML private TextField nicknameTextField;
    
    @FXML private ChoiceBox choiceBox;
    
    
    @FXML private Label no_players_created_label;
    @FXML private Label no_nickname_label;
    
    @FXML private Button game_back_yes;
    @FXML private Button game_back_no;
    @FXML private Label game_back_label;
    
    public void changeNicknameCellEvent(CellEditEvent edditedCell) {
        Player playerSlected = tableView.getSelectionModel().getSelectedItem();
        playerSlected.setNickname(edditedCell.getNewValue().toString());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        
        // make them editable
        tableView.setEditable(true);
        nicknameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //this will alow the table to select more than one row
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        nicknameColumn.setStyle( "-fx-alignment: CENTER;");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        choiceBox.getItems().add(701);
        choiceBox.getItems().add(601);
        choiceBox.getItems().add(501);
        choiceBox.getItems().add(401);
        choiceBox.getItems().add(301);
        choiceBox.getItems().add(201);
        choiceBox.getItems().add(101);
        choiceBox.getSelectionModel().selectFirst();
        
        no_players_created_label.setVisible(false);
        no_nickname_label.setVisible(false);
        
        game_back_label.setVisible(false);
        game_back_no.setVisible(false);
        game_back_yes.setVisible(false);
    }

    @FXML
    public void game_back_pushed () {
        game_back_label.setVisible(true);
        game_back_no.setVisible(true);
        game_back_yes.setVisible(true);
    }
    
    @FXML
    public void game_back_no_pushed () {
        game_back_label.setVisible(false);
        game_back_no.setVisible(false);
        game_back_yes.setVisible(false);
    }
    
    @FXML
    public void game_back_yes_pushed(ActionEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene  menuScene = new Scene(menu, 600, 400);
        menuScene.getStylesheets().add(StartGame.class.getResource("Style.css").toExternalForm());
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(menuScene);
        app_stage.show();
}
 
    @FXML
    public void start_game_button_pushed(ActionEvent event) throws IOException {
        
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Game.fxml"));
        Parent menu = loader.load();
        
         ObservableList<Player> list = tableView.getItems();
         
         if (!list.isEmpty()) { 
         for (int i = 0; i < list.size(); i++) {
             list.get(i).setPoints((int) choiceBox.getValue());
         }
        
        GameController controller = loader.getController();
        controller.initDate(tableView);
        
        Scene  menuScene = new Scene(menu, 600, 400);
        menuScene.getStylesheets().add(StartGame.class.getResource("Style.css").toExternalForm());
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(menuScene);
        app_stage.show();
         } else {
             no_players_created_label.setVisible(true);
             
         }
         
}
    @FXML
    public void add_player_button_pushed () {
        if (!nicknameTextField.getText().startsWith(" ") && !nicknameTextField.getText().isEmpty()) {
        Player newPlayer = new Player(nicknameTextField.getText());
        System.out.println(newPlayer.getNickname() + " " + newPlayer.getPoints() );
        // Get all the items from the table as a list, then add new Player to the list    
        tableView.getItems().add(newPlayer);
        no_nickname_label.setVisible(false);
        } else {
            no_nickname_label.setVisible(true);
        }
        nicknameTextField.clear();
    }
    
    @FXML
    public void remove_players_button_pushed () {
    
        ObservableList<Player> selectedRows, allPlayers;
        allPlayers = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        allPlayers.removeAll(selectedRows);
    }
    
}
