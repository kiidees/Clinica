package controlador;

import modelo.ModeloRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        try {
            modelo.Registro();
        } catch (ConnectException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
