package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorUsuário;
import br.ufsc.ine5608.cineManagement.models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class TelaListaUsuarios extends JFrame {
    private JLabel titulo;
    private JLabel colunaCpf;
    private JLabel colunaNome;
    private JLabel colunaPontos;
    private JButton botaoVoltar;

    public TelaListaUsuarios(Collection<Usuario> usuarios) {
        super("Usuários Cadastrados");

        ArrayList<JLabel> arrayColunaCpf = new ArrayList<>();
        ArrayList<JLabel> arrayColunaNome = new ArrayList<>();
        ArrayList<JLabel> arrayColunaPontos = new ArrayList<>();

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        colunaCpf = new JLabel();
        colunaNome = new JLabel();
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

        colunaPontos.setText("Pontos       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 1;
        container.add(colunaPontos, g);

        int i = 0;

        for (Usuario usuario: usuarios) {
            arrayColunaCpf.add(new JLabel());
            arrayColunaNome.add(new JLabel());
            arrayColunaPontos.add(new JLabel());

            arrayColunaCpf.get(i).setText(usuario.getCpf());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = i+2;
            container.add(arrayColunaCpf.get(i), g);

            arrayColunaNome.get(i).setText(usuario.getNome());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 1;
            g.gridy = i+2;
            container.add(arrayColunaNome.get(i), g);

            arrayColunaPontos.get(i).setText(Integer.toString(usuario.getPontos()));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 2;
            g.gridy = i+2;
            container.add(arrayColunaPontos.get(i), g);

            i++;
        }

        botaoVoltar.setText("Voltar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = i + 2;
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
