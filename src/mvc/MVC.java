<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.ControladorLogin;
import java.net.ConnectException;
import java.sql.SQLException;
import modelo.ModeloLogin;
import vista.VistaLogin;

/**
 *
 * @author jklm2
 */
public class MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConnectException, ClassNotFoundException, SQLException {
        // TODO code application logic here
        VistaLogin vista = new VistaLogin();
        ModeloLogin modelo = new ModeloLogin();
        ControladorLogin control = new ControladorLogin(vista,modelo);
        control.iniciar();
        vista.setVisible(true);
        
    }
    
}
=======
package mvc;

import controlador.ControladorInicio;
import java.net.ConnectException;
import java.sql.SQLException;
import modelo.ModeloInicio;
import vista.VistaInicio;

public class MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConnectException, ClassNotFoundException, SQLException {
        // TODO code application logic here
        VistaInicio Vinicio = new VistaInicio();
        ModeloInicio Minicio = new ModeloInicio();
        ControladorInicio Cinicio = new ControladorInicio(Vinicio, Minicio);
        Cinicio.inicia();
        Vinicio.setVisible(true);

    }
    
}//Fin MVC
>>>>>>> ramafrancisco
