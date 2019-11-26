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
    private boolean[] horariosLocados;
    private String[] diasSemana;
    private int[] horarios;
    private float preco;


    public Sessao(Filme filme, Date horaInicio, Date horaFim, SalaCinema sala, int pontos, float preco) {
        this.filme = filme;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.sala = sala;
        this.pontos = pontos;
        this.preco = preco;
        this.diasSemana = new String[]{"segunda", "terça", "quarta", "quinta", "sexta", "sabado", "domingo"};
        this.horariosLocados = new boolean[]{false, false, false, false, false, false,
                                             false, false, false, false, false, false,
                                             false, false, false, false, false, false,
                                             false, false, false, false, false, false,
                                             false, false, false, false, false, false,
                                             false, false, false, false, false, false,
                                             false, false, false, false, false, false,
                                             false, false, false, false, false, false,
                                             false, false, false, false, false, false,
                                             false, false, false, false, false, false,
                                             false, false, false, false, false, false, false};
        this.horarios = new int[]{1200, 1210, 1220, 1230, 1240, 1250,
                                  1300, 1310, 1320, 1330, 1340, 1350,
                                  1400, 1410, 1420, 1430, 1440, 1450,
                                  1500, 1510, 1520, 1530, 1540, 1550,
                                  1600, 1610, 1620, 1630, 1640, 1650,
                                  1700, 1710, 1720, 1730, 1740, 1750,
                                  1800, 1810, 1820, 1830, 1840, 1850,
                                  1900, 1910, 1920, 1930, 1940, 1950,
                                  2000, 2010, 2020, 2030, 2040, 2050,
                                  2100, 2110, 2120, 2130, 2140, 2150,
                                  2200, 2210, 2220, 2230, 2240, 2250, 2300};
    }

    public Sessao() {
        this.diasSemana = new String[]{"segunda", "terça", "quarta", "quinta", "sexta", "sabado", "domingo"};
        this.horariosLocados = new boolean[]{false, false, false, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, false, false};
        this.horarios = new int[]{1200, 1210, 1220, 1230, 1240, 1250,
                1300, 1310, 1320, 1330, 1340, 1350,
                1400, 1410, 1420, 1430, 1440, 1450,
                1500, 1510, 1520, 1530, 1540, 1550,
                1600, 1610, 1620, 1630, 1640, 1650,
                1700, 1710, 1720, 1730, 1740, 1750,
                1800, 1810, 1820, 1830, 1840, 1850,
                1900, 1910, 1920, 1930, 1940, 1950,
                2000, 2010, 2020, 2030, 2040, 2050,
                2100, 2110, 2120, 2130, 2140, 2150,
                2200, 2210, 2220, 2230, 2240, 2250, 2300};
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

    public boolean[] getHorariosLocados() {
        return horariosLocados;
    }

    public void setHorariosLocados(boolean[] horariosLocados) {
        this.horariosLocados = horariosLocados;
    }

    public String[] getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String[] diasSemana) {
        this.diasSemana = diasSemana;
    }

    public int[] getHorarios() {
        return horarios;
    }

    public void setHorarios(int[] horarios) {
        this.horarios = horarios;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
