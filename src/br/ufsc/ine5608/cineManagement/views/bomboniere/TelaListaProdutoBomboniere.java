package br.ufsc.ine5608.cineManagement.views.bomboniere;

import br.ufsc.ine5608.cineManagement.controladores.ControladorBomboniere;
import br.ufsc.ine5608.cineManagement.controladores.ControladorFilme;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.models.ProdutoBomboniere;
import br.ufsc.ine5608.cineManagement.views.filme.TelaListaFilmes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class TelaListaProdutoBomboniere extends JFrame {
    private JLabel titulo;
    private JLabel colunaCodigo;
    private JLabel colunaNome;
    private JLabel colunaEstoque;
    private JLabel colunaPreco;
    private JButton botaoVoltar;

    public TelaListaProdutoBomboniere(Collection<ProdutoBomboniere> produtos) {

        ArrayList<JLabel> arrayColunaCodigo = new ArrayList<>();
        ArrayList<JLabel> arrayColunaNome = new ArrayList<>();
        ArrayList<JLabel> arrayColunaEstoque = new ArrayList<>();
        ArrayList<JLabel> arrayColunaPreco = new ArrayList<>();

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        colunaCodigo = new JLabel();
        colunaNome = new JLabel();
        colunaEstoque = new JLabel();
        colunaPreco = new JLabel();
        botaoVoltar = new JButton();

        titulo.setText("Produtos Cadastrados");
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

        colunaEstoque.setText("Estoque       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 1;
        container.add(colunaEstoque, g);

        colunaPreco.setText("Preço       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 3;
        g.gridy = 1;
        container.add(colunaPreco, g);

        int i = 0;

        for (ProdutoBomboniere produto: produtos) {
            arrayColunaCodigo.add(new JLabel());
            arrayColunaNome.add(new JLabel());
            arrayColunaEstoque.add(new JLabel());
            arrayColunaPreco.add(new JLabel());

            arrayColunaCodigo.get(i).setText(produto.getCodigoBarra());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = i+2;
            container.add(arrayColunaCodigo.get(i), g);

            arrayColunaNome.get(i).setText(produto.getNome());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 1;
            g.gridy = i+2;
            container.add(arrayColunaNome.get(i), g);

            arrayColunaEstoque.get(i).setText(Integer.toString(produto.getEstoque()));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 2;
            g.gridy = i+2;
            container.add(arrayColunaEstoque.get(i), g);

            arrayColunaPreco.get(i).setText(Float.toString(produto.getPreco()));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 3;
            g.gridy = i+2;
            container.add(arrayColunaPreco.get(i), g);

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

            ControladorBomboniere.getInstancia().iniciaMenuBomboniere();
        }

    }
}
