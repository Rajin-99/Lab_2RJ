module com.example.csd214lab2_rajin {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.csd214lab2_rajin to javafx.fxml;
    exports com.example.csd214lab2_rajin;
}