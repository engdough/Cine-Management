package br.ufsc.ine5608.cineManagement.models;

import java.io.Serializable;

public class Filme implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codigo;
    private String nome;
    private String descricao;
    private String classificacaoIndicativa;
    private int duracaoMinutos;
    private String genero;

    public Filme() {

    }

    public Filme(int codigo, String nome, String descricao, String classificacaoIndicativa, int duracaoMinutos, String genero) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.duracaoMinutos = duracaoMinutos;
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
