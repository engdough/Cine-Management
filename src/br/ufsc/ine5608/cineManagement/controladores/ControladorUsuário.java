package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorUsuario;
import br.ufsc.ine5608.cineManagement.views.TelaUsuario;

public class ControladorUsuário {

    private static ControladorUsuário instancia;
    private TelaUsuario telaUsuario = new TelaUsuario();
    private static MapeadorUsuario mapeadorUsuario;

    public ControladorUsuário(){

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
        if (opcao.contains("6"))
            ControladorPrincipal.getInstancia().iniciaSistema();
    }
}
