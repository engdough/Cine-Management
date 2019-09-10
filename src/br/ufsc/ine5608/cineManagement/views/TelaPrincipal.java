package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JLabel label;
    private JButton botao1;
    private JButton botao2;

    public TelaPrincipal() {
        super("Cine Management");

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        label = new JLabel();
        botao1 = new JButton();
        botao2 = new JButton();

        botao1.setText("Menu Usuário");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(botao1, g);

        botao2.setText("Menu Filmes");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(botao2, g);

        GerenciadorBotoes btManager = new GerenciadorBotoes();
        botao1.addActionListener(btManager);
        botao2.addActionListener(btManager);

        setSize(300,200);

        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class GerenciadorBotoes implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == botao1){
                setVisible(false);
                ControladorPrincipal.getInstancia().controlaMenu("1");
            } else if (ae.getSource() == botao2) {
                setVisible(false);
                ControladorPrincipal.getInstancia().controlaMenu("2");
            }
        }
    }
}
