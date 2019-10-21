package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorFilme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaExcluirFilme extends JFrame {
    private JLabel titulo;
    private JLabel labelCodigo;
    private JTextField textCodigo;
    private JButton botaoExcluir;
    private JButton botaoCancelar;

    public TelaExcluirFilme() {
        super("Excluir Filme");

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        labelCodigo = new JLabel();
        textCodigo = new JTextField();
        botaoExcluir = new JButton();
        botaoCancelar = new JButton();

        titulo.setText("Excluir Filme");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        labelCodigo.setText("Código");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(labelCodigo, g);

        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(textCodigo, g);

        botaoCancelar.setText("Cancelar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        container.add(botaoCancelar, g);

        botaoExcluir.setText("Excluir");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 2;
        container.add(botaoExcluir, g);

        GerenciadorBotoes btManager = new GerenciadorBotoes();
        botaoCancelar.addActionListener(btManager);
        botaoExcluir.addActionListener(btManager);

        setSize(600,450);

        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class GerenciadorBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == botaoCancelar){
                setVisible(false);
                ControladorFilme.getInstancia().iniciaMenuFilme();
            } else if (ae.getSource() == botaoExcluir){
                setVisible(false);
                ControladorFilme.getInstancia().excluirFilme(textCodigo.getText());
            }
        }
    }
}