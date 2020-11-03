package modelo;

import controlador.ControladorUsuarios;
import vista.VistaUsuarios;


public class ModeloUsuarios {
    
    
    public void iniciaDoctor(){
        
        VistaUsuarios vista = new VistaUsuarios();
        ModeloUsuarios modelo = new ModeloUsuarios();
        ControladorUsuarios control = new ControladorUsuarios(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
        //Botenes desabilitados
        
    }
    
    public void inicioAdministrador(){
        VistaUsuarios vista = new VistaUsuarios();
        ModeloUsuarios modelo = new ModeloUsuarios();
        ControladorUsuarios control = new ControladorUsuarios(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
        //Botenes desabilitados
        /*vista.jButton1.setEnabled(false);
        vista.jButton2.setEnabled(false);
        vista.jButton3.setEnabled(false);
        vista.jButton4.setEnabled(false);*/
        vista.btnAnadir.setVisible(false);
        vista.jButton1.setVisible(false);
        vista.jButton2.setVisible(false);
        vista.jButton3.setVisible(false);
        vista.jButton4.setVisible(false);
    }
    
    public void inicioAyudante(){
        VistaUsuarios vista = new VistaUsuarios();
        ModeloUsuarios modelo = new ModeloUsuarios();
        ControladorUsuarios control = new ControladorUsuarios(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
        //Botenes desabilitados
        vista.jButton1.setEnabled(false);
        vista.jButton2.setEnabled(false);
        vista.jButton3.setEnabled(false);
        vista.jButton4.setEnabled(false);
        vista.btnAnadir.setEnabled(false);
        vista.btnConfiguracion.setEnabled(false);
    }
    
}//Fin ModeloUsuarios
