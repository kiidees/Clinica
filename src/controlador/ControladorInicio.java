package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import modelo.ModeloInicio;
import vista.VistaInicio;

public class ControladorInicio implements ActionListener {

    private VistaInicio vista;
    private ModeloInicio modelo;

    public ControladorInicio(VistaInicio vista, ModeloInicio modelo) {

        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnLogin.addActionListener(this);

    }

    public void inicia() {

        vista.setTitle("Hesi-Re v1.0.0");
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());

    }

    public void actionPerformed(ActionEvent e) {

        try {
            modelo.IniciaSesion();
        } catch (ConnectException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}//Fin ControladorInicio
