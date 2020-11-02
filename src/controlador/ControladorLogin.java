package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import modelo.ModeloLogin;
import vista.VistaLogin;
import modelo.ModeloRegistro;
import vista.VistaRegistro;


public class ControladorLogin implements ActionListener{
    private VistaLogin vista;
    private ModeloLogin modelo;
    private VistaRegistro registroUsuario;

    public ControladorLogin(VistaLogin vista, ModeloLogin modelo) throws ConnectException, ClassNotFoundException, SQLException {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnInicia.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.modelo.conect.conectar();
    }
    
    public void iniciar(){
        vista.setTitle("Hesi-Re v1.0.0");
        vista.setLocationRelativeTo(null);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setIconImage(new ImageIcon(getClass().getResource("/icon/tooth.png")).getImage());
    }
   
    @Override
    public void actionPerformed(ActionEvent e){
        //Accion ENTRAR
        if(e.getSource() == vista.btnInicia){
            modelo.setUsuario(vista.userName.getText().toUpperCase());
            modelo.setPassword(vista.userPass.getText());
            try {
                modelo.verificaUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//Fin if
        //Accion CANCELAR
        if(e.getSource() == vista.btnCancelar){
            vista.setVisible(false);
        }//Fin if
        //Accion Registrarse
        if(e.getSource() == vista.btnRegistrar){
            registroUsuario.setVisible(true);
        }
        
    }//Fin actionPerformed
    
}
