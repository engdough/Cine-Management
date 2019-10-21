package br.ufsc.ine5608.cineManagement.views.filme;

import br.ufsc.ine5608.cineManagement.controladores.ControladorFilme;
import br.ufsc.ine5608.cineManagement.models.Filme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class TelaExibeInfoFilme extends JFrame {
    private JLabel titulo;
    private JLabel colunaCodigo;
    private JLabel colunaNome;
    private JLabel colunaGenero;
    private JLabel colunaClassificacao;
    private JLabel colunaDuracao;
    private JButton botaoVoltar;
    private JLabel colunaCodigo2;
    private JLabel colunaNome2;
    private JLabel colunaGenero2;
    private JLabel colunaClassificacao2;
    private JLabel colunaDuracao2;

    public TelaExibeInfoFilme(Filme filme) {
        super("Filme: " + filme.getNome());

        colunaCodigo2 = new JLabel();
        colunaNome2 = new JLabel();
        colunaGenero2 = new JLabel();
        colunaClassificacao2 = new JLabel();
        colunaDuracao2 = new JLabel();

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        colunaCodigo = new JLabel();
        colunaNome = new JLabel();
        colunaGenero = new JLabel();
        colunaClassificacao = new JLabel();
        colunaDuracao = new JLabel();
        botaoVoltar = new JButton();

        titulo.setText("Informações Filme");
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

        colunaGenero.setText("Gênero       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 1;
        container.add(colunaGenero, g);

        colunaClassificacao.setText("Classificação       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 3;
        g.gridy = 1;
        container.add(colunaClassificacao, g);

        colunaDuracao.setText("Duração       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 4;
        g.gridy = 1;
        container.add(colunaDuracao, g);

            colunaCodigo2.setText(Integer.toString(filme.getCodigo()));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = 2;
            container.add(colunaCodigo2, g);

            colunaNome2.setText(filme.getNome());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 1;
            g.gridy = 2;
            container.add(colunaNome2, g);

        colunaGenero2.setText(filme.getGenero());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 2;
        container.add(colunaGenero2, g);

        colunaClassificacao2.setText(filme.getClassificacaoIndicativa());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 3;
        g.gridy = 2;
        container.add(colunaClassificacao2, g);

            colunaDuracao2.setText(Integer.toString(filme.getDuracaoMinutos()));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 4;
            g.gridy = 2;
            container.add(colunaDuracao2, g);

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

            ControladorFilme.getInstancia().iniciaMenuFilme();
        }

    }
}
