package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorBomboniere;
import br.ufsc.ine5608.cineManagement.models.ProdutoBomboniere;
import br.ufsc.ine5608.cineManagement.models.Usuario;
import br.ufsc.ine5608.cineManagement.views.bomboniere.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControladorBomboniere {
    private static ControladorBomboniere instancia;
    private static MapeadorBomboniere mapeadorBomboniere;

    public ControladorBomboniere() {
        this.mapeadorBomboniere = new MapeadorBomboniere();
    }

    public static ControladorBomboniere getInstancia() {
        if (instancia == null)
            instancia = new ControladorBomboniere();
        return instancia;
    }

    public void iniciaMenuBomboniere() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProdutoBomboniere().setVisible(true);
            }
        });
    }

    public void executaMenuBomboniere(String opcao) {
        if (opcao.contains("1")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaCadastroProdutoBomboniere().setVisible(true);
                }
            });
        } else if (opcao.contains("2")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaBuscarProdutoBomboniere().setVisible(true);
                }
            });
        } else if (opcao.contains("3")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaExcluirProdutoBomboniere().setVisible(true);
                }
            });
        } else if (opcao.contains("4")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaBuscaBomboniereExibirInfo().setVisible(true);
                }
            });
        } else if (opcao.contains("5")) {
            listarProdutos(mapeadorBomboniere.getList());
        } else if (opcao.contains("6")) {
            ControladorPrincipal.getInstancia().iniciaSistema();
        }
    }

    public void addProduto(String nome, String descricao, String preco, String codigo) {
        ProdutoBomboniere produto = new ProdutoBomboniere();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        //produto.setEstoque(Integer.parseInt(estoque));
        produto.setPreco(Float.parseFloat(preco));
        produto.setCodigoBarra(codigo);
        mapeadorBomboniere.put(produto);
        iniciaMenuBomboniere();
    }

    public void atualizaInfoProduto(String nome, String descricao, String preco, String codigo) {
        ProdutoBomboniere produto = new ProdutoBomboniere();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        //produto.setEstoque(Integer.parseInt(estoque));
        produto.setPreco(Float.parseFloat(preco));
        produto.setCodigoBarra(codigo);
        mapeadorBomboniere.put(produto);
        iniciaMenuBomboniere();
    }

    public void atualizaProduto(String codigo) {
        ProdutoBomboniere produto = mapeadorBomboniere.get(codigo);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAtualizaProdutoBomboniere(produto.getNome(), produto.getDescricao(), produto.getPreco(),produto.getCodigoBarra()).setVisible(true);
            }
        });
    }

    public void excluirProduto(String codigo) {
        mapeadorBomboniere.remove(codigo);
        iniciaMenuBomboniere();
    }

    public void exibirInfoBomboniere(String codigo) {
        ProdutoBomboniere produto = mapeadorBomboniere.get(codigo);
        new TelaExibeInfoBomboniere(produto.getCodigoBarra(), produto.getNome(), produto.getPreco());
    }

    public void listarProdutos(Collection<ProdutoBomboniere> produtos) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListaProdutoBomboniere(codigos, nomes, estoque, precos).setVisible(true);
            }
        });
    }

    public boolean verificacodigo(String codigo){
        Collection<ProdutoBomboniere> produtos = mapeadorBomboniere.getList();
        for (ProdutoBomboniere produto : produtos) {
            if (produto.getCodigoBarra().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
}
