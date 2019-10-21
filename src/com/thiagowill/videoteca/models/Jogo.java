/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiagowill.videoteca.models;

import java.util.Objects;

/**
 *
 * @author thiago
 */
public class Jogo {
    
    private Integer codigo;
    private String titulo;
    private String plataforma;
    private int quantidade;
    
    public Jogo(){
        
    }

    public Jogo(Integer codigo, String titulo, String plataforma, int quantidade) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.quantidade = quantidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogo other = (Jogo) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "\n\nJogo{" + "codigo=" + codigo + ", titulo=" + titulo + "\n plataforma=" + plataforma + ", quantidade=" + quantidade + '}';
    }
    
    
    
    
}
