package br.ufsc.ine5608.cineManagement.controladores;

import br.ufsc.ine5608.cineManagement.enums.TipoSala;
import br.ufsc.ine5608.cineManagement.mapeadores.MapeadorSala;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.views.sala.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
            listarSalas(mapeadorSala.getList());
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

        if (!verificaNomeUtilizado(nome)) {
            mapeadorSala.put(sala);
        } else {
            JOptionPane.showMessageDialog(null,"Nome de sala já utilizado!");
        }
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

    public void listarSalas(Collection<SalaCinema> salas) {
        List<String> nomes = new ArrayList<>();
        List<Integer> capacidades = new ArrayList<>();
        List<Boolean> estados = new ArrayList<>();
        List<TipoSala> tipos = new ArrayList<>();

        salas.stream().forEach(sala -> {
            nomes.add(sala.getNome());
            capacidades.add(sala.getCapacidade());
            estados.add(sala.isStatus());
            tipos.add(sala.getTipoSala());
        });

        new TelaListarSala(nomes, capacidades, estados, tipos).setVisible(true);
    }

    public boolean verificaNomeUtilizado(String nome) {
        Collection<SalaCinema> salas = mapeadorSala.getList();
        for (SalaCinema sala : salas) {
            if (sala.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}
