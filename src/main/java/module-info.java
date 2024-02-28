module com.example.tap24 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tap24 to javafx.fxml;
    exports com.example.tap24;

    requires java.sql;
    requires mariadb.java.client;
}