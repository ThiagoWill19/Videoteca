/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiagowill.videoteca.services;

import com.thiagowill.videoteca.dal.JogoDAL;
import com.thiagowill.videoteca.models.Jogo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiago
 */
public class JogoService {

    private JogoDAL jogoDAL = new JogoDAL();

    public boolean insert(Jogo jogo) {

        List<Jogo> list = new ArrayList();

        list = jogoDAL.findAll();

        for (Jogo j : list) {

            if (j.getTitulo().toUpperCase().equals(jogo.getTitulo().toUpperCase())) {
                return false;
            }
        }

        jogoDAL.insert(jogo);

        return true;

    }

    public boolean update(Jogo jogo) {


        jogoDAL.update(jogo);
  

        return false;
    }

    public boolean remove(Jogo jogo) {

        List<Jogo> list = new ArrayList();
        list = jogoDAL.findAll();

        for (Jogo j : list) {

            if (j.getTitulo().toUpperCase().equals(jogo.getTitulo().toUpperCase())) {
                jogo.setCodigo(j.getCodigo());
                jogoDAL.delete(j.getCodigo());
                return true;
            }

        }

        return false;

    }

    public List<Jogo> findAll() {

        List<Jogo> list = new ArrayList();

        list = jogoDAL.findAll();

        return list;

    }

    public Jogo findById(int id) {

        List<Jogo> list = new ArrayList();
        list = jogoDAL.findAll();

        for (Jogo j : list) {

            if (j.getCodigo() == id) {
                return j;
            }

        }

        return null;

    }

    public String instantSearch(String search) {

        List<Jogo> list = new ArrayList();
        list = jogoDAL.instantSearch(search);
        String result = "";

        for (Jogo j : list) {

            result += "Código: " + j.getCodigo() + "||\nTítulo: " + j.getTitulo() + "\n"
                    + "Plataforma: " + j.getPlataforma() + "\n"
                    + "Quantidade: " + j.getQuantidade()
                    + "\n-------------------------------------------------------"
                    + "\n-------------------------------------------------------\n";

        }

        return result;

    }

    public Jogo findByTitle(String title) {

        List<Jogo> list = new ArrayList();
        list = jogoDAL.findAll();
        
        for(Jogo j : list){
            
            if(j.getTitulo().toUpperCase().equals(title.toUpperCase())){
                
                return j;
            }
            
        }
        
        return null;
    }

}
