package DAO;

import javax.swing.*;
import java.sql.*;

public class ConnectionSQL {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rset = null;

    private String database = null;
    private String userDatabase = null;
    private String pass = null;
    private String urlDatabase = null;
    
    public ConnectionSQL()
    {
        checkDriver();
        database="watchstore";
        userDatabase="root";
        pass="";
        urlDatabase="localhost:3306";
        connect();

    }
    private void checkDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Can't find driver");
        }
    }

    private void connect() {
        try {
            String url = "jdbc:mysql://" + urlDatabase + "/" + database + "?useUnicode=true&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url, userDatabase, pass);
            stmt = conn.createStatement();
            System.out.println("\n Connect success");

        } catch (SQLException e) {
            System.err.println("Can't connect '" + database + "'");
            JOptionPane.showMessageDialog(null, "Cant connect'" + database + "'");
        }
    }
    public ResultSet sqlQuery(String qry) {
        if (checkConnect()) {
            try {
                rset = stmt.executeQuery(qry);
                System.out.println("Success Query! ");
                return rset;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Cant crawl data " + database+ "\n" + ex.getLocalizedMessage());
                return null;
            }
        }
        return null;
    }
    public boolean sqlUpdate(String qry) {
        if (checkConnect()) {
            try {
                stmt.executeUpdate(qry);
                System.out.println(" Success Update! " + qry);
                return true;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Cant write data" + database + "\n" + ex.getLocalizedMessage());
                return false;
            }
        }
        return false;
    }
    public boolean checkConnect() {
        if (conn == null || stmt == null) {
            JOptionPane.showMessageDialog(null, "Can't connect " + database );
            return false;
        }
        return true;
    }

    public void closeConnect() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            System.out.println("Close connect '" + database + "' successly.\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Can't close connect " + database + "\n" + ex.getLocalizedMessage());
        }
    }
}
