package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import modelo.ModeloOperaciones;
import modelo.ModeloUsuarios;
import vista.VistaOperaciones;
import vista.VistaUsuarios;


public class ControladorUsuarios implements ActionListener{
    
    private VistaUsuarios vista;
    private ModeloUsuarios modelo;
    
    public ControladorUsuarios(VistaUsuarios vista, ModeloUsuarios modelo){
        
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnCerrar.addActionListener(this);
        this.vista.btnOperaciones.addActionListener(this);

    
    }
    
    public void iniciar(){  
        vista.setTitle("Hesi-Re v1.0.0");
        vista.setLocation(50, 0);
        vista.setResizable(false);
        vista.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());
        vista.setLocationRelativeTo(null);
        vista.setSize(1280, 720);
    }//Fin inicio
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vista.btnCerrar){
            try {
                vista.setVisible(false);
                mvc.MVC.main(null);
            } catch (ConnectException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vista.btnOperaciones){
            
            try {
                
                VistaOperaciones vistaO = new VistaOperaciones();
                ModeloOperaciones modeloO = new ModeloOperaciones();
                ControladorOperaciones control = new ControladorOperaciones(vistaO, modeloO);
                control.iniciar();
                vistaO.setVisible(true);
                
                //vista.setVisible(false);
            } catch (ConnectException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
    }
    
}//Fin ControladorUsuarios
