package com.example.guessrandomnumbergame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class HelloController {
    static int val,ans;
    int attempts = 0;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private void tryGuess(ActionEvent event) throws IOException {
        Random random = new Random();
        do {
            val = random.nextInt(101);
        }while (val == 0);
        System.out.println(val);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private TextField numberField;
    @FXML
    private Label attemptsLabel;
    @FXML
    private void match(ActionEvent event) throws IOException {

            ans = Integer.parseInt(numberField.getText());
            if(ans == val){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Win!");
                alert.setHeaderText("You win successfully!");
                alert.setContentText("Your Score : " + (100-attempts*20) );
                alert.show();
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else if(val > ans && attempts < 4){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hint");
                alert.setHeaderText("You prediction is low!");
                alert.show();

            }
            else if(val < ans && attempts < 4){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hint");
                alert.setHeaderText("You prediction is high!");
                alert.show();
            }
            attempts++;
            attemptsLabel.setText("Attempts : " + attempts);
         if(attempts == 5) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Lose!");
             alert.setHeaderText("You lose!\nTry again!!!");
             alert.show();
             root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
             stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
         }
    }
}