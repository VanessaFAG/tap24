module com.example.tap24 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tap24 to javafx.fxml;
    exports com.example.tap24;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mariadb.java.client;
    opens com.example.tap24.modelos;
}