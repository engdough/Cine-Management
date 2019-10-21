package br.ufsc.ine5608.cineManagement.models;

import br.ufsc.ine5608.cineManagement.enums.TipoSala;

import java.io.Serializable;

public class SalaCinema implements Serializable {

    public static final long serialVersionUID = 1L;

    private String nome;
    private int capacidade;
    private TipoSala tipoSala;
    private boolean status;

    public SalaCinema(String nome, int capacidade, TipoSala tipoSala, boolean status) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.tipoSala = tipoSala;
        this.status = status;
    }

    public SalaCinema() {

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

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
