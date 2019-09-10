package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JLabel titulo;
    private JButton menuUsuario;
    private JButton menuFilme;

    public TelaPrincipal() {
        super("Cine Management");

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        menuUsuario = new JButton();
        menuFilme = new JButton();

        titulo.setText("Menu Principal");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        menuUsuario.setText("Menu Usuário");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(menuUsuario, g);

        menuFilme.setText("Menu Filmes");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        container.add(menuFilme, g);

        GerenciadorBotoes btManager = new GerenciadorBotoes();
        menuUsuario.addActionListener(btManager);
        menuFilme.addActionListener(btManager);

        setSize(300,200);

        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class GerenciadorBotoes implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == menuUsuario){
                setVisible(false);
                ControladorPrincipal.getInstancia().controlaMenu("1");
            } else if (ae.getSource() == menuFilme) {
                setVisible(false);
                ControladorPrincipal.getInstancia().controlaMenu("2");
            }
        }
    }
}
