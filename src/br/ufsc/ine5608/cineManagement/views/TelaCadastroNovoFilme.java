package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorFilme;
import br.ufsc.ine5608.cineManagement.models.Filme;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaCadastroNovoFilme extends JFrame {
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

    public TelaCadastroNovoFilme() {
        super("Cadastro Novo Filme");

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

        titulo.setText("Cadastrar Novo Filme");
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

        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(textNome, g);

        labelDescricao.setText("Descrição");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        container.add(labelDescricao, g);

        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 2;
        container.add(textDescricao, g);

        labelClassificacao.setText("Classificação");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        container.add(labelClassificacao, g);

        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 3;
        container.add(textClassificacao, g);

        labelgenero.setText("Gênero");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 4;
        container.add(labelgenero, g);

        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 4;
        container.add(textGenero, g);

        labelDurecao.setText("Duração em minutos");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 5;
        container.add(labelDurecao, g);

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
                filme.setNome(textNome.getText() + "  ");
                filme.setDescricao(textDescricao.getText());
                filme.setClassificacaoIndicativa(textClassificacao.getText() + "  ");
                filme.setGenero(textGenero.getText() + "  ");
                filme.setDuracaoMinutos(Integer.parseInt(textDuracao.getText()));
                ControladorFilme.getInstancia().adicionaFilme(filme);
            }
        }
    }
}
