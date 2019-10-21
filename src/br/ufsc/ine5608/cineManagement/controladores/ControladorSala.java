package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.enums.TipoSala;
import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorSala;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.views.sala.*;

public class ControladorSala {
    private static ControladorSala instancia;
    private static MapeadorSala mapeadorSala;

    public ControladorSala() {
        this.mapeadorSala = new MapeadorSala();
    }

    public static ControladorSala getInstancia() {
        if (instancia == null)
            instancia = new ControladorSala();
        return instancia;
    }

    public void iniciaMenuSala() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSala().setVisible(true);
            }
        });
    }

    public void executaMenuSala(String opcao) {
        if (opcao.contains("1")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaCadastroSalas().setVisible(true);
                }
            });
        } else if (opcao.contains("2")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaBucaSala().setVisible(true);
                }
            });
        } else if (opcao.contains("3")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaExcluirSala().setVisible(true);
                }
            });
        } else if (opcao.contains("4")) {
            new TelaListarSala(mapeadorSala.getList()).setVisible(true);
        }
    }

    public void cadastraNovaSala(String nome, String capacidade, int tipoSala, int estadoSala) {
        SalaCinema sala = new SalaCinema();
        sala.setNome(nome);
        sala.setCapacidade(Integer.parseInt(capacidade));
        if (estadoSala == 0)
            sala.setStatus(true);
        else
            sala.setStatus(false);
        if (tipoSala == 0)
            sala.setTipoSala(TipoSala.TIPO_NORMAL);
        else
            sala.setTipoSala(TipoSala.TIPO_3D);
        mapeadorSala.put(sala);
        iniciaMenuSala();
    }

    public void atualizaSala(String nome) {
        SalaCinema sala = mapeadorSala.get(nome);
        String nomeSala = sala.getNome();
        String capacidade = Integer.toString(sala.getCapacidade());
        boolean estado = sala.isStatus();
        TipoSala tipo = sala.getTipoSala();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAtualizarSalas(nomeSala, capacidade, estado, tipo).setVisible(true);
            }
        });
    }

    public void salvaSalaAtualizada(String nomeSala, String capacidade, int estado, int tipo) {
        SalaCinema sala = new SalaCinema();
        sala.setNome(nomeSala);
        sala.setCapacidade(Integer.parseInt(capacidade));
        if (estado == 0)
            sala.setStatus(true);
        else
            sala.setStatus(false);
        if (tipo == 0)
            sala.setTipoSala(TipoSala.TIPO_NORMAL);
        else
            sala.setTipoSala(TipoSala.TIPO_3D);
        mapeadorSala.put(sala);
        iniciaMenuSala();
    }

    public void excluirSala(String nome) {
        mapeadorSala.remove(nome);
        iniciaMenuSala();
    }
}
