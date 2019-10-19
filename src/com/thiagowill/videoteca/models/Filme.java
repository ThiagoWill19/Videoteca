/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiagowill.videoteca.models;

/**
 *
 * @author thiago
 */
public class Filme {

    private Integer id;
    private String titulo;
    private String direcao;
    private String genero;
    private String ano;
    private int duracao;
    private String atorPrincipal;

    public Filme(){
        
    }

    public Filme(int id, String titulo, String direcao, String genero, String ano, int duracao, String atorPrincipal) {
        this.id = id;
        this.titulo = titulo;
        this.direcao = direcao;
        this.genero = genero;
        this.ano = ano;
        this.duracao = duracao;
        this.atorPrincipal = atorPrincipal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getAtorPrincipal() {
        return atorPrincipal;
    }

    public void setAtorPrincipal(String atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Filme other = (Filme) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", titulo=" + titulo + ", direcao=" +
                direcao + ", genero=" + genero + ", ano=" + ano + ", duracao=" +
                duracao + ", atorPrincipal=" + atorPrincipal + '}';
    }
    
    
    
}
