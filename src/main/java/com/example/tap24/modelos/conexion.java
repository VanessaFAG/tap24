package com.example.tap24.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    static private String DB = "taqueria";
    static private String usuario = "taquero";
    static private String password = "123";
    static public Connection  conexcion;
    public static void createConexion(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conexcion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/"+DB,usuario,password);
            System.out.println("Conexcion exitosa");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
