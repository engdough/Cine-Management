/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.cineManagement.views.ingresso;

import br.ufsc.ine5608.cineManagement.controladores.ControladorFilme;
import br.ufsc.ine5608.cineManagement.controladores.ControladorPrincipal;
import br.ufsc.ine5608.cineManagement.controladores.ControladorSessao;
import br.ufsc.ine5608.cineManagement.controladores.ControladorVendas;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.models.Sessao;
import br.ufsc.ine5608.cineManagement.views.sessao.TelaListarSessao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author erico
 */
public class TelaVenderIngresso extends javax.swing.JFrame {

    private JLabel titulo;
    private JLabel colunaFilme;
    private JLabel colunaSala;
    private JLabel colunaHora;
    private JButton botaoVoltar;
    /**
     * Creates new form TelaVenderIngresso
     */
    public TelaVenderIngresso(Collection<Sessao> sessoes) {
        ArrayList<JLabel> arrayColunaFilme = new ArrayList<>();
        ArrayList<JLabel> arrayColunaSala = new ArrayList<>();
        ArrayList<JLabel> arrayColunaHota = new ArrayList<>();
        ArrayList<JButton> arrayButtonDelete = new ArrayList<>();

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        colunaFilme = new JLabel();
        colunaSala = new JLabel();
        colunaHora = new JLabel();
        botaoVoltar = new JButton();

        titulo.setText("Sessões Cadastradas");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        colunaFilme.setText("Filme");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(colunaFilme, g);

        colunaSala.setText("Sala       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(colunaSala, g);

        colunaHora.setText("Hora       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 1;
        container.add(colunaHora, g);

        int i = 0;

        for (Sessao sessao: sessoes) {
            arrayColunaFilme.add(new JLabel());
            arrayColunaSala.add(new JLabel());
            arrayColunaHota.add(new JLabel());
            arrayButtonDelete.add(new JButton());

            arrayColunaFilme.get(i).setText(sessao.getFilme().getNome());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = i+2;
            container.add(arrayColunaFilme.get(i), g);

            arrayColunaSala.get(i).setText(sessao.getSala().getNome());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 1;
            g.gridy = i+2;
            container.add(arrayColunaSala.get(i), g);

            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            String hora = dateFormat.format(sessao.getHoraInicio());
            arrayColunaHota.get(i).setText(hora);
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 2;
            g.gridy = i+2;
            container.add(arrayColunaHota.get(i), g);

            arrayButtonDelete.get(i).setText("Selecionar");
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 3;
            g.gridy = i+2;
            container.add(arrayButtonDelete.get(i), g);

            int n = i;

            arrayButtonDelete.get(i).addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonActionPerformed(evt, sessao);
                }
            });

            i++;
        }

        botaoVoltar.setText("Voltar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = i + 2;
        container.add(botaoVoltar, g);

        GerenciadorBotoes btManager = new GerenciadorBotoes();
        botaoVoltar.addActionListener(btManager);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 450));
        setLocationRelativeTo(null);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt, Sessao sessao) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        ControladorVendas.getInstancia().iniciaTelaEscolherLugar(sessao);
    }

    private class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);

            ControladorPrincipal.getInstancia().iniciaSistema();
        }

    }
}
