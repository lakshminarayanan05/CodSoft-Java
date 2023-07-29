package com.example.wordcounter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Collections;
import java.util.HashSet;


public class HelloController {
    @FXML
    private Label wordslabel;
    @FXML
    private Label uniquewordslabel;
    @FXML
    private TextField textField;

    @FXML
    private void count(ActionEvent event){
        String str = textField.getText();
        String[] text = str.split("[,.@;: ]+");
        wordslabel.setText("0"+text.length);
        HashSet<String> unwd = new HashSet<>();
        Collections.addAll(unwd, text);
        uniquewordslabel.setText("0"+unwd.size());
    }

}