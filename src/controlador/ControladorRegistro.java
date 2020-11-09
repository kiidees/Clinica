package controlador;

import modelo.ModeloRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import vista.VistaRegistro;

public class ControladorRegistro implements ActionListener {
    private VistaRegistro vista;
    private ModeloRegistro modelo;
    
    public ControladorRegistro(VistaRegistro vista, ModeloRegistro modelo) throws ConnectException, ClassNotFoundException, SQLException{
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnRegistrar.addActionListener(this);
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
                
        if(e.getSource() == vista.btnCancelar){
            try {
                mvc.MVC.main(null);
            } catch (ConnectException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
            vista.setVisible(false);
        }
        if(e.getSource() == vista.btnRegistrar){
            modelo.setUsuario(vista.txtNombre.getText());
            modelo.setApellidos(vista.txtApellidos.getText());
            modelo.setRFC(vista.txtRFC.getText().toUpperCase());
            modelo.setAcceso(Integer.parseInt(vista.txtAcceso.getText()));
            modelo.setEstado(Boolean.parseBoolean(vista.txtEstado.getText()));
            modelo.setPassword(vista.txtContraseña.getText());
            modelo.setPassconfirmation(vista.txtConfContraseña.getText());
            modelo.setTelefono(Long.parseLong(vista.txtTelefono.getText()));
            //modelo.setTelefono(Integer.parseInt("123"));
            modelo.setDireccion(vista.txtDireccion.getText());
            try {
                modelo.registroUsuario();
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
