package br.ufsc.ine5608.cineManagement.views.ingresso;

import br.ufsc.ine5608.cineManagement.controladores.ControladorBomboniere;
import br.ufsc.ine5608.cineManagement.controladores.ControladorPrincipal;
import br.ufsc.ine5608.cineManagement.controladores.ControladorVendas;
import br.ufsc.ine5608.cineManagement.views.bomboniere.TelaListaProdutoBomboniere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaVendaBomboniere extends JFrame {

    private JLabel titulo;
    private JLabel quantidade;
    private JLabel colunaCodigo;
    private JLabel colunaNome;
    private JLabel colunaEstoque;
    private JLabel colunaPreco;
    private JButton botaoVoltar;
    private JButton botaoComprar;
    private ArrayList<JTextField> arrayInput;
    private Float total;
    private List<Float> precos;

    public TelaVendaBomboniere (java.util.List<String> codigos, java.util.List<String> nomes, List<Float> precos) {

        ArrayList<JLabel> arrayColunaCodigo = new ArrayList<>();
        ArrayList<JLabel> arrayColunaNome = new ArrayList<>();
        ArrayList<JLabel> arrayColunaEstoque = new ArrayList<>();
        ArrayList<JLabel> arrayColunaPreco = new ArrayList<>();
        this.arrayInput = new ArrayList<>();
        this.precos = precos;
        this.total = 0f;

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
        botaoComprar = new JButton();
        quantidade = new JLabel();

        titulo.setText("Produtos à venda");
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

//        colunaEstoque.setText("Estoque       ");
//        g.fill = GridBagConstraints.HORIZONTAL;
//        g.gridx = 2;
//        g.gridy = 1;
//        container.add(colunaEstoque, g);

        colunaPreco.setText("Preço       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 3;
        g.gridy = 1;
        container.add(colunaPreco, g);

        quantidade.setText("Quantidade       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 4;
        g.gridy = 1;
        container.add(quantidade, g);

        int i = 0;

        for (String codigo: codigos) {
            arrayColunaCodigo.add(new JLabel());
            arrayColunaNome.add(new JLabel());
            arrayColunaEstoque.add(new JLabel());
            arrayColunaPreco.add(new JLabel());
            arrayInput.add(new JTextField());

            arrayColunaCodigo.get(i).setText(codigo);
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = i+2;
            container.add(arrayColunaCodigo.get(i), g);

            arrayColunaNome.get(i).setText(nomes.get(i));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 1;
            g.gridy = i+2;
            container.add(arrayColunaNome.get(i), g);

    //        arrayColunaEstoque.get(i).setText(Integer.toString(estoque.get(i)));
    //        g.fill = GridBagConstraints.HORIZONTAL;
    //        g.gridx = 2;
    //        g.gridy = i+2;
    //        container.add(arrayColunaEstoque.get(i), g);

            arrayColunaPreco.get(i).setText(Float.toString(precos.get(i)));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 3;
            g.gridy = i+2;
            container.add(arrayColunaPreco.get(i), g);

            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 4;
            g.gridy = i+2;
            container.add(arrayInput.get(i), g);

            i++;
        }

        botaoVoltar.setText("Voltar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = i + 2;
        container.add(botaoVoltar, g);

        botaoComprar.setText("Comprar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = i + 2;
        container.add(botaoComprar, g);

        botaoComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoComprarActionPerformed(evt);
            }
        });

        GerenciadorBotoes btManager = new GerenciadorBotoes();
        botaoVoltar.addActionListener(btManager);

        setSize(600,450);

        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void botaoComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int i = 0;
        for (JTextField input: arrayInput) {
            this.total += Float.parseFloat(input.getText()) * this.precos.get(i);
        }
        JOptionPane.showMessageDialog(null, "Valor total: R$" + Float.toString(this.total) + "");
        setVisible(false);
        ControladorPrincipal.getInstancia().iniciaSistema();
    }

    private class GerenciadorBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);
            ControladorPrincipal.getInstancia().iniciaSistema();
        }
    }
}
