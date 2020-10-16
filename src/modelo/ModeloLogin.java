package modelo;

import BD.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModeloLogin{
    
    private String usuario ;
    private String password ;
    
    Conexion conect = new Conexion();

    public Conexion getConect() {
        return conect;
    }

    public void setConect() {
        this.conect = conect.conectar();;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean verificaUsuario(String usuario, String password){
        this.usuario = usuario;
        this.password = password;
        boolean estado;
        ResultSet resultados = conect.consultar("select * from usuarios where rfcusuario = 'CANL941222HSP' and contraseña = '123456asdf'");
        //ResultSet resultados = conect.consultar("select * from usuarios where rfcusuario = '"+this.usuario+"' and contraseña = '"+this.password+"' ");
        if (resultados != null){
            try {
                    while (resultados.next()) {
                       JOptionPane.showMessageDialog(null, "Iniciaste sesion correctamente"); 
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            estado = true;}
        else {
            JOptionPane.showMessageDialog(null, "Verifica tu Usuario y Contraseña");
            
            estado = false;
        }
        return estado;
    }
    
}
