package com.example.tap24.modelos;

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

    }
    public void consulta(){}
}
