<<<<<<< HEAD
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
import modelo.ModeloLogin;
import vista.VistaLogin;

public class ControladorLogin implements ActionListener{
    private VistaLogin vista;
    private ModeloLogin modelo;

    public ControladorLogin(VistaLogin vista, ModeloLogin modelo) throws ConnectException, ClassNotFoundException, SQLException {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnInicia.addActionListener(this);
        this.modelo.conect.conectar();
    }
    
    public void iniciar(){
        vista.setTitle("ClinicaSoft v1.0.0");
        vista.setLocationRelativeTo(null);
    }
   
    @Override
    public void actionPerformed(ActionEvent e){
        //modelo.verificaUsuario(vista.userName.getText(), vista.userPass.getText());
        modelo.setUsuario(vista.userName.getText().toUpperCase());
        modelo.setPassword(vista.userPass.getText());
        try {
            modelo.verificaUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
=======
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import modelo.ModeloLogin;
import vista.VistaLogin;


public class ControladorLogin implements ActionListener{
    private VistaLogin vista;
    private ModeloLogin modelo;

    public ControladorLogin(VistaLogin vista, ModeloLogin modelo) throws ConnectException, ClassNotFoundException, SQLException {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnInicia.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.modelo.conect.conectar();
    }
    
    public void iniciar(){
        vista.setTitle("Hesi-Re v1.0.0");
        vista.setLocationRelativeTo(null);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());
        
    }
   
    @Override
    public void actionPerformed(ActionEvent e){
        //Accion ENTRAR
        if(e.getSource() == vista.btnInicia){
            modelo.setUsuario(vista.userName.getText().toUpperCase());
            modelo.setPassword(vista.userPass.getText());
            try {
                modelo.verificaUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//Fin if
        //Accion CANCELAR
        if(e.getSource() == vista.btnCancelar){
            vista.setVisible(false);
        }//Fin if
        
    }//Fin actionPerformed
    
}
>>>>>>> ramafrancisco
