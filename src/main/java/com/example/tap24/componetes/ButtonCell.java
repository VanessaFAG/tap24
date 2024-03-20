package com.example.tap24.componetes;

import com.example.tap24.modelos.empleadoDAO;
import com.example.tap24.vistas.empleadoFrom;
import javafx.scene.control.*;

import java.util.Optional;

public class ButtonCell extends TableCell<empleadoDAO, String> {//clase de la tabla y el tipo de item contenido en la celda
    Button btnCelda;
    int opc;
    empleadoDAO objEmp;
    public ButtonCell (int opc){
        this.opc = opc;
        String txtButton = (opc == 1 ) ? "Actualizar" : "Eliminar";
        btnCelda = new Button(txtButton);
        btnCelda.setOnAction(event -> accionBoton(opc));
    }

    private void accionBoton(int opc) {
        TableView<empleadoDAO> tvEmpleado = ButtonCell.this.getTableView();
        objEmp = tvEmpleado.getItems().get(ButtonCell.this.getIndex());//objeto del emepleado al que hace referencia de registro
        if (opc == 1) { //edita
            new empleadoFrom(tvEmpleado, objEmp);
        }else { //elimina
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mesnaje del Sistema.");
            alert.setHeaderText("Confirmación de eliminacion de usuario.");
            alert.setContentText("¿Estas seguro de eliminar al usuario: "+objEmp.getNom_empleado()+"?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                objEmp.eliminar();
                tvEmpleado.setItems(objEmp.consulta());
                tvEmpleado.refresh();
            }
        }
    }

    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item,empty);
        if (!empty){
            this.setGraphic(btnCelda);
        }
    }
}
