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
import modelo.ModeloOperaciones;
import vista.VistaOperaciones;

/**
 *
 * @author juanf
 */
public class ControladorOperaciones implements ActionListener{
    
    private VistaOperaciones vista;
    private ModeloOperaciones modelo;
    
    public ControladorOperaciones(VistaOperaciones vista, ModeloOperaciones modelo) throws ConnectException, ClassNotFoundException, SQLException{
        this.vista = vista;
        this.modelo = modelo;
        this.modelo.conect.conectar();
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        
    }
    
    public void iniciar(){
        
       vista.setResizable(false);        
       vista.setTitle("Hesi-Re v1.0.0");
       vista.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());
       vista.setLocationRelativeTo(null);
        
    }
    
    @Override
     public void actionPerformed(ActionEvent e){
         
         if(e.getSource() == vista.btnEliminar){
            modelo.setRFC(vista.txtEliminar.getText().toUpperCase());
            try {
                modelo.bajasUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ConnectException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         if(e.getSource() == vista.btnCancelar){
             vista.setVisible(false);
         }
     }
    
}
