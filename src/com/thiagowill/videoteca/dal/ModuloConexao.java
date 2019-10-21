/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiagowill.videoteca.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author thiago
 */
public class ModuloConexao {
    
       public static Connection conector() {

        Connection conexao = null;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cadastros";
        String user = "root";
        String password = "";
        
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Sem conexão com banco de dados!\n"+ ex.getMessage());
            return null;
        }
    }
    
}
