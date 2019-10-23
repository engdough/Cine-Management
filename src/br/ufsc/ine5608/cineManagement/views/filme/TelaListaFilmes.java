package br.ufsc.ine5608.cineManagement.views.filme;

import br.ufsc.ine5608.cineManagement.controladores.ControladorFilme;
import br.ufsc.ine5608.cineManagement.controladores.ControladorUsuário;
import br.ufsc.ine5608.cineManagement.models.Filme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TelaListaFilmes extends JFrame {
    private JLabel titulo;
    private JLabel colunaCodigo;
    private JLabel colunaNome;
    private JLabel colunaDuracao;
    private JButton botaoVoltar;

    public TelaListaFilmes(List<Integer> codigos, List<String> nomes, List<String> descricoes, List<String> classificacoes, List<String> generos, List<Integer> duracoes) {
        super("Filmes Cadastrados");

        ArrayList<JLabel> arrayColunaCodigo = new ArrayList<>();
        ArrayList<JLabel> arrayColunaNome = new ArrayList<>();
        ArrayList<JLabel> arrayColunaDuracao = new ArrayList<>();

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        colunaCodigo = new JLabel();
        colunaNome = new JLabel();
        colunaDuracao = new JLabel();
        botaoVoltar = new JButton();

        titulo.setText("Filmes Cadastrados");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        colunaCodigo.setText("Código");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(colunaCodigo, g);

        colunaNome.setText("Nome       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(colunaNome, g);

        colunaDuracao.setText("Gênero       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 1;
        container.add(colunaDuracao, g);

        int i = 0;

        for (String nome: nomes) {
            arrayColunaCodigo.add(new JLabel());
            arrayColunaNome.add(new JLabel());
            arrayColunaDuracao.add(new JLabel());

            arrayColunaCodigo.get(i).setText(Integer.toString(codigos.get(i)));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = i+2;
            container.add(arrayColunaCodigo.get(i), g);

            arrayColunaNome.get(i).setText(nome);
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 1;
            g.gridy = i+2;
            container.add(arrayColunaNome.get(i), g);

            arrayColunaDuracao.get(i).setText(generos.get(i));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 2;
            g.gridy = i+2;
            container.add(arrayColunaDuracao.get(i), g);

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

            ControladorFilme.getInstancia().iniciaMenuFilme();
        }

    }
}
