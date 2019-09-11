package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorFilme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFilme extends JFrame {
    private JLabel titulo;
    private JButton cadastroFilme;
    private JButton atualizarFilme;
    private JButton excluirFilme;
    private JButton buscarFilme;
    private JButton listarFilme;
    private JButton voltar;

    public TelaFilme() {
        super("Filmes");

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        cadastroFilme = new JButton();
        atualizarFilme = new JButton();
        excluirFilme = new JButton();
        buscarFilme = new JButton();
        listarFilme = new JButton();
        voltar = new JButton();

        titulo.setText("Gerenciar Filmes");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        cadastroFilme.setText("Cadastrar Novo Filme");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(cadastroFilme, g);

        atualizarFilme.setText("Atualizar Filme");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        container.add(atualizarFilme, g);

        excluirFilme.setText("Excluir Filme");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        container.add(excluirFilme, g);

        buscarFilme.setText("Buscar Filme");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 4;
        container.add(buscarFilme, g);

        listarFilme.setText("Listar Filmes");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 5;
        container.add(listarFilme, g);

        voltar.setText("Voltar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 6;
        container.add(voltar, g);

        GerenciadorBotoes btManager = new GerenciadorBotoes();
        cadastroFilme.addActionListener(btManager);
        atualizarFilme.addActionListener(btManager);
        excluirFilme.addActionListener(btManager);
        buscarFilme.addActionListener(btManager);
        listarFilme.addActionListener(btManager);
        voltar.addActionListener(btManager);

        setSize(600,450);

        setLocationRelativeTo(null);
        setVisible(true);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class GerenciadorBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == cadastroFilme) {
                setVisible(false);
                ControladorFilme.getInstancia().executaMenuFilme("1");
            } else if (ae.getSource() == atualizarFilme) {
                setVisible(false);
                ControladorFilme.getInstancia().executaMenuFilme("2");
            } else if (ae.getSource() == excluirFilme) {
                setVisible(false);
                ControladorFilme.getInstancia().executaMenuFilme("3");
            } else if (ae.getSource() == buscarFilme) {
                setVisible(false);
                ControladorFilme.getInstancia().executaMenuFilme("4");
            } else if (ae.getSource() == listarFilme) {
                setVisible(false);
                ControladorFilme.getInstancia().executaMenuFilme("5");
            } else if (ae.getSource() == voltar) {
                setVisible(false);
                ControladorFilme.getInstancia().executaMenuFilme("6");
            }
        }
    }
}
