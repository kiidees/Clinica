package controlador;

import modelo.ModeloRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;
import vista.VistaRegistro;

public class ControladorRegistro implements ActionListener {
    private VistaRegistro vista;
    private ModeloRegistro modelo;
    
    public ControladorRegistro(VistaRegistro vista, ModeloRegistro modelo) throws ConnectException, ClassNotFoundException, SQLException{
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnRegistrar.addActionListener(this);
        this.modelo.conect.conectar();
    }
    
    public void iniciar(){
        vista.setTitle("Registrar Nuevo Usuario");
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.btnRegistrar){
            modelo.setUsuario(vista.txtNombre.getText());
            modelo.setApellidos(vista.txtApellidos.getText());
            modelo.setRFC(vista.txtRFC.getText().toUpperCase());
            modelo.setAcceso(Integer.parseInt(vista.txtAcceso.getText()));
            modelo.setEstado(Boolean.parseBoolean(vista.txtEstado.getText()));
            modelo.setPassword(vista.txtContraseña.getText());
            modelo.setPassconfirmation(vista.txtConfContraseña.getText());
            modelo.setTelefono(Integer.parseInt(vista.txtTelefono.getText()));
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
