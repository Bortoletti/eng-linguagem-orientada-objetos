/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package amplitrabalhooo;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luis
 */
public class AmpliTrabalhoOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:sqlite:/home/luis/usr/java/dbf/cadastro.db";

        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        JanelaApplicacao janela = new JanelaApplicacao();
        janela.setVisible( true );
    }
    
}
