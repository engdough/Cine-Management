package br.ufsc.ine5608.cineManagement.models;

import java.io.Serializable;

public class ProdutoBomboniere implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigoBarra;
    private String nome;
    private String descricao;
    private int estoque;

    public ProdutoBomboniere(String codigoBarra, String nome, String descricao) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = 0;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
