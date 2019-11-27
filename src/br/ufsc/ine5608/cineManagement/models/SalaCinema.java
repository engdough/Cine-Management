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
    private boolean[] horariosLocados;
    private String[] diasSemana;
    private int[] horarios;


    public SalaCinema(String nome, int fileiras, int cadeirasPorFileira, TipoSala tipoSala, boolean status) {
        this.nome = nome;
        this.fileiras = fileiras;
        this.cadeirasPorFileira = cadeirasPorFileira;
        this.tipoSala = tipoSala;
        this.status = status;
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

    public SalaCinema() {
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
}
