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
import modelo.ModeloAntPat;
import vista.VistaAntPatol;
/**
 *
 * @author jklm2
 */
public class ControladorAntPat implements ActionListener {
    private VistaAntPatol vistaant;
    private ModeloAntPat modantpat;

    public ControladorAntPat(VistaAntPatol vistaant, ModeloAntPat modantpat) throws ConnectException, ClassNotFoundException, SQLException{
        this.vistaant = vistaant;
        this.modantpat = modantpat;
        this.vistaant.btnSiguiente.addActionListener(this);
    }
    
    public void iniciar(){
        vistaant.setTitle("Hesi-Re v1.0.0");
        vistaant.setLocationRelativeTo(null);
        vistaant.setResizable(false);
        vistaant.setVisible(true);
        vistaant.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());
        modantpat.setVistaant(vistaant);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vistaant.btnSiguiente) {
            modantpat.setObserv(vistaant.txtObservaciones.getText());
            modantpat.setObserv2(vistaant.txtProblema.getText());
            modantpat.setP1(vistaant.jRadioButton1.isSelected());
            modantpat.setP2(vistaant.jRadioButton2.isSelected());
            modantpat.setP3(vistaant.jRadioButton3.isSelected());
            modantpat.setP4(vistaant.jRadioButton4.isSelected());
            modantpat.setP5(vistaant.jRadioButton5.isSelected());
            modantpat.setP6(vistaant.jRadioButton6.isSelected());
            modantpat.setP7(vistaant.jRadioButton7.isSelected());
            modantpat.setP8(vistaant.jRadioButton8.isSelected());
            modantpat.setP9(vistaant.jRadioButton9.isSelected());
            modantpat.setP10(vistaant.jRadioButton10.isSelected());
            modantpat.setP11(vistaant.jRadioButton11.isSelected());
            modantpat.setP12(vistaant.jRadioButton12.isSelected());
            modantpat.setP13(vistaant.jRadioButton13.isSelected());
            modantpat.setP14(vistaant.jRadioButton14.isSelected());
            modantpat.setP15(vistaant.jRadioButton15.isSelected());
            modantpat.setP17(vistaant.jRadioButton16.isSelected());
            modantpat.setP18(vistaant.jRadioButton17.isSelected());
            modantpat.setP19(vistaant.jRadioButton18.isSelected());
            modantpat.setP20(vistaant.jRadioButton19.isSelected());
            modantpat.setP21(vistaant.jRadioButton20.isSelected());
            modantpat.setP22(vistaant.jRadioButton21.isSelected());
            modantpat.setP23(vistaant.jRadioButton22.isSelected());
            modantpat.setP24(vistaant.jRadioButton23.isSelected());
            modantpat.setP25(vistaant.jRadioButton24.isSelected());
            modantpat.setP26(vistaant.jRadioButton25.isSelected());
            modantpat.setP16(vistaant.jRadioButton26.isSelected());
            if (vistaant.checkBueno.isSelected()) {
                modantpat.setP27(1);
            }
            if (vistaant.checkMalo.isSelected()) {
                modantpat.setP27(2);
            }
            if (vistaant.checkRegular.isSelected()) {
                modantpat.setP27(3);
            }
            modantpat.confirmar();
        }
    }
    
    
    
}
