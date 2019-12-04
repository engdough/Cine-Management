package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorBomboniere;
import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorSessao;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.models.ProdutoBomboniere;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.models.Sessao;
import br.ufsc.ine5608.cineManagement.views.ingresso.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ControladorVendas {
    private static ControladorVendas instancia;
    private static MapeadorSessao mapeadorSessao;
    private static MapeadorBomboniere mapeadorBomboniere;

    public ControladorVendas () {
        this.mapeadorSessao = new MapeadorSessao();
        this.mapeadorBomboniere = new MapeadorBomboniere();
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
                new TelaVenderIngresso(sessoes).setVisible(true);
            }
        });
    }

    public void iniciaTelaEscolherLugar(Sessao sessao) {
        new TelaEscolherLugar(sessao);
    }

    public void iniciaConfirmaLugar(Sessao sessao, boolean[][] assentosEscolhidos) {
        new TelaConfirmaLugar(sessao, assentosEscolhidos);
    }

    public void encerravenda(Sessao sessao, ArrayList<String> cpfs) {
        mapeadorSessao.put(sessao);
        ControladorPrincipal.getInstancia().iniciaSistema();
        //new TelaFinalizaVEnda(sessao, cpfs);
    }

    public void iniciaVendaBomboniere() {
        Collection<ProdutoBomboniere> produtos = mapeadorBomboniere.getList();
        List<String> codigos = new ArrayList<>();
        List<String> nomes = new ArrayList<>();
        List<Integer> estoque = new ArrayList<>();
        List<Float> precos = new ArrayList<>();

        produtos.stream().forEach(produto -> {
            codigos.add(produto.getCodigoBarra());
            nomes.add(produto.getNome());
            //estoque.add(produto.getEstoque());
            precos.add(produto.getPreco());
        });

        new TelaVendaBomboniere(codigos, nomes, precos);
    }
}
