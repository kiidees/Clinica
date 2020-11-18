package modelo;

import BD.Conexion;
import encriptacion.Base64;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.VistaRegistro;

public class ModeloLogin {
    
    VistaRegistro vista = new VistaRegistro();
    ModeloRegistro modelo = new ModeloRegistro();

    public void Registro() throws ConnectException, ClassNotFoundException, SQLException{
        
        controlador.ControladorRegistro control = new controlador.ControladorRegistro(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
}
    
    private static String usuario;
    private String password;
    public boolean stad;

    //public Conexion conect = new Conexion().conectar();
    public Conexion conect = new Conexion();
    public Base64 base = new Base64();

    public Conexion getConect() {
        return conect;
    }

    public void setConect(Conexion conect) {
        this.conect = conect;
    }

    public static String getUsuario() {
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

    public boolean isStad() {
        return stad;
    }

    public void setStad(boolean stad) {
        this.stad = stad;
    }
    
    public void verificaUsuario() throws SQLException, Exception {
        boolean estado = false;
        boolean estadoUsuario = false;
        ResultSet resultados = conect.consultar("select * from usuarios where rfcusuario = '" + this.usuario + "' and estado = TRUE");
        ModeloUsuarios mostrarVista = new ModeloUsuarios();

        if (resultados.next()) {
            try {//comienza desencriptacion desde BD
                String passUnsure = base.decode(resultados.getString(4));
                System.out.println("contraseña desencriptada: " + passUnsure);
                estadoUsuario = resultados.getBoolean(6);
                //termina desencriptacion
                if (passUnsure.equals(this.password)) {
                    if (estadoUsuario == true) {
                        vista.setVisible(false);
                        System.out.println("Usuario Activo");
                        estado = true;
                        int tipoUsuario = Integer.parseInt(resultados.getString(2)); //acceso de usuario
                        switch (tipoUsuario) {
                            case 1:
                                /*aqui se implementa el nivel de acceso*/
                                mostrarVista.inicioAdministrador(resultados.getString(7));
                                System.out.println("Administrador");
                                break;
                            case 2:
                                /*aqui se implementa el nivel de acceso*/
                                mostrarVista.iniciaDoctor(resultados.getString(7));
                                System.out.println("Doctor");
                                break;
                            case 3:
                                /*aqui se implementa el nivel de acceso*/
                                mostrarVista.inicioAyudante(resultados.getString(7));
                                System.out.println("Ayudante de doctor");
                                break;
                            default:
                                throw new AssertionError();
                        }//Fin switch
                        JOptionPane.showMessageDialog(null, "Iniciaste sesion correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Parece que no eres un usuario activo \n Comunicate con Sistemas");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Verifica tu Usuario y Contraseña");
                }

                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifica tu Usuario y Contraseña");
            estado = false;
        }
        this.setStad(estado);
        //return estado;
    }

}
