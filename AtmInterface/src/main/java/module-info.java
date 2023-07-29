module com.example.atminterface {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atminterface to javafx.fxml;
    exports com.example.atminterface;
}