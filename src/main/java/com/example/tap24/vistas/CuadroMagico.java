package com.example.tap24.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CuadroMagico extends Stage {
    //variables
    private Scene escena;

    //constructor
    public CuadroMagico(){
        this.setTitle("Cuadro Magico");
        this.setScene( new Scene (new Button("Da click")));
        this.show();
    }

    //interfaz creacion
    private void crearUI (){
        escena = new Scene(new Button("Dadle, Dadle!"));
        //objetos anonimos no tienen nombre y no se va a poder llamar
    }
}