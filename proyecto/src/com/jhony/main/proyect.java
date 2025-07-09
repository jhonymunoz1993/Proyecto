package com.jhony.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

//codigo reciclado 
public class proyect {

    public static void main(String[] args) {
        // a continuacio se cambio en la url que decia word por radio
        // los otros datos de ingreso a la conexion siguen iguales
        String usuario = "root";
        String clave = "9309";
        String url = "jdbc:mysql://localhost:3306/radio";
        // en el paso seguido se realiza la conexion con el codigo Connetion Statement y
        // ResultSet
        Connection conexion;
        Statement statement;
        ResultSet rs;
        // se crea una correccion rapida con un try catch para evitar errores
        try {
            // luego se usa la clase forName para realizar la ejecucion
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            // paso seguido se accede a la base de datos
            conexion = DriverManager.getConnection(url, usuario, clave);
            statement = conexion.createStatement();

            // para realizar cambios en la base de datos en la cual ya se ingreso
            // se usa codigo sql despues de el comando statement.executeUpdate

            statement.executeUpdate(
                    "INSERT INTO CLIENTES(ID_CLIENTES, CEDULA, TELEFONO, CORREO, EMPRESA, NOMBRE) VALUES('1', '1118301094', '6', '@jmo', 'papeleria', 'Jhony')");
            // con los codigos sql que continuacion se pueden realizar UPDATE
            // actualizaciones, DELETE borrar
            // statement.executeUpdate("UPDATE CLIENTES SET NOMBRE = 'JHONY' WHERE
            // id_clientes = '1'");

            // statement.executeUpdate("DELETE FROM CLIENTES WHERE id_clientes = '1'");
            // con rs se hace llamado a la funcion ResultSet para obtener resultados y el
            // comando sql
            // nos da el resultado de la orden sql anterior
            rs = statement.executeQuery("SELECT * FROM CLIENTES");

            rs.next();
            // el siguiente codigo nos imprime el id_clientes y el campo nombre
            do {
                System.out.println(rs.getInt("id_clientes") + " : " + rs.getString("nombre"));

            } while (rs.next());

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
