/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext { 
     protected Connection connection;
    public DBContext()
    {
        try {
            // Edit URL, username, password to authenticate with your MS SQL Server 
            //String url = "jdbc:sqlserver://localhost:1433;databaseName=Laptop";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FinalProject;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
       try {
            DBContext dBContext = new DBContext();
            
            if (dBContext.connection != null) {
                System.out.println("Success");
            } else {
                System.out.println("Fail");
            }
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
