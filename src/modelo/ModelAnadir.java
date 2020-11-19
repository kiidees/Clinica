/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import BD.Conexion;
import controlador.ControladorLogin;
import controlador.ControladorServEstom;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;
import vista.VistaAnadir;
import vista.VistaServEstom;

/**
 *
 * @author jklm2
 */
public class ModelAnadir {

    private String rfcPaciente;
    private String nombrePaciente;
    private String apellidosPaciente;
    private String domicilioPaciente;
    private long telefonoPaciente;
    private String rfcDoctor;
    private VistaAnadir vistaAna;
    Conexion modConf = ControladorLogin.obtenerConexion();
    String doctor = "";
    
    public VistaAnadir getVistaAna() {
        return vistaAna;
    }

    public void setVistaAna(VistaAnadir vistaAna) {
        this.vistaAna = vistaAna;
    }

    public String getRfcPaciente() {
        return rfcPaciente;
    }

    public void setRfcPaciente(String rfcPaciente) {
        this.rfcPaciente = rfcPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public String getDomicilioPaciente() {
        return domicilioPaciente;
    }

    public void setDomicilioPaciente(String domicilioPaciente) {
        this.domicilioPaciente = domicilioPaciente;
    }

    public long getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(long telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public String getRfcDoctor() {
        return rfcDoctor;
    }

    public void setRfcDoctor(String rfcDoctor) {
        this.rfcDoctor = rfcDoctor;
    }

    public void buscarPaciente() throws SQLException, ConnectException, PSQLException, ClassNotFoundException {
        doctor = ModeloLogin.getUsuario();
        ResultSet resultados = modConf.consultar("SELECT * FROM \"public\".PACIENTES where rfc_paciente = '" + this.getRfcPaciente() + "' and "
                + "rfcusuario = '" + doctor + "'");

        if (resultados.next()) {
            try {
                if (resultados.getString(1).equals(this.getRfcPaciente()) && resultados.getString(6).equals(doctor)) {
                    JOptionPane.showMessageDialog(null, "Se encontro el paciente");
                    this.getVistaAna().panelDatos.setVisible(true);
                    this.getVistaAna().btnBuscar.setEnabled(true);
                    this.getVistaAna().btnModificar.setEnabled(true);
                    this.getVistaAna().btnSiguiente.setEnabled(true);
                    this.getVistaAna().btnGuardar.setEnabled(false);
                    this.getVistaAna().txtRFCusuario.setEnabled(false);
                    this.getVistaAna().txtApellidos.setText(resultados.getString(3));
                    this.getVistaAna().txtNombre.setText(resultados.getString(2));
                    this.getVistaAna().txtDireccion.setText(resultados.getString(4));
                    this.getVistaAna().txtTelefono.setText(resultados.getString(5));
                    this.getVistaAna().txtRFCusuario.setText(resultados.getString(1));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro paciente");
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un error o no se encontro el rfc del paciente");
            this.getVistaAna().panelDatos.setVisible(true);
                    this.getVistaAna().txtRFCusuario.setEnabled(true);
            this.getVistaAna().btnGuardar.setEnabled(true);
            this.getVistaAna().btnModificar.setEnabled(false);
                    this.getVistaAna().btnGuardar.setEnabled(true);
        }
    }
    
    public void siguiente() throws SQLException, ConnectException, PSQLException, ClassNotFoundException {

        Calendar c1 = Calendar.getInstance();
        System.out.println(c1.getTimeInMillis());
        Timestamp ts = new Timestamp(c1.getTimeInMillis());
        //c1.getTime();
        System.out.println(ts);
        int idIngreso = 0;

        ResultSet resultados = modConf.consultar("select id_ingresopac from ingreso_pacientes");

        try {
            while (resultados.next()) {
                idIngreso = resultados.getInt(1) + 1;
            }
            if (modConf.ejecutar("INSERT INTO ingreso_pacientes (id_ingresopac, rfc_paciente, fecha_ingreso) \n"
                    + "	VALUES (" + idIngreso + ", '" + this.getRfcPaciente() + "', '" + ts + "')")) {
                JOptionPane.showMessageDialog(null, "¡Datos correctamente registrados!");
                this.vistaAna.setVisible(false);
                ModeloServEstom modservestom = new ModeloServEstom();
                VistaServEstom vistaservestom = new VistaServEstom();
                ControladorServEstom ctrlsrv = new ControladorServEstom(vistaservestom, modservestom);
                ctrlsrv.iniciar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Datos ya registrados!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Verifica tus datos!" + e.getMessage());
        }
    }

    public void actualizar() throws SQLException, ConnectException, PSQLException, ClassNotFoundException {

        try {
            /*if (modConf.ejecutar("UPDATE pacientes SET "
                    + "nombrepaciente = '"+this.nombrePaciente+"' "
                    + "apellidospaciente = '"+this.apellidosPaciente+"' "
                    + "domiciliopaciente = '"+this.domicilioPaciente+"' "
                    + "telefono = "+this.telefonoPaciente+" "
                    + "WHERE rfc_paciente = '"+this.rfcPaciente+"'")) */
            if (modConf.ejecutar("UPDATE pacientes SET nombrepaciente = '" + this.nombrePaciente + "', \n"
                    + "apellidospaciente = '" + this.apellidosPaciente + "', \n"
                    + "domiciliopaciente = '" + this.domicilioPaciente + "', \n"
                    + "telefono = " + this.telefonoPaciente + " \n"
                    + "WHERE rfc_paciente = '" + this.rfcPaciente + "'")) {
                JOptionPane.showMessageDialog(null, "¡Datos correctamente actualizados!");
                this.vistaAna.btnGuardar.setEnabled(false);
                this.vistaAna.btnBuscar.setEnabled(false);
                this.vistaAna.btnModificar.setEnabled(false);
                this.vistaAna.btnSiguiente.setEnabled(true);
            }
        } catch (Exception e) {
        }

    }

    public void guardar() throws SQLException, ConnectException, PSQLException, ClassNotFoundException {
        try {
            if (modConf.ejecutar("INSERT INTO pacientes (rfc_paciente, nombrepaciente, apellidospaciente, domiciliopaciente, telefono, rfcusuario) \n" +
"	VALUES ('"+this.rfcPaciente+"', '"+this.nombrePaciente+"', '"+this.apellidosPaciente+"', '"+this.domicilioPaciente+"', "+this.telefonoPaciente+", '"+doctor+"')")) {
                JOptionPane.showMessageDialog(null, "¡Datos correctamente registrados!");
                this.vistaAna.btnGuardar.setEnabled(false);
                this.vistaAna.btnBuscar.setEnabled(false);
                this.vistaAna.btnModificar.setEnabled(false);
                this.vistaAna.btnSiguiente.setEnabled(true);
            }
            else JOptionPane.showMessageDialog(null, "¡Verifica los datos de tu paciente!");
        } catch (Exception e) {
        }

    }
}
