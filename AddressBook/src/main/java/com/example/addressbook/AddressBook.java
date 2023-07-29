package com.example.addressbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBook implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public List<Contact> searchContact(String searchName) {
        List<Contact> foundContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchName.toLowerCase())) {
                foundContacts.add(contact);
            }
        }
        return foundContacts;
    }

    public void saveToFile(String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AddressBook loadFromFile(String filename) {
        AddressBook addressBook = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            addressBook = (AddressBook) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return addressBook != null ? addressBook : new AddressBook();
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
