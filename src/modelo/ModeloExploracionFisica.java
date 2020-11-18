package modelo;

import BD.Conexion;
import controlador.ControladorLogin;
import java.net.ConnectException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;

public class ModeloExploracionFisica {
    
    private String cara;
    private String cuello;
    private String cabeza;
    private String aperienciaFisica;
    private String estadoActual;
    private String observaciones;
    
    public Conexion conect = new Conexion();

    public String getCara() {
        return cara;
    }

    public void setCara(String cara) {
        this.cara = cara;
    }

    public String getCuello() {
        return cuello;
    }

    public void setCuello(String cuello) {
        this.cuello = cuello;
    }

    public String getCabeza() {
        return cabeza;
    }

    public void setCabeza(String cabeza) {
        this.cabeza = cabeza;
    }

    public String getAperienciaFisica() {
        return aperienciaFisica;
    }

    public void setAperienciaFisica(String aperienciaFisica) {
        this.aperienciaFisica = aperienciaFisica;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public void registroExploracionFisica() throws SQLException, ConnectException, PSQLException, ClassNotFoundException {
        Conexion modConf = ControladorLogin.obtenerConexion();

        try {
            if (modConf.ejecutar("INSERT INTO exploracion_fisica (\"Cara\", \"Cuello\", \"Cabeza\", \"AparienciaFisica\", \"EstadoActual\", \"Observaciones\") \n"
                    + "VALUES ('"+ this.cara + "', '" + this.cuello +"', '"+ this.cabeza +"', '" + this.aperienciaFisica + "', '" + this.estadoActual + "', '" + this.observaciones + "')")) {
                JOptionPane.showMessageDialog(null, "¡Datos correctamente registrados!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Verifica los datos introducidos!" + e.getMessage());
        }

    }
    
}
