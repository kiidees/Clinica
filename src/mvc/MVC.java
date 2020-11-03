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
