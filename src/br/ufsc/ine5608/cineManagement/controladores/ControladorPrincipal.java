package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorSessao;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.models.Sessao;
import br.ufsc.ine5608.cineManagement.views.TelaPrincipal;
import br.ufsc.ine5608.cineManagement.views.TelaVendas;
import br.ufsc.ine5608.cineManagement.views.ingresso.TelaVenderIngresso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ControladorPrincipal {

    private static ControladorPrincipal instancia;
    private static MapeadorSessao mapeadorSessao;

    public ControladorPrincipal() {
        this.mapeadorSessao = new MapeadorSessao();
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
        else if (opcao.contains("3"))
            ControladorBomboniere.getInstancia().iniciaMenuBomboniere();
        else if (opcao.contains("4"))
            ControladorSala.getInstancia().iniciaMenuSala();
        else if (opcao.contains("5"))
            ControladorSessao.getInstancia().iniciaMenuSessao();
        else if (opcao.contains("6")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaVendas().setVisible(true);
                }
            });
        }
    }
}
