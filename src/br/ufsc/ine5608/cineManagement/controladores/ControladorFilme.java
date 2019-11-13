package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorFilme;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.views.*;
import br.ufsc.ine5608.cineManagement.views.filme.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControladorFilme {
    private static ControladorFilme instancia;
    private static MapeadorFilme mapeadorFilme;

    public ControladorFilme() {
        this.mapeadorFilme = new MapeadorFilme();
    }

    public static ControladorFilme getInstancia() {
        if (instancia == null)
            instancia = new ControladorFilme();
        return instancia;
    }

    public void iniciaMenuFilme() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFilme().setVisible(true);
            }
        });
    }

    public void executaMenuFilme(String opcao) {
        if (opcao.contains("1")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaCadastraFilme().setVisible(true);
                }
            });
        }
        else if (opcao.contains("2")) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(TelaEscolherFilmeAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(TelaEscolherFilmeAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(TelaEscolherFilmeAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(TelaEscolherFilmeAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaEscolherFilmeAtualizar().setVisible(true);
                }
            });
        }
        else if (opcao.contains("4")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaBuscarFilme().setVisible(true);
                }
            });
        }
        else if (opcao.contains("5"))
            listarFilmes(mapeadorFilme.getList());
        else if (opcao.contains("6"))
            ControladorPrincipal.getInstancia().iniciaSistema();
    }

    public void exibirInfoFilme(String codigo) {
        new TelaExibeInfoFilme(mapeadorFilme.get(codigo));
    }

    public void atualizaFilme(String codigo) {
        Filme filme = mapeadorFilme.get(codigo);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAtualizaFilme(codigo, filme.getNome(), filme.getDescricao(), filme.getDescricao(), filme.getGenero(), filme.getDuracaoMinutos()).setVisible(true);
            }
        });
    }

    public void adicionaFilme(String nome, String descricao, String classificacao, String genero, int duracao) {
        int codigo = geraCodigo();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        filme.setNome(nome);
        filme.setDescricao(descricao);
        filme.setClassificacaoIndicativa(classificacao);
        filme.setGenero(genero);
        filme.setDuracaoMinutos(duracao);
        mapeadorFilme.put(filme);
        iniciaMenuFilme();
    }

    public int geraCodigo(){
        int codigoNumerico = 1;
        Filme[] filmes = mapeadorFilme.getList().toArray(new Filme[mapeadorFilme.tamanhoLista() - 1]);
        if(!mapeadorFilme.listaVazia()){
            codigoNumerico = filmes[filmes.length - 1].getCodigo() + 1;
        }
        return codigoNumerico;
    }

    public void excluirFilme(String codigo){
        mapeadorFilme.remove(codigo);
        listarFilmes(mapeadorFilme.getList());
    }

    public void atualizaInfoFilme(String codigo, String nome, String descricao, String classificacao, String genero, int duracao) {
        Filme filme = new Filme();
        filme.setCodigo(Integer.parseInt(codigo));
        filme.setNome(nome);
        filme.setDescricao(descricao);
        filme.setClassificacaoIndicativa(classificacao);
        filme.setGenero(genero);
        filme.setDuracaoMinutos(duracao);
        mapeadorFilme.put(filme);
        iniciaMenuFilme();
    }

    public void listarFilmes(Collection<Filme> filmes){
        List<Integer> codigos = new ArrayList<>();
        List<String> nomes = new ArrayList<>();
        List<String> descricoes = new ArrayList<>();
        List<String> classificacoes = new ArrayList<>();
        List<String> generos = new ArrayList<>();
        List<Integer> duracoes = new ArrayList<>();

        filmes.stream().forEach(filme -> {
            codigos.add(filme.getCodigo());
            nomes.add(filme.getNome());
            descricoes.add(filme.getDescricao());
            classificacoes.add(filme.getClassificacaoIndicativa());
            generos.add(filme.getGenero());
            duracoes.add(filme.getDuracaoMinutos());
        });

        new TelaListaFilmes(codigos, nomes, descricoes, classificacoes, generos, duracoes);
    }
}
