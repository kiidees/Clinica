package modelo;

import BD.Conexion;
import controlador.ControladorLogin;
import encriptacion.Base64;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;
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
    private long telefono;
    
    Base64 base = new Base64();
    public Conexion conect = new Conexion();
    
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
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
    
    public void registroUsuario() throws SQLException, ConnectException, PSQLException, ClassNotFoundException {
        //Conexion modConf = new ModeloLogin().getConect().conectar();
        //Conexion modConf = new ModeloLogin().getConect();
        Conexion modConf = ControladorLogin.obtenerConexion();
/*        ResultSet Registro = conect.insertar("insert into usuarios ( rfcusuario,"
                            + " acceso,apellidousuario, \"contraseña\",direccionusuario,"
                            + " estado,  nombreusuario,  telefonousuario )"
                            + " VALUES ('" + this.RFC + "', " + this.acceso + " ,'" + this.apellidos + "','" + base.encode(this.password)
                            + "','" + this.direccion + "'," + this.estado + ",'" + this.usuario + "', " + this.telefono+ ")");*/
        
        if (this.password.equals(this.passconfirmation)) {
            if (this.acceso > 0 && this.acceso < 4) {
                try {
                    if (modConf.ejecutar("insert into usuarios ( rfcusuario,"
                            + " acceso,apellidousuario, \"contraseña\",direccionusuario,"
                            + " estado,  nombreusuario,  telefonousuario"
                            + ") VALUES ('" + this.RFC + "'," + this.acceso + ",'" + this.apellidos + "','" + base.encode(this.password)
                            + "','" + this.direccion + "'," + this.estado + ",'" + this.usuario + "'," + this.telefono + ")")) {
                        JOptionPane.showMessageDialog(null, "¡Datos correctamente registrados!");
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Datos ya registrados!");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡Verifica tus datos!"+e.getMessage());
                }
            }
            else JOptionPane.showMessageDialog(null, "¡Verifica el nivel de acceso!");
        }
        else JOptionPane.showMessageDialog(null, "¡Contraseña no coincide!");
    }

}
