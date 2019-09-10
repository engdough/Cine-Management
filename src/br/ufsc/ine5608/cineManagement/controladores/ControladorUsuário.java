package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorUsuario;
import br.ufsc.ine5608.cineManagement.models.ConteudoTelaNovoUsuario;
import br.ufsc.ine5608.cineManagement.models.Usuario;
import br.ufsc.ine5608.cineManagement.views.TelaCadastroNovoUsuario;
import br.ufsc.ine5608.cineManagement.views.TelaListaUsuarios;
import br.ufsc.ine5608.cineManagement.views.TelaUsuario;

public class ControladorUsuário {

    private static ControladorUsuário instancia;
    private TelaUsuario telaUsuario = new TelaUsuario();
    private TelaCadastroNovoUsuario telaCadastroNovoUsuario = new TelaCadastroNovoUsuario();
    private TelaListaUsuarios telaListaUsuarios;
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
        desativaTelas();
        telaUsuario.setVisible(true);
    }

    public void executaMenuAdocao(String opcao) {
        if (opcao.contains("1"))
            cadastroNovoUsuario();
        else if (opcao.contains("5"))
            listarUsuarios();
        else if (opcao.contains("6"))
            ControladorPrincipal.getInstancia().iniciaSistema();
    }

    public void cadastroNovoUsuario() {
        telaCadastroNovoUsuario.setVisible(true);
    }

    public void listarUsuarios() {
        telaListaUsuarios = new TelaListaUsuarios(mapeadorUsuario.getList());
        telaListaUsuarios.setVisible(true);
    }

    public void adicionaUsuario(ConteudoTelaNovoUsuario usuario) {
        Usuario novoUsuario = desempacotaUsuario(usuario);
        mapeadorUsuario.put(novoUsuario);
        iniciaMenuUsuario();
    }

    public Usuario desempacotaUsuario(ConteudoTelaNovoUsuario usuario) {
        return new Usuario(usuario.getNome(), usuario.getCPF(), null, usuario.getEmail(), usuario.getTelefone());
    }

    public void desativaTelas() {
        telaCadastroNovoUsuario.setVisible(false);
    }
}
