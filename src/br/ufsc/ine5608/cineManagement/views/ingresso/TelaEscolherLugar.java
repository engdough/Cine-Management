package br.ufsc.ine5608.cineManagement.views.ingresso;

import br.ufsc.ine5608.cineManagement.controladores.ControladorPrincipal;
import br.ufsc.ine5608.cineManagement.controladores.ControladorSessao;
import br.ufsc.ine5608.cineManagement.controladores.ControladorVendas;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.models.Sessao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class TelaEscolherLugar extends JFrame {

    private JLabel titulo;
    private JLabel[] fileiras;
    private String[] nomeFileiras;
    private JRadioButton[][] assentos;
    private JButton botaoVoltar;
    private JButton botaoOk;
    private Sessao sessao;

    public TelaEscolherLugar (Sessao sessao) {
        this.sessao = sessao;
        this.nomeFileiras = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        this.fileiras = new JLabel[26];
        this.assentos = new JRadioButton[sessao.getLugares().length][sessao.getLugares()[0].length];
        for (int i=0; i<nomeFileiras.length; i++){
            this.fileiras[i] = new JLabel();
        }

        for (int i=0; i<sessao.getLugares().length; i++) {
            for (int j=0; j<sessao.getLugares()[i].length; j++) {
                int k = i;
                int l = j;
                this.assentos[i][j] = new JRadioButton();
                this.assentos[i][j].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jRadioButtonActionPerformed(evt, k, l);
                    }
                });
            }
        }

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        botaoVoltar = new JButton();
        botaoOk = new JButton();
        titulo = new JLabel();

        titulo.setText("Escolha o local");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        for (int i=0; i<sessao.getLugares().length; i++) {
            this.fileiras[i].setText(this.nomeFileiras[i]);
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 2;
            g.gridy = i + 1;
            container.add(this.fileiras[i], g);
            for (int j=0; j<sessao.getLugares()[i].length; j++) {
                assentos[i][j].setText(Integer.toString(j+1));
                if (sessao.getLugares()[i][j]){
                    assentos[i][j].setEnabled(false);
                }
                g.fill = GridBagConstraints.HORIZONTAL;
                g.gridx = j + 3;
                g.gridy = i + 1;
                container.add(assentos[i][j], g);
            }
        }

        botaoVoltar.setText("Voltar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = sessao.getLugares().length;
        container.add(botaoVoltar, g);

        botaoOk.setText("OK");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = sessao.getLugares().length;
        container.add(botaoOk, g);

        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 450));
        setLocationRelativeTo(null);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void jRadioButtonActionPerformed(java.awt.event.ActionEvent evt, int i, int j) {//GEN-FIRST:event_jButton4ActionPerformed
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
        ControladorPrincipal.getInstancia().iniciaSistema();
    }

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int k = 0;
        boolean[][] assentosEscolhidos = new boolean[sessao.getLugares().length][sessao.getLugares()[0].length];
        for (int i=0; i<sessao.getLugares().length; i++){
            for (int j=0; j<sessao.getLugares()[i].length; j++){
                if (assentos[i][j].isSelected()){
                    sessao.getLugares()[i][j] = true;
                    assentosEscolhidos[i][j] = true;
                    k++;
                }
            }
        }

        if (k == 0) {
            JOptionPane.showMessageDialog(null, "Selecione pelo menos um lugar!");
        } else {
            setVisible(false);
            ControladorVendas.getInstancia().iniciaConfirmaLugar(sessao, assentosEscolhidos);
        }
    }
}
