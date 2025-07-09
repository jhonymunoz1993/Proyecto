package com.jhony.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class proyect {

    public static void main(String[] args) {

        String usuario = "root";
        String clave = "9309";
        String url = "jdbc:mysql://localhost:3306/radio";
        Connection conexion;
        Statement statement;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
            statement = conexion.createStatement();

            // statement.executeUpdate("USE radio");

            statement.executeUpdate(
                    "INSERT INTO CLIENTES(ID_CLIENTES, CEDULA, TELEFONO, CORREO, EMPRESA, NOMBRE) VALUES('1', '1118301094', '6', '@jmo', 'papeleria', 'Jhony')");

            // statement.executeUpdate("UPDATE CITY SET NAME = 'peru' WHERE id = '4079'");

            // statement.executeUpdate("DELETE FROM CITY WHERE id = '4080'");

            rs = statement.executeQuery("SELECT * FROM CLIENTES");

            rs.next();

            do {
                System.out.println(rs.getInt("id_clientes") + " : " + rs.getString("nombre"));

            } while (rs.next());

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
