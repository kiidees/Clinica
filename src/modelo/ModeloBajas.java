package modelo;

import BD.Conexion;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;

public class ModeloBajas {
    
    private String RFC;

    public Conexion conect = new Conexion();
    
    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }
    
    public void bajasUsuario() throws SQLException, ConnectException, PSQLException, ClassNotFoundException {
        Conexion modConf = new ModeloLogin().conect.conectar();
        ResultSet resultados = conect.consultar("select * from usuarios where rfcusuario = '" + this.RFC + "'");

        if (resultados.next()) {
            try {
                int result = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar este RFC? " + this.RFC, "Eliminar Usuario", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    if (modConf.ejecutar("DELETE FROM usuarios WHERE rfcusuario = '" + this.RFC + "'")) {
                        JOptionPane.showMessageDialog(null, "¡Usuario Eliminado!");
                        System.out.println("Ejecución correcta!");
                    } else if (result == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "¡Verifica RFC introducido!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡El RFC introducido no se encuentra registrado!");
        }

    }
            
}
