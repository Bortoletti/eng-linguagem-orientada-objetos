/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// https://terminalroot.com.br/2022/06/como-conectar-ao-sqlite-com-java.html

package amplitrabalhooo;

import java.sql.*;

import javax.swing.table.AbstractTableModel;
import java.util.*;


/**
 *
 * @author luis
 */
public class GridCadastro extends AbstractTableModel  {
    private String[] columnNames = {"id","nome"};
    private Object[][] data = {{"1","Luis"}};
    private ArrayList<Cadastro> lista = new ArrayList<Cadastro>();

    public GridCadastro()
    {
        this.carga();
    }


    public void addRow( Cadastro param )
    {
      this.lista.add( param );
      System.out.println( param );
      this.fireTableDataChanged();
    }
    
    public void carga()
    {
        String url = "jdbc:sqlite:cadastro.db";
        this.lista = new ArrayList<Cadastro>();

        try 
        {
            var conn = DriverManager.getConnection(url);
            if (conn != null) 
            {
                Statement statement = conn.createStatement();
                // statement.executeUpdate("CREATE TABLE cadastro (id INTEGER, name STRING)");
                //statement.executeUpdate("INSERT INTO cadastro VALUES( " + this.id + ", '" + this.nome + "')");
                
               // var meta = conn.getMetaData();
                //System.out.println("The driver name is " + meta.getDriverName());
                //System.out.println("A new database has been created.");
                

                ResultSet rs = statement.executeQuery("SELECT * FROM cadastro");
                while(rs.next()) 
                {
                  // Ler os dados inseridos
                  System.out.println("NOME DO CARA  : " + rs.getString("name"));
                  System.out.println("IDENTIFICAÇÃO : " + rs.getInt("id"));
                  this.lista.add( new Cadastro( rs.getString("id"), rs.getString("name")  ) );

                }

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }     
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        // return data.length;
        return this.lista.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        // return data[row][col];
        Cadastro item = (Cadastro)this.lista.get(row);
        StringBuffer value = new StringBuffer( item.nome );
        if( col == 0 ) value = new StringBuffer( item.id );
         return value;
    }

    
}
