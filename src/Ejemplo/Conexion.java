/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class Conexion {

    private static Conexion instancia;

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public String bd = "bd_ejemplo";
    public String url = "jdbc:mysql://127.0.0.1/" + bd;
    public String user = "root";
    public String password = "";

    public Conexion() {
    }

    public Connection conectar() {
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion" + e.getMessage());
        }
        return link;
    }

}
