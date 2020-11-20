/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import BD.Conexion;
import controlador.ControladorLogin;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;
import vista.VistaAntPatol;

/**
 *
 * @author jklm2
 */
public class ModeloAntPat {
    Conexion modConf = ControladorLogin.obtenerConexion();
    private int idIngreso;
    private boolean p1;
    private boolean p2;
    private boolean p3;
    private boolean p4;
    private boolean p5;
    private boolean p6;
    private boolean p7;
    private boolean p8;
    private boolean p9;
    private boolean p10;
    private boolean p11;
    private boolean p12;
    private boolean p13;
    private boolean p14;
    private boolean p15;
    private boolean p16;
    private boolean p17;
    private boolean p18;
    private boolean p19;
    private boolean p20;
    private boolean p21;
    private boolean p22;
    private boolean p23;
    private boolean p24;
    private boolean p25;
    private boolean p26;
    private int p27;
    private String observ;
    private String observ2;
    private VistaAntPatol vistaant;

    public VistaAntPatol getVistaant() {
        return vistaant;
    }

    public void setVistaant(VistaAntPatol vistaant) {
        this.vistaant = vistaant;
    }

    public boolean isP1() {
        return p1;
    }

    public void setP1(boolean p1) {
        this.p1 = p1;
    }

    public boolean isP2() {
        return p2;
    }

    public void setP2(boolean p2) {
        this.p2 = p2;
    }

    public boolean isP3() {
        return p3;
    }

    public void setP3(boolean p3) {
        this.p3 = p3;
    }

    public boolean isP4() {
        return p4;
    }

    public void setP4(boolean p4) {
        this.p4 = p4;
    }

    public boolean isP5() {
        return p5;
    }

    public void setP5(boolean p5) {
        this.p5 = p5;
    }

    public boolean isP6() {
        return p6;
    }

    public void setP6(boolean p6) {
        this.p6 = p6;
    }

    public boolean isP7() {
        return p7;
    }

    public void setP7(boolean p7) {
        this.p7 = p7;
    }

    public boolean isP8() {
        return p8;
    }

    public void setP8(boolean p8) {
        this.p8 = p8;
    }

    public boolean isP9() {
        return p9;
    }

    public void setP9(boolean p9) {
        this.p9 = p9;
    }

    public boolean isP10() {
        return p10;
    }

    public void setP10(boolean p10) {
        this.p10 = p10;
    }

    public boolean isP11() {
        return p11;
    }

    public void setP11(boolean p11) {
        this.p11 = p11;
    }

    public boolean isP12() {
        return p12;
    }

    public void setP12(boolean p12) {
        this.p12 = p12;
    }

    public boolean isP13() {
        return p13;
    }

    public void setP13(boolean p13) {
        this.p13 = p13;
    }

    public boolean isP14() {
        return p14;
    }

    public void setP14(boolean p14) {
        this.p14 = p14;
    }

    public boolean isP15() {
        return p15;
    }

    public void setP15(boolean p15) {
        this.p15 = p15;
    }

    public boolean isP16() {
        return p16;
    }

    public void setP16(boolean p16) {
        this.p16 = p16;
    }

    public boolean isP17() {
        return p17;
    }

    public void setP17(boolean p17) {
        this.p17 = p17;
    }

    public boolean isP18() {
        return p18;
    }

    public void setP18(boolean p18) {
        this.p18 = p18;
    }

    public boolean isP19() {
        return p19;
    }

    public void setP19(boolean p19) {
        this.p19 = p19;
    }

    public boolean isP20() {
        return p20;
    }

    public void setP20(boolean p20) {
        this.p20 = p20;
    }

    public boolean isP21() {
        return p21;
    }

    public void setP21(boolean p21) {
        this.p21 = p21;
    }

    public boolean isP22() {
        return p22;
    }

    public void setP22(boolean p22) {
        this.p22 = p22;
    }

    public boolean isP23() {
        return p23;
    }

    public void setP23(boolean p23) {
        this.p23 = p23;
    }

    public boolean isP24() {
        return p24;
    }

    public void setP24(boolean p24) {
        this.p24 = p24;
    }

    public boolean isP25() {
        return p25;
    }

    public void setP25(boolean p25) {
        this.p25 = p25;
    }

    public boolean isP26() {
        return p26;
    }

    public void setP26(boolean p26) {
        this.p26 = p26;
    }

    public int getP27() {
        return p27;
    }

    public void setP27(int p27) {
        this.p27 = p27;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public String getObserv2() {
        return observ2;
    }

    public void setObserv2(String observ2) {
        this.observ2 = observ2;
    }
    
    public void confirmar(){
        vistaant.setVisible(false);
    }
    
    
}
