package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloBajas;
import vista.VistaBajas;

public class ControladorBajas implements ActionListener{
    private VistaBajas vista;
    private ModeloBajas modelo;
    
    public ControladorBajas(VistaBajas vista, ModeloBajas modelo) throws ConnectException, ClassNotFoundException, SQLException{
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.modelo.conect.conectar();
    }
    
    public void iniciar(){
        vista.setTitle("Eliminar Usuario");
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Confirmar para eliminar
        if(e.getSource() == vista.btnEliminar){
            modelo.setRFC(vista.txtRFC.getText().toUpperCase());
            try {
                modelo.bajasUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ConnectException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Boton Cancelar
        if(e.getSource() == vista.btnCancelar){
            vista.setVisible(false);
        }
        
    }
    
}
