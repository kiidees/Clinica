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
        vista.btnConfiguracion.setVisible(false);
        vista.jLabelBienvenido.setText("HOLA, BIENVENIDO DOCTOR "+nombre);
        //Botenes desabilitados
        
    }
    
    public void inicioAdministrador(String nombre){
        VistaUsuarios vista = new VistaUsuarios();
        ModeloUsuarios modelo = new ModeloUsuarios();
        ControladorUsuarios control = new ControladorUsuarios(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
        vista.jLabelBienvenido.setText("HOLA, BIENVENIDO ADMINISTRADOR "+nombre);
        //Botenes desabilitados
        /*vista.jButton1.setEnabled(false);
        vista.jButton2.setEnabled(false);
        vista.jButton3.setEnabled(false);
        vista.jButton4.setEnabled(false);*/
        vista.btnAnadir.setVisible(false);
        vista.btnOperaciones.setVisible(false);
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
        vista.jLabelBienvenido.setText("HOLA, BIENVENIDO ASISTENTE "+nombre);
        //Botenes desabilitados
        vista.btnOperaciones.setEnabled(false);
        vista.jButton2.setEnabled(false);
        vista.jButton3.setEnabled(false);
        vista.jButton4.setEnabled(false);
        vista.btnAnadir.setEnabled(false);
        vista.btnConfiguracion.setEnabled(false);
    }
    
}//Fin ModeloUsuarios
