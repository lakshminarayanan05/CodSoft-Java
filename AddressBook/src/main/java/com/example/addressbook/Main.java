package com.example.addressbook;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {
    private AddressBook addressBook = AddressBook.loadFromFile("contacts.dat");
    private ListView<Contact> contactListView = new ListView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Address Book System");

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone Number");
        TextField emailField = new TextField();
        emailField.setPromptText("Email Address");

        Button addButton = new Button("Add Contact");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                Contact contact = new Contact(name, phone, email);
                addressBook.addContact(contact);
                updateContactListView();
                nameField.clear();
                phoneField.clear();
                emailField.clear();
            }
        });

        Button removeButton = new Button("Remove Contact");
        removeButton.setOnAction(e -> {
            Contact selectedContact = contactListView.getSelectionModel().getSelectedItem();
            if (selectedContact != null) {
                addressBook.removeContact(selectedContact);
                updateContactListView();
            }
        });

        Button saveButton = new Button("Save and Exit");
        saveButton.setOnAction(e -> {
            addressBook.saveToFile("contacts.dat");
            primaryStage.close();
        });

        Label searchLabel = new Label("Search Contact:");
        TextField searchField = new TextField();
        searchField.setPromptText("Enter name to search");

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            String searchName = searchField.getText();
            if (!searchName.isEmpty()) {
                updateContactListView(addressBook.searchContact(searchName));
            }
        });

        contactListView.setPrefHeight(250);
        updateContactListView();

        vbox.getChildren().addAll(nameField, phoneField, emailField, addButton, removeButton, saveButton,
                searchLabel, searchField, searchButton, contactListView);

        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateContactListView() {
        updateContactListView(addressBook.getContacts());
    }

    private void updateContactListView(List<Contact> contacts) {
        contactListView.getItems().clear();
        contactListView.getItems().addAll(contacts);
    }

    @Override
    public void stop() throws Exception {
        addressBook.saveToFile("contacts.dat");
        super.stop();
    }
}
