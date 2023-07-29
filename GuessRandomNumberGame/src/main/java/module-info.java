module com.example.guessrandomnumbergame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.guessrandomnumbergame to javafx.fxml;
    exports com.example.guessrandomnumbergame;
}