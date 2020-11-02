package modelo;

import BD.Conexion;
import encriptacion.Base64;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controlador.ControladorRegistro;
import vista.VistaRegistro;

public class ModeloRegistro {
    
    private String usuario;
    private String password;
    private String passconfirmation;
    private String apellidos;
    private String RFC;
    private String direccion;
    private boolean estado;
    private int acceso;
    private int telefono;
    
    public Conexion conect = new Conexion();
    Base64 base = new Base64();
    
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getAcceso() {
        return acceso;
    }

    public void setAcceso(int Acceso) {
        this.acceso = Acceso;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Conexion getConect() {
        return conect;
    }

    public void setConect(Conexion conect) {
        this.conect = conect;
    }

    public Base64 getBase() {
        return base;
    }

    public void setBase(Base64 base) {
        this.base = base;
    }
    
    public String getPassconfirmation() {
        return passconfirmation;
    }

    public void setPassconfirmation(String passconfirmation) {
        this.passconfirmation = passconfirmation;
    }
    
    
    public void registroUsuario() throws SQLException{
        ResultSet ingreso = conect.insertar("insert into usuarios (varchar rfcusuario,"
                + "int acceso,varchar apellidousuario, varchar contraseña, varchar direccionusuario,"
                + "boolean estado, varchar nombreusuario, int telefonousuario"
                + ") VALUES ('"+ this.RFC + "'," + this.acceso + ",'" + this.apellidos + "','" + this.password 
                + "','" + this.direccion + "'," + this.estado + "','" + this.usuario + "'," + this.telefono + ")");
        
        ResultSet resultados = conect.consultar("select * from usuarios where rfcusuario = '" + this.usuario + "'");
        
        if (ingreso.next()){
            try {
                if((this.usuario == null)||(this.RFC == null)||(this.apellidos == null)||(this.password == null)||(this.passconfirmation == null)||(this.direccion == null)){
                    if(this.password != this.passconfirmation){
                        JOptionPane.showMessageDialog(null, "Datos Incorrectos verifique nuevamente");
                    }
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos verifique nuevamente");
                }
                JOptionPane.showMessageDialog(null, "Registro Correcto");
            } catch (Exception e) {
                e.printStackTrace();
                
            }
        
        }
    
    }
    
}
