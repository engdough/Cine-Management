package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorFilme;
import br.ufsc.ine5608.cineManagement.models.Filme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAtualizarFilme extends JFrame {
    private JLabel titulo;
    private JLabel tituloAux;
    private JLabel labelNome;
    private JTextField textNome;
    private JLabel labelDescricao;
    private JTextField textDescricao;
    private JLabel labelClassificacao;
    private JTextField textClassificacao;
    private JLabel labelgenero;
    private JTextField textGenero;
    private JLabel labelDurecao;
    private JTextField textDuracao;
    private JButton botaoCancelar;
    private JButton botaoOk;
    private int codigoFilme;

    public TelaAtualizarFilme(Filme filme) {
        super("Atualizar Filme");
        this.codigoFilme = filme.getCodigo();

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        labelNome = new JLabel();
        tituloAux = new JLabel();
        textNome = new JTextField();
        labelDescricao = new JLabel();
        textDescricao = new JTextField();
        labelClassificacao = new JLabel();
        textClassificacao = new JTextField();
        labelgenero = new JLabel();
        textGenero = new JTextField();
        labelDurecao = new JLabel();
        textDuracao = new JTextField();
        botaoOk = new JButton();
        botaoCancelar = new JButton();

        titulo.setText("Atualizar Filme");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        tituloAux.setText(" (O preenchimento de todos os campos são orbrigatórios)");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 0;
        container.add(tituloAux, g);

        labelNome.setText("Nome do Filme");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(labelNome, g);

        textNome.setText(filme.getNome());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(textNome, g);

        labelDescricao.setText("Descrição");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        container.add(labelDescricao, g);

        textDescricao.setText(filme.getDescricao());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 2;
        container.add(textDescricao, g);

        labelClassificacao.setText("Classificação Indicativa");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        container.add(labelClassificacao, g);


        textClassificacao.setText(filme.getClassificacaoIndicativa());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 3;
        container.add(textClassificacao, g);

        labelgenero.setText("Genero");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 4;
        container.add(labelgenero, g);

        textGenero.setText(filme.getGenero());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 4;
        container.add(textGenero, g);

        labelDurecao.setText("Duração em minutos");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 5;
        container.add(labelDurecao, g);

        textDuracao.setText(Integer.toString(filme.getDuracaoMinutos()));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 5;
        container.add(textDuracao, g);

        botaoCancelar.setText("Cancelar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 6;
        container.add(botaoCancelar, g);

        botaoOk.setText("Salvar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 6;
        container.add(botaoOk, g);

        GerenciadorBotoes btManager = new GerenciadorBotoes();
        botaoOk.addActionListener(btManager);
        botaoCancelar.addActionListener(btManager);

        setSize(600, 450);

        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class GerenciadorBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Filme filme = new Filme();
            if (ae.getSource() == botaoCancelar) {
                setVisible(false);
                ControladorFilme.getInstancia().iniciaMenuFilme();
            } else if (ae.getSource() == botaoOk) {
                setVisible(false);
                filme.setCodigo(codigoFilme);
                filme.setNome(textNome.getText() + "  ");
                filme.setDescricao(textDescricao.getText());
                filme.setClassificacaoIndicativa(textClassificacao.getText() + "  ");
                filme.setGenero(textGenero.getText() + "  ");
                filme.setDuracaoMinutos(Integer.parseInt(textDuracao.getText()));
                ControladorFilme.getInstancia().atualizaInfoFilme(filme);
            }
        }
    }
}
