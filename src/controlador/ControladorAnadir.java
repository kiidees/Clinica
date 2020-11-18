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
import modelo.ModelAnadir;
import vista.VistaAnadir;

/**
 *
 * @author jklm2
 */
public class ControladorAnadir implements ActionListener{
    private VistaAnadir vistaAnadir;
    private ModelAnadir modeloAnadir;

    public ControladorAnadir(VistaAnadir vistaAnadir, ModelAnadir modeloAnadir) {
        this.vistaAnadir = vistaAnadir;
        this.modeloAnadir = modeloAnadir;
        this.vistaAnadir.btnBuscar.addActionListener(this);
        this.vistaAnadir.btnModificar.addActionListener(this);
        this.vistaAnadir.btnSiguiente.addActionListener(this);
        this.vistaAnadir.btnGuardar.addActionListener(this);
        this.vistaAnadir.btnCancel.addActionListener(this);
    }

    public void iniciar(){  
        vistaAnadir.setTitle("Hesi-Re v1.0.0");
        vistaAnadir.setResizable(false);
        vistaAnadir.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());
        vistaAnadir.setLocationRelativeTo(null);
        vistaAnadir.setSize(1280, 720);
        vistaAnadir.btnGuardar.setEnabled(false);
        vistaAnadir.btnModificar.setEnabled(false);
        vistaAnadir.btnSiguiente.setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vistaAnadir.btnBuscar) {
            try {
                modeloAnadir.setVistaAna(vistaAnadir);
                modeloAnadir.setRfcPaciente(vistaAnadir.txtBuscarRFC.getText());
                modeloAnadir.buscarPaciente();
            } catch (ConnectException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (ae.getSource() == vistaAnadir.btnSiguiente) {
            try {
                modeloAnadir.siguiente();
            } catch (Exception e) {
            }
            
        }
        
        if (ae.getSource() == vistaAnadir.btnGuardar) {
            try {
                modeloAnadir.setApellidosPaciente(vistaAnadir.txtApellidos.getText());
                modeloAnadir.setNombrePaciente(vistaAnadir.txtNombre.getText());
                modeloAnadir.setDomicilioPaciente(vistaAnadir.txtDireccion.getText());
                modeloAnadir.setRfcPaciente(vistaAnadir.txtRFCusuario.getText());
                modeloAnadir.setTelefonoPaciente(Long.parseLong(vistaAnadir.txtTelefono.getText()));
                modeloAnadir.guardar();
            } catch (Exception e) {
            }
        }
        
        if (ae.getSource() == vistaAnadir.btnModificar) {
            try {
                modeloAnadir.setApellidosPaciente(vistaAnadir.txtApellidos.getText());
                modeloAnadir.setNombrePaciente(vistaAnadir.txtNombre.getText());
                modeloAnadir.setDomicilioPaciente(vistaAnadir.txtDireccion.getText());
                modeloAnadir.setRfcPaciente(vistaAnadir.txtRFCusuario.getText());
                modeloAnadir.setTelefonoPaciente(Long.parseLong(vistaAnadir.txtTelefono.getText()));
                modeloAnadir.actualizar();
            } catch (Exception e) {
            }
        }
        
        if (ae.getSource() == vistaAnadir.btnCancel) {
            vistaAnadir.setVisible(false);
        }
    }
    
    
    
}
