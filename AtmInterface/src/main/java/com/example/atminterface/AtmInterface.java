package com.example.atminterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
public class AtmInterface {
    private static int pin;
    private static int balance = 500000;
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private void CW(ActionEvent event) throws IOException {
        System.out.println(pin);
        if(pin==0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Set Pin First..!");
            alert.show();

        }
        else {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cashwithdraw.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    private void B(ActionEvent event) {
        Alert alert;
        if(pin==0) {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Set Pin First..!");
        }
        else {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Your Balance is ");
            alert.setContentText("₹"+balance);
        }
        alert.show();
    }
    @FXML
    private void CP(ActionEvent event) throws IOException {
        if (pin==0) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("setpin.fxml")));
        }
        else {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("changepin.fxml")));
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void D(ActionEvent event) throws IOException {
        if(pin==0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Set Pin First..!");
            alert.show();
        }
        else {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deposit.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    private TextField withdrawField;
    @FXML
    private PasswordField pinField;
    @FXML
    private PasswordField newpinField;
    @FXML
    private PasswordField confirmFeld;
    @FXML
    private TextField depositField;

    @FXML
    private void CashWithdraw(ActionEvent event) throws IOException {
            int withdraw = Integer.parseInt(withdrawField.getText());
            int epin = Integer.parseInt(pinField.getText());
            if(pin == epin){
                if(balance >= withdraw){
                    balance -= withdraw;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Transaction Completed");
                    alert.setContentText("Collect your money..!");
                    alert.show();
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Incorrect Pin");
                alert.show();
        }
    }

    @FXML
    private void Deposit(ActionEvent event) throws IOException {
        int cashdeposit = Integer.parseInt(depositField.getText());
        int epin = Integer.parseInt(pinField.getText());
        if(pin == epin){
            balance += cashdeposit;
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Incorrect Pin");
            alert.show();
        }
    }

    @FXML
    private void SetPin(ActionEvent event) throws IOException {
        int epin = Integer.parseInt(pinField.getText());
        int repin = Integer.parseInt(confirmFeld.getText());
        if(epin == repin){
            System.out.println(epin);
            pin = epin;
            System.out.println(pin);
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Pin Mismatched");
            alert.show();
        }
    }

    @FXML
    private void ChangePin(ActionEvent event) throws IOException {
        int epin = Integer.parseInt(pinField.getText());
        int newpin = Integer.parseInt(newpinField.getText());
        int repin = Integer.parseInt(confirmFeld.getText());
        if(epin == pin){
            if(newpin == repin){
                pin = newpin;
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Pin Mismatched");
                alert.show();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Incorrect Pin");
            alert.show();
        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}