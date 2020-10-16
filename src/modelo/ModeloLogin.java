package modelo;

import BD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModeloLogin{
    
    private String usuario ;
    private String password ;
    
    public Conexion conect = new Conexion().conectar();

    public Conexion getConect() {
        return conect;
    }

    public void setConect(Conexion conect) {
        this.conect = conect;
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
    
    public boolean verificaUsuario() throws SQLException {
        boolean estado = false;

        //ResultSet resultados = conect.consultar("select * from usuarios where rfcusuario = 'CANL941222HSP' and contraseña = '123456asdf'");
        ResultSet resultados = conect.consultar("select * from usuarios where rfcusuario = '" + this.usuario + "' and contraseña = '" + this.password + "' and estado = TRUE");
        
        if (resultados.next()) {
            try {
                JOptionPane.showMessageDialog(null, "Iniciaste sesion correctamente");
                int tipoUsuario = Integer.parseInt(resultados.getString(2)); //acceso de usuario
                switch (tipoUsuario) {
                    case 1: /*aqui se implementa el nivel de acceso*/ System.out.println("Administrador");break;
                    case 2: /*aqui se implementa el nivel de acceso*/ System.out.println("Doctor");break;
                    case 3: /*aqui se implementa el nivel de acceso*/ System.out.println("Ayudante de doctor");break;
                    default: 
                        throw new AssertionError();
                }
                estado=true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifica tu Usuario y Contraseña");
            estado=false;
        }
        if (estado==true) {
            System.out.println("Usuario Activo");
        }else System.out.println("Usuario Inactivo");
        return estado;
    }

}
