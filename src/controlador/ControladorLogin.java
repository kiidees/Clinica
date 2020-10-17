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
        modelo.setUsuario(vista.userName.getText());
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
