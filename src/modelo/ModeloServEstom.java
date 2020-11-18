/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import BD.Conexion;
import controlador.ControladorExploracionFisica;
import controlador.ControladorLogin;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.VistaExploracionFisica;
import vista.VistaServEstom;

/**
 *
 * @author jklm2
 */
public class ModeloServEstom {
    private float svt;
    private float fc;
    private float fr;
    private float ta;
    private float glucosa;
    private float peso;
    private float altura;
    private String p1;
    private String p2;
    private String p3;
    private int idIngreso;
    Conexion modConf = ControladorLogin.obtenerConexion();
    private VistaServEstom vista;

    public float getSvt() {
        return svt;
    }

    public void setSvt(float svt) {
        this.svt = svt;
    }

    public float getFc() {
        return fc;
    }

    public void setFc(float fc) {
        this.fc = fc;
    }

    public float getFr() {
        return fr;
    }

    public void setFr(float fr) {
        this.fr = fr;
    }

    public float getTa() {
        return ta;
    }

    public void setTa(float ta) {
        this.ta = ta;
    }

    public float getGlucosa() {
        return glucosa;
    }

    public void setGlucosa(float glucosa) {
        this.glucosa = glucosa;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }
    
    public void confirmar() throws ConnectException, ClassNotFoundException, SQLException {
        ResultSet resultados = modConf.consultar("select id_ingresopac from ingreso_pacientes");

        try {
            while (resultados.next()) {
                idIngreso = resultados.getInt(1);
            }
            if (modConf.ejecutar("INSERT INTO servicioestomatologico (id_serv_estom, svt, fc, fr, ta, glucosa, peso, altura, pregunta_1, pregunta_2, pregunta_3, id_ingresopac) \n"
                    + "	VALUES (" + idIngreso + ", " + svt + ", " + fc + ", " + fr + ", " + ta + ", " + glucosa + ", " + peso + ", " + altura + ", '" + p1 + "', '" + p2 + "', '" + p3 + "', " + idIngreso + ")")) {
                JOptionPane.showMessageDialog(null, "¡Datos correctamente registrados!");
                ModeloExploracionFisica mdlexpfisica = new ModeloExploracionFisica();
                VistaExploracionFisica vstexpfisica = new VistaExploracionFisica();
                ControladorExploracionFisica ctrlexpfisica = new ControladorExploracionFisica(vstexpfisica, mdlexpfisica);
                ctrlexpfisica.iniciar();
                vista.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "¡Datos ya registrados!");
            }

        } catch (Exception e) {
        }

    }

    public void setVista(VistaServEstom vistaserv) {
        this.vista = vistaserv;
    }
}
