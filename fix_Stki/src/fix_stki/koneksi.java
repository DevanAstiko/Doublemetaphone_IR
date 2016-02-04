package fix_stki;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Fachrian Anugerah
 */
public class koneksi {
    private static Connection koneksi;

    public static Connection getConnectionTB(String username, String password, String namaDB) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            String url = "jdbc:mysql://localhost:3306/"+namaDB+"";
            koneksi = DriverManager.getConnection(url, username, password);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex );
        }
        return koneksi;
    }

}
