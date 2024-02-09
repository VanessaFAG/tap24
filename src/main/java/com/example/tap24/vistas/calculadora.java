package com.example.tap24.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class calculadora extends Stage {
    private Scene escena;
    private VBox vContenedor;
    private GridPane gdpTeclado;
    private TextField txtPantalla;
    private Button[][] arBotones = new Button[4][4];
    private char[] arEtiquetas = {'7', '8', '9', '/',
                                  '4','5','6','*',
                                  '1','2','3','+',
                                  '-','0','.','='};
    public calculadora(){
        crearUI();
        this.setTitle("Mi primer trauma");
        this.setScene(escena);
        this.show();
    }

    private void crearUI() {
        txtPantalla = new TextField("0");//valor inicial de la calculadora
        gdpTeclado = new GridPane();
        crearTeclado(); //el gdpteclado se lleno por este metodo
        vContenedor = new VBox(txtPantalla, gdpTeclado);
        vContenedor.setSpacing(5);
        escena = new Scene(vContenedor, 200, 200);
    }

    private void crearTeclado() {
        int pos = 0;
        char simbolo;  //creado para quitar un error en el event
        for (int i =0; i < 4; i++){
            for (int j= 0; j < 4; j++){
                arBotones[i][j] = new Button(arEtiquetas[pos] + "");
                arBotones[i][j].setPrefSize(50,50);//tamaño del arreglo de botones
                int finalPos = pos; //pero le vale cheto y creamos un final
                arBotones[i][j].setOnAction(event -> setValue(arEtiquetas [finalPos]));
                gdpTeclado.add(arBotones[i][j],j,i);
                pos++;
            }
        }

    }

    private void setValue(char simbolo) {
        txtPantalla.appendText((simbolo + ""));
    }

}
