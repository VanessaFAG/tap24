package com.example.tap24.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class empleadoDAO {
    int id_emepleado;
    String nom_empleado, direccion, rfc, telefono;
    float salario;
    public void insertar(){
        String query = "insert into empleado(nom_empleado,rfc,salario,telefono,direccion) " +
        "values('"+nom_empleado+"','"+rfc+"',"+salario+",'"+telefono+"','"+direccion+"')";
        try {
            Statement statement = conexion.conexcion.createStatement();//sentencia para poder ejecutar
            statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void actualizar(){
        String query = "update empleado set nom_empleado='"+nom_empleado+"'," +
                "rfc='"+rfc+"', salario="+salario+", telefono='"+telefono+"', direccion ='"+direccion+"'" +
                "where id_empleado="+id_emepleado;
        try {
            Statement statement = conexion.conexcion.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void eliminar(){
        String query = "delete from empleado where id_empleado="+id_emepleado;
        try {
            Statement statement = conexion.conexcion.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList<empleadoDAO> consulta(){
       ObservableList<empleadoDAO> listaEmp = FXCollections.observableArrayList();
       String query = "select * from empleado";
       try {
           empleadoDAO objEmp;
           Statement statement = conexion.conexcion.createStatement();
           ResultSet resultSet = statement.executeQuery(query);
           while (resultSet.next()){// regresa un booleano por si si lo acepto elcambio de lugar
               objEmp = new empleadoDAO();
               objEmp.id_emepleado = resultSet.getInt("id_empleado");
               objEmp.nom_empleado =resultSet.getString("nom_empleado");
               objEmp.rfc=resultSet.getString("rfc");
               objEmp.salario=resultSet.getFloat("salario");
               objEmp.telefono = resultSet.getString("telefono");
               objEmp.direccion=resultSet.getString("direccion");
               listaEmp.add(objEmp);
           }
       }catch (Exception e){
           e.printStackTrace();
       }

       return listaEmp;
    }
}