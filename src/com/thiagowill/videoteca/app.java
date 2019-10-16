/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiagowill.videoteca;

import com.thiagowill.videoteca.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thiago
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
       
        //testando a conexao
        Connection connection = null;
        PreparedStatement stmt =  null;
        ResultSet rs =  null;
        
        connection = ModuloConexao.conector();
        
        String sql = "select * from filmes";
        
        try{
        stmt = connection.prepareStatement(sql);
        rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)
                    +" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+"\n");
        }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
