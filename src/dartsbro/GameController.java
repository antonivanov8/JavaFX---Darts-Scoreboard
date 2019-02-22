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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LAPTOP
 */
public class GameController implements Initializable {

    private TableView<Player> dateTableView;
    private int first = 0;
    
    @FXML
    private TableView<Player> gameTableView;
    @FXML 
    private TableColumn<Player, String> nicknameColumn;
    @FXML
    private TableColumn<Player, Integer> pointsColumn;
    
    @FXML
    private TextField sum;
    
    @FXML
    private Button game_back_yes;
    @FXML
    private Button game_back_no;
    @FXML
    private Label game_back_label;
    
    public void initDate(TableView<Player> tableView) {
        ObservableList<Player> list = tableView.getItems();
        dateTableView = new TableView<>();
        dateTableView.setItems(list);
        ObservableList<Player> list2 = dateTableView.getItems();
        gameTableView.getItems().addAll(list2);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
      pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
      game_back_label.setVisible(false);
      game_back_no.setVisible(false);
      game_back_yes.setVisible(false);
      gameTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      nicknameColumn.setStyle( "-fx-alignment: CENTER;");
      pointsColumn.setStyle( "-fx-alignment: CENTER;");
    }    
    
    public void one_button_pushed () {
        sum.setText(sum.getText() + "1");
    }
    public void two_button_pushed () {
        sum.setText(sum.getText() + "2");
    }
    public void tree_button_pushed () {
        sum.setText(sum.getText() + "3");
    }
    public void four_button_pushed () {
        sum.setText(sum.getText() + "4");
    }
    public void five_button_pushed () {
        sum.setText(sum.getText() + "5");
    }
    public void six_button_pushed () {
        sum.setText(sum.getText() + "6");
    }
    public void seven_button_pushed () {
        sum.setText(sum.getText() + "7");
    }
    public void eight_button_pushed () {
        sum.setText(sum.getText() + "8");
    }
    public void nine_button_pushed () {
        sum.setText(sum.getText() + "9");
    }
    public void zero_button_pushed () {
        sum.setText(sum.getText() + "0");
    }
    
    public void enter_sum_button_pushed() {
        ObservableList<Player> list = gameTableView.getItems();

        int b = gameTableView.getItems().size();
        
        if (first != b) {
            list.get(first).setPoints(list.get(first).getPoints() - Integer.valueOf(sum.getText()));
            System.out.println(list.get(0).getPoints());
            sum.clear();
            first++;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getPoints() == 0) {
                    list.get(i).setNickname("WIN " + list.get(i).getNickname() + " WIN");
                }
            }
            if(first == b) {
                first = 0;
            }
        }
        gameTableView.setItems(list);
        gameTableView.refresh();
    }
    
    
    public void game_back_pushed () {
        game_back_label.setVisible(true);
        game_back_no.setVisible(true);
        game_back_yes.setVisible(true);
    }
    
    public void game_back_no_pushed () {
        game_back_label.setVisible(false);
        game_back_no.setVisible(false);
        game_back_yes.setVisible(false);
    }
    
    public void game_back_yes_pushed(ActionEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("GameSetup.fxml"));
        Scene  menuScene = new Scene(menu, 600, 400);
        menuScene.getStylesheets().add(StartGame.class.getResource("Style.css").toExternalForm());
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
}
}
