package com.example.tap24.modelos;

import com.example.tap24.componetes.ButtonCell;
import com.example.tap24.modelos.empleadoDAO;
import com.example.tap24.vistas.empleadoFrom;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class empleadoTaqueria extends Stage {
    private Panel pnlPrincipal;
    private BorderPane bpPrincipal;
    private VBox vprincipal;
    private ToolBar toolMenu;
    private Scene escena;
    private Button btnAgrEmp;
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
        ImageView imVEmp = new ImageView(getClass().getResource("/imagenes/empleado.png").toString());
        imVEmp.setFitWidth(50);
        imVEmp.setFitHeight(50);
        btnAgrEmp = new Button();
        btnAgrEmp.setOnAction(event -> new empleadoFrom(tbvEmpleado, null));
        btnAgrEmp.setPrefSize(50,50);
        btnAgrEmp.setGraphic(imVEmp);
        toolMenu = new ToolBar(btnAgrEmp);

        createTable();
        bpPrincipal = new BorderPane();
        bpPrincipal.setTop(toolMenu);
        bpPrincipal.setCenter(tbvEmpleado);
        pnlPrincipal = new Panel("Taqueria");
        pnlPrincipal.getStyleClass().add("panel-primary");
        pnlPrincipal.setBody(bpPrincipal);
        escena = new Scene(pnlPrincipal, 600, 400);
        escena.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
    }

    private void createTable() {
        empleadoDAO objEmp = new empleadoDAO();
        tbvEmpleado = new TableView<empleadoDAO>();//que va a recibir

        TableColumn<empleadoDAO, String> tbcNomEmp = new TableColumn<>("Nombre");//se define el atributo
        tbcNomEmp.setCellValueFactory(new PropertyValueFactory<>("nom_empleado"));

        TableColumn<empleadoDAO, String> tbcrfcEmp = new TableColumn<>("RFC");
        tbcrfcEmp.setCellValueFactory(new PropertyValueFactory<>("rfc"));

        TableColumn<empleadoDAO, Float> tbcSueldoEmp = new TableColumn<>("Salario");
        tbcSueldoEmp.setCellValueFactory(new PropertyValueFactory<>("salario"));

        TableColumn<empleadoDAO, String> tbcTelefEmp = new TableColumn<>("Telefono");
        tbcTelefEmp.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        TableColumn<empleadoDAO, String> tbcDirecEmp = new TableColumn<>("Direccion");
        tbcDirecEmp.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        TableColumn<empleadoDAO, String> tbcActualizar = new TableColumn<>("Actualizar");
        tbcActualizar.setCellFactory(
                new Callback<TableColumn<empleadoDAO, String>, TableCell<empleadoDAO, String>>() {
                    @Override
                    public TableCell<empleadoDAO, String> call(TableColumn<empleadoDAO, String> param) {
                        return new ButtonCell(1);
                    }
                }
        );
        TableColumn<empleadoDAO, String> tbcEliminar = new TableColumn<>("Eliminar");
        tbcEliminar.setCellFactory(//son elementos visuales
                new Callback<TableColumn<empleadoDAO, String>, TableCell<empleadoDAO, String>>() {
                    @Override
                    public TableCell<empleadoDAO, String> call(TableColumn<empleadoDAO, String> empleadoDAOStringTableColumn) {
                        return new ButtonCell(2);
                    }
                }
        );
        tbvEmpleado.getColumns().addAll(tbcNomEmp,tbcrfcEmp,tbcSueldoEmp,tbcTelefEmp,tbcDirecEmp,tbcActualizar,tbcEliminar);
        tbvEmpleado.setItems(objEmp.consulta());
    }
}
