package br.ufsc.ine5608.cineManagement.views.bomboniere;

import br.ufsc.ine5608.cineManagement.controladores.ControladorBomboniere;
import br.ufsc.ine5608.cineManagement.controladores.ControladorFilme;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.views.filme.TelaExibeInfoFilme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaExibeInfoBomboniere extends JFrame{
    private JLabel titulo;
    private JLabel colunaCodigo;
    private JLabel colunaNome;
    private JLabel colunaEstoque;
    private JLabel colunaPreco;
    private JButton botaoVoltar;
    private JLabel colunaCodigo2;
    private JLabel colunaNome2;
    private JLabel colunaEstoque2;
    private JLabel colunaPreco2;

    public TelaExibeInfoBomboniere(String codigo, String nome, float preco) {

        colunaCodigo2 = new JLabel();
        colunaNome2 = new JLabel();
        colunaEstoque2 = new JLabel();
        colunaPreco2 = new JLabel();

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

        titulo.setText("Informações Produto Bomboniére");
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

        colunaCodigo2.setText(codigo);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        container.add(colunaCodigo2, g);

        colunaNome2.setText(nome);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 2;
        container.add(colunaNome2, g);

//        colunaEstoque2.setText(Integer.toString(estoque));
//        g.fill = GridBagConstraints.HORIZONTAL;
//        g.gridx = 2;
//        g.gridy = 2;
//        container.add(colunaEstoque2, g);

        colunaPreco2.setText(Float.toString(preco));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 3;
        g.gridy = 2;
        container.add(colunaPreco2, g);

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

            ControladorBomboniere.getInstancia().iniciaMenuBomboniere();
        }

    }
}
