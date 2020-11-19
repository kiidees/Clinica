package modelo;

import BD.Conexion;
import controlador.ControladorLogin;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;
import vista.VistaExamenClinicoEst;

public class ModeloExamenClinicoEst {
    
    private String labios;
    private String mejillas;
    private String lengua;
    private String carrillos;
    private String pisoDeBoca;
    private String paladarBlando;
    private String paladarDuro;
    private String observaciones;
    private int idIngreso;
    private VistaExamenClinicoEst vista;
    Conexion modConf = ControladorLogin.obtenerConexion();

    public VistaExamenClinicoEst getVista() {
        return vista;
    }

    public void setVista(VistaExamenClinicoEst vista) {
        this.vista = vista;
    }
    
    public String getLabios() {
        return labios;
    }

    public void setLabios(String labios) {
        this.labios = labios;
    }

    public String getMejillas() {
        return mejillas;
    }

    public void setMejillas(String mejillas) {
        this.mejillas = mejillas;
    }

    public String getLengua() {
        return lengua;
    }

    public void setLengua(String lengua) {
        this.lengua = lengua;
    }

    public String getCarrillos() {
        return carrillos;
    }

    public void setCarrillos(String carrillos) {
        this.carrillos = carrillos;
    }

    public String getPisoDeBoca() {
        return pisoDeBoca;
    }

    public void setPisoDeBoca(String pisoDeBoca) {
        this.pisoDeBoca = pisoDeBoca;
    }

    public String getPaladarBlando() {
        return paladarBlando;
    }

    public void setPaladarBlando(String paladarBlando) {
        this.paladarBlando = paladarBlando;
    }

    public String getPaladarDuro() {
        return paladarDuro;
    }

    public void setPaladarDuro(String paladarDuro) {
        this.paladarDuro = paladarDuro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public void registroExamenClinicoEst() throws SQLException, ConnectException, PSQLException, ClassNotFoundException {
        
        ResultSet resultados = modConf.consultar("select id_ingresopac from ingreso_pacientes");
        try {
             while (resultados.next()) {
                idIngreso = resultados.getInt(1);
            }
            if (modConf.ejecutar("INSERT INTO \"Examen_Clinico_Estomatologico\" (id_examen_clinico, \"Labios\", \"Mejillas\", \"Lengua\", \"Carrillos\", \"PisoDeBoca\", \"PaladarBlando\", \"PaladarDuro\", \"Observaciones\", id_ingresopac) \n" +
"	VALUES ("+idIngreso+", '"+this.labios+"', '"+this.mejillas+"', '"+this.lengua+"', '"+this.carrillos+"', '"+this.pisoDeBoca+"', '"+this.paladarBlando+"', '"+this.paladarDuro+"', '"+this.observaciones+"', "+idIngreso+")")) {
                JOptionPane.showMessageDialog(null, "¡Datos correctamente registrados!");
                this.getVista().setVisible(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Verifica los datos introducidos!" + e.getMessage());
        }

    }
    
}
