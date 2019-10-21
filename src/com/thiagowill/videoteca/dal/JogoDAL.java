/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiagowill.videoteca.dal;

import com.thiagowill.videoteca.models.Jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiago
 */
public class JogoDAL {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String INSERT = "INSERT INTO JOGOS (titulo, plataforma, quantidade) VALUES (?, ?, ?)";
    private final String UPDATE = "UPDATE JOGOS SET titulo= ?, plataforma= ?, quantidade= ? WHERE codigo= ?";
    private final String DELETE = "DELETE FROM JOGOS WHERE codigo= ?";
    private final String LIST = "SELECT * FROM JOGOS";
    private final String LISTBYID = "SELECT * FROM JOGOS WHERE codigo= ?";
    private final String INSTANTSEARCH = "SELECT * FROM JOGOS WHERE titulo LIKE ?";

    public void insert(Jogo j) {

        conn = ModuloConexao.conector();

        if (conn != null) {

            try {
                stmt = conn.prepareStatement(INSERT);

                stmt.setString(1, j.getTitulo());
                stmt.setString(2, j.getPlataforma());
                stmt.setInt(3, j.getQuantidade());

                stmt.execute();
                JOptionPane.showMessageDialog(null, "Jogo cadastrado com sucesso!");
                stmt.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao efetuar cadastro!\n" + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sem conexão com banco de dados!");
        }

    }

    public void update(Jogo j) {

        conn = ModuloConexao.conector();
        if (conn != null) {

            try {

                stmt = conn.prepareStatement(UPDATE);
                stmt.setString(1, j.getTitulo());
                stmt.setString(2, j.getPlataforma());
                stmt.setInt(3, j.getQuantidade());
                stmt.setInt(4, j.getCodigo());

                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "Update realizado com sucesso!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao efetuar update!\n" + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sem conexão com banco de dados!");
        }

    }

    public void delete(int codigo) {

        conn = ModuloConexao.conector();
        if (conn != null) {

            try {

                stmt = conn.prepareStatement(DELETE);
                stmt.setInt(1, codigo);

                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao efetuar Remoção!\n" + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sem conexão com banco de dados!");
        }

    }

    public List<Jogo> findAll() {

        List<Jogo> list = new ArrayList<>();
        conn = ModuloConexao.conector();

        if (conn != null) {

            try {

                stmt = conn.prepareStatement(LIST);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Jogo j = new Jogo();
                    j.setCodigo(rs.getInt(1));
                    j.setTitulo(rs.getString(2));
                    j.setPlataforma(rs.getString(3));
                    j.setQuantidade(rs.getInt(4));

                    list.add(j);

                }
                stmt.close();
                rs.close();
                return list;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao efetuar Listagem!\n" + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sem conexão com banco de dados!");
        }

        return null;
    }

    public Jogo findById(int codigo) {

        Jogo j = new Jogo();
        conn = ModuloConexao.conector();
        if (conn != null) {

            try {

                stmt = conn.prepareStatement(LISTBYID);
                stmt.setInt(1,codigo );
                rs = stmt.executeQuery();
                if (rs.next()) {

                    j.setCodigo(rs.getInt(1));
                    j.setTitulo(rs.getString(2));
                    j.setPlataforma(rs.getString(3));
                    j.setQuantidade(rs.getInt(4));

                }
                
                rs.close();
                stmt.close();
                return j;
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao efetuar Listagem!\n" + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sem conexão com banco de dados!");
        }

        return null;
    }
    
    public List<Jogo> instantSearch(String search){
        
        List<Jogo> list = new ArrayList<>();
        conn = ModuloConexao.conector();
        
        if(conn!=null){
            
            try {
                stmt = conn.prepareStatement(INSTANTSEARCH);
                stmt.setString(1, "%"+search+"%");
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    
                    Jogo j = new Jogo();
                    j.setCodigo(rs.getInt(1));
                    j.setTitulo(rs.getString(2));
                    j.setPlataforma(rs.getString(3));
                    j.setQuantidade(rs.getInt(4));

                    list.add(j);
                    
                }
                rs.close();
                stmt.close();
                return list;
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao efetuar Listagem!\n" + e.getMessage());
            }
            
        }else JOptionPane.showMessageDialog(null, "Sem conexão com banco de dados!");
        
        return null;
    }

}
