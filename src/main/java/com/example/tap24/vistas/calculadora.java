package com.example.tap24.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class calculadora extends Stage {
    private Scene escena;
    private VBox vContenedor;
    private GridPane gdpTeclado;
    private TextField txtPantalla;
    private Button[][] arBotones = new Button[4][4];
    private Button btnIgualdad;
    private final String[] arOperador =
            {"7","8","9","<-",
             "4","5","6","+",
             "1","2","3","-",
             ".","0","/","*"};
    private double num1=0.0, num2=0.0;
    private String operador ="", numero="";
    public calculadora(){
        crearUI();
        this.setTitle("C. Basica");
        this.setScene(escena);
        this.show();
    }

    private void crearUI() {
        txtPantalla = new TextField("0");//valor inicial de la calculadora
        txtPantalla.setEditable(false);
        txtPantalla.setMaxWidth(Double.MAX_VALUE);
        gdpTeclado = new GridPane();
        crearTeclado(); //el gdpteclado se lleno por este metodo
        vContenedor = new VBox();
        vContenedor.getChildren().addAll(txtPantalla,gdpTeclado,btnIgualdad);
        escena = new Scene(vContenedor, 240, 300);
        escena.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/estilos/calculadora.css").toExternalForm()));
        this.setResizable(false);
    }

    private void crearTeclado() {
        int pos = 0;
        for (int i =0; i < 4; i++){
            for (int j= 0; j < 4; j++){
                arBotones[i][j] = new Button(arOperador[pos]);
                arBotones[i][j].setPrefSize(60, 60);//tamaño del arreglo de botones
                int finalPos = pos;
                arBotones[i][j].setOnAction(e -> operadores(arOperador[finalPos]));
                gdpTeclado.add(arBotones[i][j],j,i);

                if (arOperador[pos].matches("[/+*.-]")) {
                    arBotones[i][j].getStyleClass().add("operador");
                }else
                if (arOperador[pos].equals("<-")) {
                    arBotones[i][j].getStyleClass().add("borrar");
                }else
                if (arOperador[pos].matches("[0-9]")){
                    arBotones[i][j].getStyleClass().add("no");
                }
                pos++;
            }
        }
        btnIgualdad = new Button("=");
        btnIgualdad.setMaxWidth(getMaxWidth());
        btnIgualdad.setOnAction(e -> operadores("="));
        btnIgualdad.getStyleClass().add("igual");
    }
    public void operadores(String txtOperador){
        if (txtOperador.matches("[0-9.]")){
            String texto = txtPantalla.getText();
            if (texto.equals("Math Error") || texto.equals("Syntax Error")){
                clean();
            }else {
                veriOperacion(txtOperador);
            }
        }else
            if (txtOperador.equals("=")){
                if (!numero.isEmpty() && operador.isEmpty()) {
                    double resultado = Double.parseDouble(numero);
                    setResultado(resultado);
                    numero = Double.toString(resultado);
            }else
                if (!numero.isEmpty() && !numero.equals(".")){
                num2 = Double.parseDouble(numero);
                double resultado = doOperacion();
                numero = Double.toString(resultado);
                operador = "";
            }else{
                    txtPantalla.setText("Syntax Error");
                }
        }else
            if (txtOperador.matches("[/+*-]")) {
                if (!numero.isEmpty() && !operador.isEmpty()) {
                    double resultado = doOperacion();
                    setResultado(resultado);
                    numero = Double.toString(resultado);
                }
                operador = txtOperador;
                num1 = Double.parseDouble(numero);
                numero = "";
        }else if (txtOperador.equals("<-")){
                borrar();
        }
    }

    private void veriOperacion(String txtOperador){
        if (txtOperador.equals(".")){
            if (!numero.contains(".")){
                numero += txtOperador;
                txtPantalla.setText(numero);
            }else{
                txtPantalla.setText("Syntax Error");
            }
        }else {
            numero += txtOperador;
            txtPantalla.setText(numero);
        }
    }
    private void borrar() {
        if (!numero.isEmpty()) {
            numero= numero.substring(0, numero.length() - 1);
            txtPantalla.setText(numero);
        }
    }
    private double doOperacion(){
        double resultado = 0.0;
        if (operador.equals("+")){
            resultado = num1 + num2;
        }
        if (operador.equals("-")){
            resultado = num1 - num2;
        }
        if (operador.equals("*")){
            resultado = num1 * num2;
        }
        if (operador.equals("/") && num2 != 0){
            resultado = num1 / num2;
        } else if (operador.equals("/") && num2 == 0) {
            resultado = Double.NaN;
        } else if (operador.equals("/") && operador.equals(".")) {
            resultado = Double.NaN;
        }
        return resultado;
    }
    private void setResultado(double resultado){
        if (Double.isNaN(resultado)){
            txtPantalla.setText("Math Error");
        } else {
         txtPantalla.setText(Double.toString(resultado));
         numero = Double.toString(resultado);
         operador = "";
        }
    }
    private void clean() {
        numero ="";
        num1 =0.0;
        num2 =0.0;
        operador ="";
        txtPantalla.setText("");
    }

}