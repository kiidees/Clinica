package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import modelo.ModeloExamenClinicoEst;
import vista.VistaExamenClinicoEst;

public class ControladorExamenClinicoEst implements ActionListener {
    private VistaExamenClinicoEst vista;
    private ModeloExamenClinicoEst modelo;

    public ControladorExamenClinicoEst(VistaExamenClinicoEst vista, ModeloExamenClinicoEst modelo) throws ConnectException, ClassNotFoundException, SQLException{
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnAceptar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("Hesi-Re v1.0.0");
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setVisible(true);
        vista.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnCancelar) {
            vista.setVisible(false);
        }
        if (e.getSource() == vista.btnAceptar) {
            modelo.setLabios(vista.txtLabios.getText());
            modelo.setMejillas(vista.txtMejillas.getText());
            modelo.setLengua(vista.txtLengua.getText());
            modelo.setCarrillos(vista.txtCarrillos.getText());
            modelo.setPisoDeBoca(vista.txtPdBoca.getText());
            modelo.setPaladarBlando(vista.txtPaladarBlando.getText());
            modelo.setPaladarDuro(vista.txtPaladarDuro.getText());
            modelo.setObservaciones(vista.txtareaObservaciones.getText());
         try {
                modelo.registroExamenClinicoEst();
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
