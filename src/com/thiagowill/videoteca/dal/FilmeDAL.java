/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiagowill.videoteca.dal;

import com.thiagowill.videoteca.models.Filme;
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
public class FilmeDAL {

    private final String LIST = "select * from filmes";
    private final String LISTBYID = "select * from filmes where id= ?";
    private final String INSERT = "insert into filmes values(?,?,?,?,?,?,?)";
    private final String REMOVE = "delete from filmes where id= ?";
    private final String UPDATE = "update contato set (?,?,?,?,?,?) where id= ?";

    public void insert(Filme filme) {

        if (filme != null) {

            Connection conn = null;
            try {
                conn = ModuloConexao.conector();
                PreparedStatement stmt;
                stmt = conn.prepareStatement(INSERT);

                stmt.setString(1, null);
                stmt.setString(2, filme.getTitulo());
                stmt.setString(3, filme.getDirecao());
                stmt.setString(4, filme.getGenero());
                stmt.setString(5, filme.getAno());
                stmt.setString(6, "" + filme.getDuracao());
                stmt.setString(7, filme.getAtorPrincipal());

                stmt.execute();
                JOptionPane.showMessageDialog(null, "Filme cadastrado!");
                conn.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + e.getMessage());
            }

        } else {
            System.out.println("O contato enviado por parametro está vazio!");

        }

    }

    public void update(Filme filme) {

        if (filme != null) {
            Connection conn = null;
            try {
                conn = ModuloConexao.conector();
                PreparedStatement stmt;
                stmt = conn.prepareStatement(UPDATE);

                stmt.setString(1, filme.getTitulo());
                stmt.setString(2, filme.getDirecao());
                stmt.setString(3, filme.getGenero());
                stmt.setString(4, filme.getAno());
                stmt.setString(5, "" + filme.getDuracao());
                stmt.setString(6, filme.getAtorPrincipal());
                stmt.setString(7, filme.getId() + "");

                stmt.execute();
                JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!");
                stmt.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar! " + e.getMessage());
            }
        } else {

            System.out.println("O contato enviado por parametro está vazio!");

        }
    }

    public void remove(int id) {

        try {
            Connection conn = ModuloConexao.conector();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(REMOVE);
            stmt.setInt(1, id);
            boolean stts = stmt.execute();
            if(stts)JOptionPane.showMessageDialog(null, "Excluido!");
                else JOptionPane.showMessageDialog(null, "ID não encontrado!");
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir " + e.getMessage());
        }

    }

    public List<Filme> findAll() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Filme> list = new ArrayList<>();

        try {
            conn = ModuloConexao.conector();
            stmt = conn.prepareStatement(LIST);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Filme f = new Filme();
                f.setId(rs.getInt(1));
                f.setTitulo(rs.getString(2));
                f.setDirecao(rs.getString(3));
                f.setGenero(rs.getString(4));
                f.setAno(rs.getString(5));
                f.setDuracao(rs.getInt(6));
                f.setAtorPrincipal(rs.getString(7));

                list.add(f);

            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados");
        }
        return list;

    }

    public Filme findById(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Filme f = new Filme();

        try {
            conn = ModuloConexao.conector();
            stmt = conn.prepareStatement(LISTBYID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                f.setId(rs.getInt(1));
                f.setTitulo(rs.getString(2));
                f.setDirecao(rs.getString(3));
                f.setGenero(rs.getString(4));
                f.setAno(rs.getString(5));
                f.setDuracao(rs.getInt(6));
                f.setAtorPrincipal(rs.getString(7));

            }
            
            conn.close();

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados");
            
        }
        
        return f;

    }

}
