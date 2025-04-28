module com.example.theeasiestgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.theeasiestgame to javafx.fxml;
    exports com.example.theeasiestgame;
}