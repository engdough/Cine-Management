package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorSessao;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.models.Sessao;
import br.ufsc.ine5608.cineManagement.views.ingresso.TelaEscolherLugar;
import br.ufsc.ine5608.cineManagement.views.ingresso.TelaVenderIngresso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ControladorVendas {
    private static ControladorVendas instancia;
    private static MapeadorSessao mapeadorSessao;

    public ControladorVendas () {
        this.mapeadorSessao = new MapeadorSessao();
    }

    public static ControladorVendas getInstancia() {
        if (instancia == null)
            instancia = new ControladorVendas();
        return instancia;
    }

    public void iniciaVendaIngresso() {
        Collection<Sessao> sessoes = mapeadorSessao.getList();

        List<Filme> filmes = new ArrayList<>();
        List<SalaCinema> salas = new ArrayList<>();
        List<Date> horarios = new ArrayList<>();

        sessoes.stream().forEach(sessao -> {
            filmes.add(sessao.getFilme());
            salas.add(sessao.getSala());
            horarios.add(sessao.getHoraInicio());
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVenderIngresso(filmes, salas, horarios).setVisible(true);
            }
        });
    }

    public void iniciaTelaEscolherLugar(SalaCinema salas, Filme filme, Date data) {
        new TelaEscolherLugar(salas, filme, data);
    }
}
