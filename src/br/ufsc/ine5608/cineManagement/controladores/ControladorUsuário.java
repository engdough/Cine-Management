package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorUsuario;
import br.ufsc.ine5608.cineManagement.models.Usuario;
import br.ufsc.ine5608.cineManagement.views.usuario.*;

import java.util.Date;

public class ControladorUsuário {

    private static ControladorUsuário instancia;
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuario().setVisible(true);
            }
        });
    }

    public void executaMenuUsuario(String opcao) {
        if (opcao.contains("1")){
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(TelaCadastroNovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(TelaCadastroNovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(TelaCadastroNovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(TelaCadastroNovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaCadastroNovoUsuario().setVisible(true);
                }
            });
        }
        else if (opcao.contains("2")){
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaEscolherUsuarioAtualizar().setVisible(true);
                }
            });
        }
        else if (opcao.contains("3")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaExcluirUsuario().setVisible(true);
                }
            });
        }
        else if (opcao.contains("4")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaBuscarUsuario().setVisible(true);
                }
            });
        }
        else if (opcao.contains("5"))
            new TelaListaUsuarios(mapeadorUsuario.getList());
        else if (opcao.contains("6"))
            ControladorPrincipal.getInstancia().iniciaSistema();
    }

    public void exibirInfoUsuario(String cpf){
        new TelaExibeInfoUsuario(mapeadorUsuario.get(cpf));
    }

    public void atualizaUsuario(String cpf) {
        Usuario usuario = mapeadorUsuario.get(cpf);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAtualizaUsuario(usuario.getCpf(), usuario.getDataNascimento(), usuario.getTelefone(), usuario.getNome(), usuario.getEmail()).setVisible(true);
            }
        });
    }

    public void adicionaUsuario(String CPF, Date dataNasc, String telefone, String nome, String email) {
        Usuario usuario = new Usuario();
        usuario.setCpf(CPF);
        usuario.setDataNascimento(dataNasc);
        usuario.setTelefone(telefone);
        usuario.setNome(nome);
        usuario.setEmail(email);
        mapeadorUsuario.put(usuario);
        iniciaMenuUsuario();
    }

    public void excluirUsuario(String cpf){
        mapeadorUsuario.remove(cpf);
        iniciaMenuUsuario();
    }

    public void atualizaInfoUsuario(String CPF, Date dataNasc, String telefone, String nome, String email) {
        Usuario usuario = new Usuario();
        usuario.setCpf(CPF);
        usuario.setDataNascimento(dataNasc);
        usuario.setTelefone(telefone);
        usuario.setNome(nome);
        usuario.setEmail(email);
        mapeadorUsuario.put(usuario);
        iniciaMenuUsuario();
    }
}
