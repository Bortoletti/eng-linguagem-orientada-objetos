/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amplitrabalhooo;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luis
 */
public class Cadastro 
{
  public StringBuffer id = new StringBuffer();
  public StringBuffer nome = new StringBuffer();
  
  public Cadastro(){};
  
  public Cadastro( String idParam, String nameParam )
  {
    this.id = new StringBuffer( idParam );
    this.nome = new StringBuffer( nameParam );
  }
  
  
  public void addCadastro()
  {
        String url = "jdbc:sqlite:cadastro.db";

        try 
        {
            var conn = DriverManager.getConnection(url);
            if (conn != null) 
            {
                Statement statement = conn.createStatement();
                try
                {
                  statement.executeUpdate("CREATE TABLE cadastro (id INTEGER, name STRING)");
                }
                catch (SQLException e) 
                {
                    System.err.println(e.getMessage());
                }

                statement.executeUpdate("INSERT INTO cadastro VALUES( " + this.id + ", '" + this.nome + "')");
                
                var meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                
                // this.id = new StringBuffer();
                // this.nome = new StringBuffer();
            }
        } 
        catch (SQLException e) 
        {
            System.err.println(e.getMessage());
        }
  }
  
  public String toString()
  {
      System.out.println( "Cadastro" );
      System.out.println( "Linha = " + this.nome );
      return this.nome.toString();
  }
}
