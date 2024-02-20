package com.example.tap24.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class memorama extends Stage {
    private Scene escena;
    private HBox pares, player1, player2, hboxContenedor;
    private VBox vboxcontenedor, players;
    private GridPane gpcartas;
    private Button btnrevolver;
    private TextField txtnoPares;

    public memorama(){
        CrearUI();
        this.setTitle("Intento de Interfaz");
        this.setScene(escena);
        this.show();
    }

    public void CrearUI(){
        txtnoPares = new TextField("3");
        gpcartas = new GridPane();
        vboxcontenedor = new VBox(gpcartas/*, pares*/);
        //players = new VBox(player1,player2);
        crearpares();
        hboxContenedor = new HBox(vboxcontenedor/*,players*/);
        escena = new Scene(hboxContenedor, 400, 500);
        //pares = new HBox(/*time*/ btnrevolver, txtnoPares);

    }

    private void crearpares() {
        String[] arimagen  = {"cerebro.jpg","pato.jpg"};
        Button[][] botoncarta = new Button[2][4];//esto depende de la cantidad de imagenes puestas
        ImageView imvCarta;
        int posx =0, posy =0, cont=0;
        for (int i =0; i < arimagen.length;){//se puede quitar el contador y manipularlo internamente
            posx = (int) (Math.random()*2);
            posy = (int) (Math.random()*4);
            if (botoncarta[posx][posy] == null) {
                botoncarta[posx][posy]= new Button();
                imvCarta = new ImageView(getClass().getResource("/imagenes/"+botoncarta[i]).toString());
                botoncarta[posx][posy].setGraphic(imvCarta);
                botoncarta[posx][posy].setPrefSize(60,110);
                cont++;
                gpcartas.add(botoncarta[posx][posy],posy,posx);
                if (cont == 2) {
                    i++;//cada que el contador llega a 2, hace un incremento para la sigiente imagen
                    cont = 0;
                }
            }
        }
    }
}
