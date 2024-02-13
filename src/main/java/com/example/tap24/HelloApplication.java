package com.example.tap24;

import com.example.tap24.vistas.calculadora;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    private MenuBar mBarPrincipal;
    private Menu menuPar1, menuPar2, menuSalir;
    private MenuItem mItemCalculadora, mItSalir;
    private BorderPane bpPanel;

    @Override
    public void start(Stage stage) throws IOException {
        crearMenu();
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        bpPanel = new BorderPane();
        bpPanel.setTop(mBarPrincipal);
        Scene scene = new Scene(bpPanel);
        scene.getStylesheets().add(getClass().getResource("/estilos/main.css").toString());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

    }

    private void crearMenu() {

        // Primer parcial
        mItemCalculadora = new MenuItem("Calculadora");
        menuPar1 = new Menu("1° Parcial");
        menuPar1.getItems().addAll(mItemCalculadora);
        //menuPar1.getClass(calculadora());

        // Segundo parcial
        menuPar2 = new Menu("2° Parcial");

        // Menu salir
        mItSalir = new MenuItem("Salir");
        menuSalir = new Menu("Opciones...");
        menuSalir.getItems().add(mItSalir);
        mItSalir.setOnAction(event -> System.exit(0));

        mBarPrincipal = new MenuBar();
        mBarPrincipal.getMenus().addAll(menuPar1, menuPar2, menuSalir);

    }

    public static void main(String[] args) {
        launch();
    }
}