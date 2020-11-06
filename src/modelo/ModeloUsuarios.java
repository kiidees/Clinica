package modelo;

import controlador.ControladorUsuarios;
import java.net.ConnectException;
import java.sql.SQLException;
import vista.VistaUsuarios;


public class ModeloUsuarios {
    
    
    public void iniciaDoctor(String nombre){
        
        VistaUsuarios vista = new VistaUsuarios();
        ModeloUsuarios modelo = new ModeloUsuarios();
        ControladorUsuarios control = new ControladorUsuarios(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
        
        //Deshabilitacion de botones
        vista.btnConfiguracion.setVisible(false);
    }
    
    public void inicioAdministrador(String nombre){
        VistaUsuarios vista = new VistaUsuarios();
        ModeloUsuarios modelo = new ModeloUsuarios();
        ControladorUsuarios control = new ControladorUsuarios(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
        
        //Deshabilitacion de botones
        vista.jButton10.setVisible(false);
        vista.jButton9.setVisible(false);
        vista.jButton8.setVisible(false);
        vista.btnTeam.setVisible(false);
    }
    
    public void inicioAyudante(String nombre){
        VistaUsuarios vista = new VistaUsuarios();
        ModeloUsuarios modelo = new ModeloUsuarios();
        ControladorUsuarios control = new ControladorUsuarios(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
        
        //deshabilitacion de botones
        vista.btnCrear.setVisible(false);
        vista.btnConfiguracion.setVisible(false);
        vista.jButton10.setVisible(false);
        vista.jButton9.setVisible(false);
        vista.jButton8.setVisible(false);
        vista.btnTeam.setVisible(false);
    }
    
    public void Bajas() throws ConnectException, ClassNotFoundException, SQLException{
        /*VistaOperaciones vista = new VistaOperaciones();
        ModeloOperaciones modelo = new ModeloOperaciones();
        ControladorOperaciones control = new ControladorOperaciones(vista, modelo);
        control.iniciar();
        vista.setVisible(true);*/
    }
    
}//Fin ModeloUsuarios
