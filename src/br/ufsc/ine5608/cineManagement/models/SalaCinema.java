package br.ufsc.ine5608.cineManagement.models;

import br.ufsc.ine5608.cineManagement.enums.TipoSala;

import java.io.Serializable;

public class SalaCinema implements Serializable {

    public static final long serialVersionUID = 1L;

    private String nome;
    private int fileiras;
    private int cadeirasPorFileira;
    private TipoSala tipoSala;
    private boolean status;


    public SalaCinema(String nome, int fileiras, int cadeirasPorFileira, TipoSala tipoSala, boolean status) {
        this.nome = nome;
        this.fileiras = fileiras;
        this.cadeirasPorFileira = cadeirasPorFileira;
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

    public int getFileiras() {
        return fileiras;
    }

    public void setFileiras(int fileiras) {
        this.fileiras = fileiras;
    }

    public int getCadeirasPorFileira() {
        return cadeirasPorFileira;
    }

    public void setCadeirasPorFileira(int cadeirasPorFileira) {
        this.cadeirasPorFileira = cadeirasPorFileira;
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
