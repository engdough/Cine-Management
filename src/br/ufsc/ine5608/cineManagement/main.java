package br.ufsc.ine5608.cineManagement;

import br.ufsc.ine5608.cineManagement.controladores.ControladorPrincipal;

public class main {
    static ControladorPrincipal controladorPrincipal = new ControladorPrincipal();

    public static void main(String[] args) {
        controladorPrincipal.iniciaSistema();
    }
}
