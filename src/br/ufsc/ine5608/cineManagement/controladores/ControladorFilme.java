package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorFilme;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.views.*;

public class ControladorFilme {
    private static ControladorFilme instancia;
    private TelaFilme telaFilme = new TelaFilme();
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
        telaFilme.setVisible(true);
    }

    public void executaMenuFilme(String opcao) {
        if (opcao.contains("1"))
            cadastroNovoFilme();
        else if (opcao.contains("2"))
            telaAtualizaFilme();
        else if (opcao.contains("3"))
            removerFilme();
        else if (opcao.contains("5"))
            listarFilmes();
        else if (opcao.contains("6"))
            ControladorPrincipal.getInstancia().iniciaSistema();
    }

    public void cadastroNovoFilme() {
        new TelaCadastroNovoFilme();
    }

    public void telaAtualizaFilme() {
        new TelaEscolherFilmeAtualizar();
    }

    public void atualizaFilme(String codigo) {
        new TelaAtualizarFilme(mapeadorFilme.get(codigo));
    }

    public void adicionaFilme(Filme filme) {
        int codigo = geraCodigo();
        filme.setCodigo(codigo);
        mapeadorFilme.put(filme);
        iniciaMenuFilme();
    }

    public int geraCodigo(){
        int codigoNumerico = 0;
        if(!mapeadorFilme.listaVazia()){
            codigoNumerico = (mapeadorFilme.get(Integer.toString(mapeadorFilme.tamanhoLista()- 1)).getCodigo()) + 1;
        }
        return codigoNumerico;
    }

    public void excluirFilme(String codigo){
        mapeadorFilme.remove(codigo);
        iniciaMenuFilme();
    }

    public void listarFilmes() {
        new TelaListaFilmes(mapeadorFilme.getList());
    }

    public void removerFilme() {
        new TelaExcluirFilme();
    }

    public void atualizaInfoFilme(Filme filme) {
        mapeadorFilme.put(filme);
        iniciaMenuFilme();
    }
}
