package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import modelo.ModeloExploracionFisica;
import vista.VistaExploracionFisica;

public class ControladorExploracionFisica implements ActionListener {
    private VistaExploracionFisica vista;
    private ModeloExploracionFisica modelo;

    public ControladorExploracionFisica(VistaExploracionFisica vista, ModeloExploracionFisica modelo) throws ConnectException, ClassNotFoundException, SQLException{
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnAceptar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("Hesi-Re v1.0.0");
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnCancelar) {
            vista.setVisible(false);
        }
        if (e.getSource() == vista.btnAceptar) {
            modelo.setCara(vista.txtCara.getText());
            modelo.setCuello(vista.txtCuello.getText());
            modelo.setCabeza(vista.txtCabeza.getText());
            modelo.setAperienciaFisica(vista.txtAFisica.getText());
            modelo.setEstadoActual(vista.txtEstadoPaciente.getText());
            modelo.setObservaciones(vista.txtareaObservaciones.getText());
            try {
                modelo.registroExploracionFisica();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ConnectException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
