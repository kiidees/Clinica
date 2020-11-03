package modelo;

import controlador.ControladorLogin;
import java.net.ConnectException;
import java.sql.SQLException;
import vista.VistaLogin;

public class ModeloInicio {

    public void IniciaSesion() throws ConnectException, ClassNotFoundException, SQLException {
        VistaLogin vista = new VistaLogin();
        ModeloLogin modelo = new ModeloLogin();
        ControladorLogin control = new ControladorLogin(vista, modelo);
        control.iniciar();
        vista.setVisible(true);
    }

}//Fin ModeloInicio
