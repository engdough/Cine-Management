package br.ufsc.ine5608.cineManagement.models;

import java.io.Serializable;

public class SalaCinema implements Serializable {

    public static final long serialVersionUID = 1L;

    private String codigo;
    private String nome;
    private int capacidade;
    private String tipoSala;
    private boolean status;

    public SalaCinema(String codigo, String nome, int capacidade, String tipoSala, boolean status) {
        this.codigo = codigo;
        this.nome = nome;
        this.capacidade = capacidade;
        this.tipoSala = tipoSala;
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
