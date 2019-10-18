package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorUsuario;
import br.ufsc.ine5608.cineManagement.models.Usuario;
import br.ufsc.ine5608.cineManagement.views.*;
import br.ufsc.ine5608.cineManagement.views.usuario.TelaCadastroNovoUsuario;
import br.ufsc.ine5608.cineManagement.views.usuario.TelaUsuario;

public class ControladorUsuário {

    private static ControladorUsuário instancia;
    private TelaUsuario telaUsuario = new TelaUsuario();
    private static MapeadorUsuario mapeadorUsuario;

    public ControladorUsuário(){
        this.mapeadorUsuario = new MapeadorUsuario();
    }

    public static ControladorUsuário getInstancia() {
        if (instancia == null)
            instancia = new ControladorUsuário();
        return instancia;
    }

    public void iniciaMenuUsuario() {
        telaUsuario.setVisible(true);
    }

    public void executaMenuAdocao(String opcao) {
        if (opcao.contains("1"))
            cadastroNovoUsuario();
        else if (opcao.contains("2"))
            telaAtualizaUsuario();
        else if (opcao.contains("3"))
            removerUsuario();
        else if (opcao.contains("4"))
            buscaUsuario();
        else if (opcao.contains("5"))
            listarUsuarios();
        else if (opcao.contains("6"))
            ControladorPrincipal.getInstancia().iniciaSistema();
    }

    public void buscaUsuario(){
        new TelaBuscaUsuário();
    }

    public void exibirInfoUsuario(String cpf){
        new TelaExibeInfoUsuario(mapeadorUsuario.get(cpf));
    }

    public void cadastroNovoUsuario() {
        new TelaCadastroNovoUsuario();
    }

    public void telaAtualizaUsuario() {
        new TelaEscolherUsuarioAtualizar();
    }

    public void atualizaUsuario(String cpf) {
        new TelaAtualizarUsuario(mapeadorUsuario.get(cpf));
    }

    public void adicionaUsuario(Usuario usuario) {
        mapeadorUsuario.put(usuario);
        iniciaMenuUsuario();
    }

    public void excluirUsuario(String cpf){
        mapeadorUsuario.remove(cpf);
        iniciaMenuUsuario();
    }

    public void listarUsuarios() {
        new TelaListaUsuarios(mapeadorUsuario.getList());
    }

    public void removerUsuario() {
        new TelaExcluirUsuario();
    }

    public void atualizaInfoUsuario(Usuario usuario) {
        mapeadorUsuario.put(usuario);
        iniciaMenuUsuario();
    }
}
