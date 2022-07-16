
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author natye
 */
public class Persistencia {
    
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;   
    //private ResultSetMetaData rsm;
    
    public String servidor, basededatos,usuario, clave;
    
    public Connection conectarse() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");     
            servidor= "localhost:3306/";
            basededatos = "cacproyecto2022";
            usuario = "root";
            clave="";
            cn =  DriverManager.getConnection("jdbc:mysql://" + servidor + basededatos + "?autoReconnect=true&useSSL=false", usuario, clave);  
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
            return cn;
    }

    
    public ResultSet consultaSQL(String busqueda){

        try {
            ps =  conectarse().prepareStatement(busqueda);        
            rs = ps.executeQuery();
           // rsm = rs.getMetaData();        
        
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
}
