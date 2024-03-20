package com.example.tap24.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class empleadoDAO {
    private int id_emepleado;
    private String nom_empleado;
    private String rfc;
    private float salario;
    private String telefono;
    private String direccion;

    public int getId_emepleado() {
        return id_emepleado;
    }
    public void setId_emepleado(int id_emepleado) {
        this.id_emepleado = id_emepleado;
    }

    public String getNom_empleado() {
        return nom_empleado;
    }
    public void setNom_empleado(String nom_empleado) {
        this.nom_empleado = nom_empleado;
    }

    public String getRfc() {
        return rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
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