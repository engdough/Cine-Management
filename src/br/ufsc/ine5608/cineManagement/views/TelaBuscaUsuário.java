package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorUsuário;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaBuscaUsuário extends JFrame{
    private JLabel titulo;
    private JLabel labelCpf;
    private JTextField textCpf;
    private JButton botaoOk;
    private JButton botaoCancelar;

    public TelaBuscaUsuário() {
        super("Buscar usuário");

        titulo = new JLabel();
        labelCpf = new JLabel();
        textCpf = new JTextField();
        botaoOk = new JButton();
        botaoCancelar = new JButton();

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo.setText("Buscar Usuário");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        labelCpf.setText("CPF");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(labelCpf, g);

        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(textCpf, g);

        botaoCancelar.setText("Cancelar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        container.add(botaoCancelar, g);

        botaoOk.setText("OK");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 2;
        container.add(botaoOk, g);

        GerenciadorBotoes btManager = new GerenciadorBotoes();
        botaoOk.addActionListener(btManager);
        botaoCancelar.addActionListener(btManager);

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
                ControladorUsuário.getInstancia().iniciaMenuUsuario();
            } else if (ae.getSource() == botaoOk) {
                setVisible(false);
                ControladorUsuário.getInstancia().exibirInfoUsuario(textCpf.getText());
            }
        }
    }
}
