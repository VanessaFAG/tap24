package com.example.tap24.vistas;

import com.example.tap24.modelos.empleadoDAO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class empleadoFrom extends Stage {
    private TableView<empleadoDAO> tbvEmpleado;
    private empleadoDAO objEmp;
    String [] arPromts = {"Nombre del Empleado", "RFC", "Sueldo", "Telefono", "Direccion"};
    private Scene escena;
    private TextField[] arTxtCampo = new TextField[5];
    private Button btnSave;
    private VBox vprincipal;
    public empleadoFrom(TableView<empleadoDAO>tbvEmp, empleadoDAO objEmp) {
        this.tbvEmpleado = tbvEmp;//hacia donde apunta la otra clase, la referencia
        this.objEmp = (objEmp == null) ? new empleadoDAO() : objEmp;
        crearUI();
        this.setTitle("Agregar Usuario");
        this.setScene(escena);
        this.show();
    }

    private void crearUI() {
        vprincipal = new VBox();
        vprincipal.setPadding(new Insets(10));
        vprincipal.setSpacing(10);
        vprincipal.setAlignment(Pos.CENTER);
        for (int i = 0; i< arTxtCampo.length; i++){
            arTxtCampo[i] = new TextField();
            arTxtCampo[i].setPromptText(arPromts[i]);
            vprincipal.getChildren().add(arTxtCampo[i]);
        }

        llenarForm();
        btnSave = new Button("Guardar");
        btnSave.setOnAction(event -> guardarEmp());
        vprincipal.getChildren().add(btnSave);
        escena = new Scene(vprincipal, 350, 250);
    }

    private void llenarForm() {
        arTxtCampo[0].setText(objEmp.getNom_empleado());
        arTxtCampo[1].setText(objEmp.getRfc());
        arTxtCampo[2].setText(objEmp.getSalario()+"");
        arTxtCampo[3].setText(objEmp.getTelefono());
        arTxtCampo[4].setText(objEmp.getDireccion());
    }

    private void guardarEmp() {
        objEmp.setNom_empleado(arTxtCampo[0].getText());
        objEmp.setRfc(arTxtCampo[1].getText());
        objEmp.setSalario(Float.parseFloat(arTxtCampo[2].getText()));
        objEmp.setTelefono(arTxtCampo[3].getText());
        objEmp.setDireccion(arTxtCampo[4].getText());

        if (objEmp.getId_emepleado() > 0) {//para que identifique que es lo que va hacer
            objEmp.actualizar();

        }else
            objEmp.insertar();
        tbvEmpleado.setItems(objEmp.consulta());
        tbvEmpleado.refresh();

        arTxtCampo[0].clear();
        arTxtCampo[1].clear();
        arTxtCampo[2].clear();
        arTxtCampo[3].clear();
        arTxtCampo[4].clear();
    }
}