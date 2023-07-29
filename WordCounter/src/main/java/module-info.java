module com.example.wordcounter {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.wordcounter to javafx.fxml;
    exports com.example.wordcounter;
}