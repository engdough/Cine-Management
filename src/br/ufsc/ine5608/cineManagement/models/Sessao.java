package br.ufsc.ine5608.cineManagement.models;

import java.io.Serializable;
import java.util.Date;

public class Sessao implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigo;
    private Filme filme;
    private Date horaInicio;
    private Date horaFim;
    private SalaCinema sala;
    private int pontos;
    private float preco;
    private boolean[][] lugares;


    public Sessao(Filme filme, Date horaInicio, Date horaFim, SalaCinema sala, int pontos, float preco) {
        this.filme = filme;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.sala = sala;
        this.pontos = pontos;
        this.preco = preco;
    }

    public Sessao(int fileira, int lugares) {
        this.lugares = new boolean[fileira][lugares];
    }

    public Sessao() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public SalaCinema getSala() {
        return sala;
    }

    public void setSala(SalaCinema sala) {
        this.sala = sala;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean[][] getLugares() {
        return lugares;
    }

    public void setLugares(boolean[][] lugares) {
        this.lugares = lugares;
    }
}
