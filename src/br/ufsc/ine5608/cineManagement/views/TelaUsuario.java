package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorUsuário;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaUsuario extends JFrame {
    private JLabel titulo;
    private JButton cadastroUsuario;
    private JButton atualizarUsuario;
    private JButton excluirUsuario;
    private JButton buscarUsuario;
    private JButton listarUsuarios;
    private JButton voltar;

    public TelaUsuario() {
        super("Usuários");

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        cadastroUsuario = new JButton();
        atualizarUsuario = new JButton();
        excluirUsuario = new JButton();
        buscarUsuario = new JButton();
        listarUsuarios = new JButton();
        voltar = new JButton();

        titulo.setText("Gerenciar Usuários");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        cadastroUsuario.setText("Cadastrar Novo Usuário");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(cadastroUsuario, g);

        atualizarUsuario.setText("Atualizar Usuário");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        container.add(atualizarUsuario, g);

        excluirUsuario.setText("Excluir usuário");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        container.add(excluirUsuario, g);

        buscarUsuario.setText("Buscar Usuário");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 4;
        container.add(buscarUsuario, g);

        listarUsuarios.setText("Listar Usuários");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 5;
        container.add(listarUsuarios, g);

        voltar.setText("Voltar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 6;
        container.add(voltar, g);

        GerenciadorBotoes btManager = new GerenciadorBotoes();
        cadastroUsuario.addActionListener(btManager);
        atualizarUsuario.addActionListener(btManager);
        excluirUsuario.addActionListener(btManager);
        buscarUsuario.addActionListener(btManager);
        listarUsuarios.addActionListener(btManager);
        voltar.addActionListener(btManager);

        setSize(400,300);

        setLocationRelativeTo(null);
        setVisible(true);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class GerenciadorBotoes implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == cadastroUsuario) {
                setVisible(false);
                ControladorUsuário.getInstancia().executaMenuAdocao("1");
            } else if (ae.getSource() == atualizarUsuario) {
                setVisible(false);
                ControladorUsuário.getInstancia().executaMenuAdocao("2");
            } else if (ae.getSource() == excluirUsuario) {
                setVisible(false);
                ControladorUsuário.getInstancia().executaMenuAdocao("3");
            } else if (ae.getSource() == buscarUsuario) {
                setVisible(false);
                ControladorUsuário.getInstancia().executaMenuAdocao("4");
            } else if (ae.getSource() == listarUsuarios) {
                setVisible(false);
                ControladorUsuário.getInstancia().executaMenuAdocao("5");
            } else if (ae.getSource() == voltar) {
                setVisible(false);
                ControladorUsuário.getInstancia().executaMenuAdocao("6");
            }
        }
    }
}
