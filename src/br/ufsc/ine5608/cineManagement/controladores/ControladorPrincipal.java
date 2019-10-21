package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.views.TelaPrincipal;

public class ControladorPrincipal {

    private static ControladorPrincipal instancia;

    public ControladorPrincipal() {
    }

    public static ControladorPrincipal getInstancia() {
        if (instancia == null)
            instancia = new ControladorPrincipal();
        return instancia;
    }

    public void iniciaSistema() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    public void controlaMenu(String opcao) {
        if(opcao.contains("1"))
            ControladorUsuário.getInstancia().iniciaMenuUsuario();
        else if (opcao.contains("2"))
            ControladorFilme.getInstancia().iniciaMenuFilme();
    }
}
