package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import modelo.ModeloUsuarios;
import vista.VistaUsuarios;


public class ControladorUsuarios implements ActionListener{
    
    private VistaUsuarios vista;
    private ModeloUsuarios modelo;
    
    public ControladorUsuarios(VistaUsuarios vista, ModeloUsuarios modelo){
        
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnAnadir.addActionListener(this);
        this.vista.btnCalendario.addActionListener(this);
        this.vista.btnPerfil.addActionListener(this);
        this.vista.btnConfiguracion.addActionListener(this);
        this.vista.btnVista.addActionListener(this);
        this.vista.btnCerrar.addActionListener(this);
    
    }
    
    public void iniciar(){
        
        vista.setTitle("Hesi-Re v1.0.0");
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());
        
    }//Fin inicio
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vista.btnCerrar){
            try {
                mvc.MVC.main(null);
            } catch (ConnectException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            vista.setVisible(false);
        }//Fin if
    }
    
}//Fin ControladorUsuarios
