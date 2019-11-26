package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorFilme;
import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorSala;
import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorSessao;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.models.Sessao;
import br.ufsc.ine5608.cineManagement.views.sessao.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ControladorSessao {
    private static ControladorSessao instancia;
    private static MapeadorSessao mapeadorSessao;
    private static MapeadorFilme mapeadorFilme;
    private static MapeadorSala mapeadorSala;

    public ControladorSessao() {
        this.mapeadorSessao = new MapeadorSessao();
        this.mapeadorFilme = new MapeadorFilme();
        this.mapeadorSala = new MapeadorSala();
    }

    public static ControladorSessao getInstancia() {
        if (instancia == null)
            instancia = new ControladorSessao();
        return instancia;
    }

    public void iniciaMenuSessao() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSessao().setVisible(true);
            }
        });
    }

    public void executaMenuSessao(String opcao) {
        if (opcao.contains("1")){
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Collection<Filme> filmes = mapeadorFilme.getList();
                    String[] arrayFilmes = new String[filmes.size()];
                    Collection<SalaCinema> salas = mapeadorSala.getList();
                    String[] arraySala = new String[salas.size()];
                    int i = 0;
                    while (i < filmes.size()) {
                        for (Filme filme: filmes) {
                            arrayFilmes[i] = filme.getNome();
                            i++;
                        }
                    }
                    int j = 0;
                    while (j < salas.size()) {
                        for (SalaCinema sala : salas) {
                            arraySala[j] = sala.getNome();
                            j++;
                        }
                    }
                    new TelaCadastroSessao(arrayFilmes, arraySala).setVisible(true);
                }
            });
        } else if (opcao.contains("2")){
            listarSessoes(mapeadorSessao.getList());
        } else if (opcao.contains("3")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaBuscaSessão().setVisible(true);
                }
            });
        }
    }

    public void adicionaSessao(String filme, String sala, String horario) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date horaInicio = null;
        Collection<Filme> filmes = mapeadorFilme.getList();
        Sessao sessao = new Sessao();
        filmes.stream().forEach(response -> {
            if (response.getNome().contains(filme))
                sessao.setFilme(response);
        });

        Collection<SalaCinema> salas = mapeadorSala.getList();
        salas.stream().forEach(response -> {
            if (response.getNome().contains(sala))
                sessao.setSala(response);
        });

        try {
            Date date = formatter.parse(horario);
            horaInicio = date;
        } catch (ParseException e){
            e.printStackTrace();
        }

        sessao.setHoraInicio(horaInicio);
        sessao.setCodigo(geraCodigo());
        mapeadorSessao.put(sessao);
        iniciaMenuSessao();
    }

    public void atualizaSessao(String codigo) {
        Sessao sessao = mapeadorSessao.get(codigo);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String hora = dateFormat.format(sessao.getHoraInicio());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAtualizaSessao(sessao.getFilme().getNome(), sessao.getSala().getNome(),hora, sessao.getCodigo()).setVisible(true);
            }
        });
    }

    public void atualizaInfoSessao(String filme, String sala, String horario, String codigo) {
        Sessao sessao = mapeadorSessao.get(codigo);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date horaInicio = null;
        Collection<Filme> filmes = mapeadorFilme.getList();
        filmes.stream().forEach(response -> {
            if (response.getNome().contains(filme))
                sessao.setFilme(response);
        });

        Collection<SalaCinema> salas = mapeadorSala.getList();
        salas.stream().forEach(response -> {
            if (response.getNome().contains(sala))
                sessao.setSala(response);
        });

        try {
            Date date = formatter.parse(horario);
            horaInicio = date;
        } catch (ParseException e){
            e.printStackTrace();
        }

        sessao.setHoraInicio(horaInicio);

        mapeadorSessao.put(sessao);
        iniciaMenuSessao();
    }

    public void listarSessoes(Collection<Sessao> sessoes) {
        List<Filme> filmes = new ArrayList<>();
        List<SalaCinema> salas = new ArrayList<>();
        List<Date> horarios = new ArrayList<>();

        sessoes.stream().forEach(sessao -> {
            filmes.add(sessao.getFilme());
            salas.add(sessao.getSala());
            horarios.add(sessao.getHoraInicio());
        });

        new TelaListarSessao(filmes, salas, horarios).setVisible(true);
    }

    public String geraCodigo(){
        int codigoNumerico = 1;
        if(!mapeadorSessao.listaVazia()){
            codigoNumerico = Integer.parseInt(mapeadorSessao.get(Integer.toString(mapeadorSessao.getList().size())).getCodigo()) + 1;
        }
        return Integer.toString(codigoNumerico);
    }

    public boolean verificaFilme(String filme){
        Collection<Filme> filmes = mapeadorFilme.getList();
        for (Filme response: filmes){
            if (response.getNome().contains(filme)){
                return true;
            }
        }
        return false;
    }

    public boolean verificasala(String sala){
        Collection<SalaCinema> salas = mapeadorSala.getList();
        for (SalaCinema response: salas){
            if (response.getNome().contains(sala)){
                return true;
            }
        }
        return false;
    }

    public boolean verificaCodigo(String codigo) {
        Collection<Sessao> sessoes = mapeadorSessao.getList();
        for (Sessao sessao: sessoes) {
            if (sessao.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
}
