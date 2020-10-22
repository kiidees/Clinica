/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;

/**
 *
 * @author kyde(edyk)
 */
public class Conexion {
    
    private Connection conexion;
    private String usuario;
    private String contraseña;
    private String url = "jdbc:postgresql://localhost:5433/Clinica?user=postgres&password=root";

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
    /**
     * @param args the command line arguments
     */
    

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Conexion conectar() throws ConnectException, PSQLException, ClassNotFoundException, SQLException{
        try {
            Class.forName("org.postgresql.Driver");
            //String contrasenia = contraseña.toString();
            setConexion(DriverManager.getConnection(url));
            if (conexion != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, "Parece que no tienes conexion con el servidor \n"
                    + " Comunicate con Sistemas o asegurate de iniciar PostgresQL \n "+e.getMessage().substring(0,38));
            System.exit(0);
            //System.out.println("error: "+e.getMessage());
        }

        return this;
    }

    public ResultSet consultar(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultado;
    }

    public boolean ejecutar(String sql) {
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
