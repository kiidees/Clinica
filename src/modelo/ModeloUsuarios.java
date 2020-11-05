package modelo;

import controlador.ControladorUsuarios;
import vista.VistaUsuarios;


public class ModeloUsuarios {
    
    
    public void iniciaDoctor(String nombre){
        
        VistaUsuarios vista = new VistaUsuarios();
        ModeloUsuarios modelo = new ModeloUsuarios();
        ControladorUsuarios control = new ControladorUsuarios(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
        vista.jLabelBienvenido.setText("HOLA, BIENVENIDO DOCTOR "+nombre);
        //Botenes desabilitados
        vista.jLabelConfiguracion.setEnabled(false);
        vista.btnConfiguracion.setEnabled(false);
        
    }
    
    public void inicioAdministrador(String nombre){
        VistaUsuarios vista = new VistaUsuarios();
        ModeloUsuarios modelo = new ModeloUsuarios();
        ControladorUsuarios control = new ControladorUsuarios(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
        vista.jLabelBienvenido.setText("HOLA, BIENVENIDO ADMINISTRADOR "+nombre);
        //Botones desabilitados
        vista.btnAnadir.setVisible(false);
        vista.jButton1.setVisible(false);
        vista.jButton2.setVisible(false);
        vista.jButton3.setVisible(false);
        vista.jButton4.setVisible(false);
    }
    
    public void inicioAyudante(String nombre){
        VistaUsuarios vista = new VistaUsuarios();
        ModeloUsuarios modelo = new ModeloUsuarios();
        ControladorUsuarios control = new ControladorUsuarios(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
        vista.jLabelBienvenido.setText("HOLA, BIENVENIDO "+nombre);
        //Botenes desabilitados
        vista.jButton1.setVisible(false);
        vista.jButton2.setEnabled(false);
        vista.jButton3.setEnabled(false);
        vista.jButton4.setEnabled(false);
        vista.btnAnadir.setEnabled(false);
        vista.btnConfiguracion.setEnabled(false);
        vista.jLabelConfiguracion.setEnabled(false);
    }
    
}//Fin ModeloUsuarios
