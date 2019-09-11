package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.views.TelaPrincipal;

public class ControladorPrincipal {

    private static ControladorPrincipal instancia;
    private TelaPrincipal telaPrincipal = new TelaPrincipal();

    public ControladorPrincipal() {
    }

    public static ControladorPrincipal getInstancia() {
        if (instancia == null)
            instancia = new ControladorPrincipal();
        return instancia;
    }

    public void iniciaSistema() {
        telaPrincipal.setVisible(true);
    }

    public void controlaMenu(String opcao) {
        if(opcao.contains("1"))
            ControladorUsuário.getInstancia().iniciaMenuUsuario();
        else if (opcao.contains("2"))
            ControladorFilme.getInstancia().iniciaMenuFilme();
    }
}
