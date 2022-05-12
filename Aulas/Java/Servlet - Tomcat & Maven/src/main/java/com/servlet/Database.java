package com.servlet;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {
    private java.sql.Connection conn;

    Database(String uri, String driver) throws SQLException, ClassNotFoundException {
        try {
            Class.forName(driver);

            this.conn = DriverManager.getConnection(uri);
        } 
        catch(SQLException e) {
            throw e;
        }
        catch (ClassNotFoundException e) {
            throw new SQLException("SQL Exception: Não foi possível encontrar o driver " + driver);
        }  
    }

    public Boolean validaUsuario(String user, String pass) throws SQLException {

        String query = "SELECT * FROM conta WHERE usuario=? AND senha=?";

        try {
            PreparedStatement pst = this.conn.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, pass);

            var result = pst.executeQuery();

            if(result.next()) {
                return true;
            }

        } catch (SQLException e) {
            throw e;
        }

        return false;
    }
}
