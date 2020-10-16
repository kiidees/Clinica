/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jklm2
 */
public class TestConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion conect = new Conexion();
        conect.conectar();
        ResultSet resultados = conect.consultar("select * from usuarios where rfcusuario = 'CANL941222HSP' and contraseña = '123456asdf'");
        
        if (resultados != null) {
            try {
                JOptionPane.showMessageDialog(null, "Iniciaste sesion correctamente");
                while (resultados.next()) {
                    //
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } //estado = true;}
        else {
            JOptionPane.showMessageDialog(null, "Verifica tu Usuario y Contraseña");

            //estado = false;
        }
    }
}
