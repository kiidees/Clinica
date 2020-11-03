package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            vista.setVisible(false);
        }//Fin if
    }
    
}//Fin ControladorUsuarios
