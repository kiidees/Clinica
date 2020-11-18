/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import modelo.ModeloServEstom;
import vista.VistaServEstom;

/**
 *
 * @author jklm2
 */
public class ControladorServEstom implements ActionListener{
    VistaServEstom vistaserv;
    ModeloServEstom modeloestom;

    public ControladorServEstom(VistaServEstom vistaserv, ModeloServEstom modeloestom) throws ConnectException, ClassNotFoundException, SQLException{
        this.vistaserv = vistaserv;
        this.modeloestom = modeloestom;
        this.vistaserv.btnSiguiente.addActionListener(this);
    }
    
    public void iniciar(){
        vistaserv.setTitle("Hesi-Re v1.0.0");
        vistaserv.setLocation(50, 0);
        vistaserv.setLocationRelativeTo(null);
        vistaserv.setSize(1280, 720);
        vistaserv.setResizable(false);
        vistaserv.setVisible(true);
        vistaserv.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vistaserv.btnSiguiente) {
            try {
                modeloestom.setAltura(Float.parseFloat(vistaserv.txtAltura.getText()));
                modeloestom.setFc(Float.parseFloat(vistaserv.txtFc.getText()));
                modeloestom.setFr(Float.parseFloat(vistaserv.txtFR.getText()));
                modeloestom.setGlucosa(Float.parseFloat(vistaserv.txtGlucosa.getText()));
                modeloestom.setPeso(Float.parseFloat(vistaserv.txtPeso.getText()));
                modeloestom.setSvt(Float.parseFloat(vistaserv.txtTemp.getText()));
                modeloestom.setTa(Float.parseFloat(vistaserv.txtTA.getText()));
                modeloestom.setP1(vistaserv.txtUltima.getText());
                modeloestom.setP2(vistaserv.txtRazon.getText());
                modeloestom.setP3(vistaserv.txtMtvoActual.getText());
                modeloestom.confirmar();
                modeloestom.setVista(vistaserv);
            } catch (ConnectException ex) {
                Logger.getLogger(ControladorServEstom.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorServEstom.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorServEstom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
