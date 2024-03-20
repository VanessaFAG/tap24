package com.example.tap24.componetes;

import javafx.scene.control.ProgressBar;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class hilo extends Thread{

    private ProgressBar pgbCarril;
    public hilo(String name){
        //super(name);//el suoer manda a llamar al padre
        this.setName(name);
    }

    public void setPgbCarril(ProgressBar pgbCarril) {
        this.pgbCarril = pgbCarril;
    }

    @Override
    public void run() {
        super.run();
        double avance = 0;
        while (avance <= 1){
            this.getName();
            //System.out.println("Km "+i+" llego "+this.getName());
            avance += Math.random()/10;
            pgbCarril.setProgress(avance);//se va air cargando pulatinamente
            try {
                Thread.sleep((long) (Math.random()*3000));
            }catch (Exception e){

            }
        }
    }
}
