package com.example.tap24.vistas;

import com.example.tap24.componetes.hilo;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class pista extends Stage {
    ProgressBar[] proBar = new ProgressBar[3];
    Label[] corredores = new Label[3];
    private GridPane gdPista;
    private Scene escena;
    private String[] strCorredores ={"Yuno","Hulieta","VF.piñata.huellita"};
    private hilo[] thrCorredores = new hilo[3];
    public pista(){
        crearUI();
        this.setTitle("Pista de Atletismo");
        this.setScene(escena);
        this.show();
    }

    private void crearUI() {
        gdPista = new GridPane();
        for (int i = 0; i < strCorredores.length; i++){
         corredores[i] = new Label(strCorredores[i]);
         proBar[i] = new ProgressBar(0);
         gdPista.add(corredores[i],0,i);
         gdPista.add(proBar[i],1,i);
         thrCorredores[i] = new hilo(strCorredores[i]);
         thrCorredores[i].setPgbCarril(proBar[i]);
         thrCorredores[i].start();
        }
        escena = new Scene(gdPista,200,200);
    }
}
