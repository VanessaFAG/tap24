package com.example.tap24.modelos;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class empleadoTaqueria extends Stage {
    private VBox vprincipal;
    private ToolBar toolMenu;
    private Scene escena;
    private TableView<empleadoDAO> tbvEmpleado;
    //la tabla que se se va a mostar o de que tabla se va alimentar
    // que este entre un <> significa el tipo de dato que va a recibir, en este caso una tabla
    public empleadoTaqueria(){
        crearUI();
        this.setTitle("Taqueria Mishote :D");
        this.setScene(escena);
        this.show();
    }

    private void crearUI() {
        toolMenu = new ToolBar();
        createTable();
        vprincipal = new VBox(toolMenu, tbvEmpleado);
        escena = new Scene(vprincipal, 600, 400);


    }

    private void createTable() {
        tbvEmpleado = new TableView<empleadoDAO>();//que va a recibir
        TableColumn<empleadoDAO, String> tbcNomEmp = new TableColumn<>("Nombre");//se define el atributo
        TableColumn<empleadoDAO, String> tbcrfcEmp = new TableColumn<>("RFC");
        TableColumn<empleadoDAO, String> tbcSueldoEmp = new TableColumn<>("Salario");
        TableColumn<empleadoDAO, String> tbcTelefEmp = new TableColumn<>("Telefono");
        TableColumn<empleadoDAO, String> tbcDirecEmp = new TableColumn<>("Direccion");
        tbvEmpleado.getColumns().addAll(tbcNomEmp,tbcrfcEmp,tbcSueldoEmp,tbcTelefEmp,tbcDirecEmp);
    }
}
