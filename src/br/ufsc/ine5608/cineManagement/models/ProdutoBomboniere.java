package br.ufsc.ine5608.cineManagement.models;

import java.io.Serializable;

public class ProdutoBomboniere implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigoBarra;
    private String nome;
    private String descricao;
    private float preco;

    public ProdutoBomboniere(String codigoBarra, String nome, String descricao, float preco) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public ProdutoBomboniere() {

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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
