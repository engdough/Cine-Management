package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorUsuário;
import br.ufsc.ine5608.cineManagement.models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class TelaExibeInfoUsuario extends JFrame {
    private JLabel titulo;
    private JLabel colunaCpf;
    private JLabel colunaNome;
    private JLabel colunaDataNasc;
    private JLabel colunaEmail;
    private JLabel colunaFone;
    private JLabel colunaPontos;
    private JButton botaoVoltar;
    private JLabel colunaCpf2;
    private JLabel colunaNome2;
    private JLabel colunaPontos2;
    private JLabel colunaDataNasc2;
    private JLabel colunaEmail2;
    private JLabel colunaFone2;


    public TelaExibeInfoUsuario(Usuario usuario) {
        super("Usuário: " + usuario.getNome());

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data = dateFormat.format(usuario.getDataNascimento());

        colunaCpf2 = new JLabel();
        colunaNome2 = new JLabel();
        colunaDataNasc2 = new JLabel();
        colunaEmail2 = new JLabel();
        colunaFone2 = new JLabel();
        colunaPontos2 = new JLabel();

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        colunaCpf = new JLabel();
        colunaNome = new JLabel();
        colunaDataNasc = new JLabel();
        colunaEmail = new JLabel();
        colunaFone = new JLabel();
        colunaPontos = new JLabel();
        botaoVoltar = new JButton();

        titulo.setText("Usuarios Cadastrados");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        colunaCpf.setText("CPF");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(colunaCpf, g);

        colunaNome.setText("Nome       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(colunaNome, g);

        colunaDataNasc.setText("Data de Nascimento       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 1;
        container.add(colunaDataNasc, g);

        colunaEmail.setText("Email       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 3;
        g.gridy = 1;
        container.add(colunaEmail, g);

        colunaFone.setText("Telefone       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 4;
        g.gridy = 1;
        container.add(colunaFone, g);

        colunaPontos.setText("Pontos       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 5;
        g.gridy = 1;
        container.add(colunaPontos, g);

            colunaCpf2.setText(usuario.getCpf());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = 2;
            container.add(colunaCpf2, g);

            colunaNome2.setText(usuario.getNome() + "  ");
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 1;
            g.gridy = 2;
            container.add(colunaNome2, g);

        colunaDataNasc2.setText(data);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 2;
        container.add(colunaDataNasc2, g);

        colunaEmail2.setText(usuario.getEmail() + "  ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 3;
        g.gridy = 2;
        container.add(colunaEmail2, g);

        colunaFone2.setText(usuario.getTelefone()  + "  ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 4;
        g.gridy = 2;
        container.add(colunaFone2, g);

            colunaPontos2.setText(Integer.toString(usuario.getPontos()));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 5;
            g.gridy = 2;
            container.add(colunaPontos2, g);

        botaoVoltar.setText("Voltar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        container.add(botaoVoltar, g);

        GerenciadorBotoes btManager = new GerenciadorBotoes();
        botaoVoltar.addActionListener(btManager);

        setSize(600,450);

        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);

            ControladorUsuário.getInstancia().iniciaMenuUsuario();
        }

    }
}
