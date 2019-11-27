package br.ufsc.ine5608.cineManagement.views.ingresso;

import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class TelaEscolherLugar extends JFrame {

    private JLabel titulo;
    private JLabel a;
    private JLabel b;
    private JLabel c;
    private JLabel d;
    private JLabel e;
    private JLabel f;
    private JButton botaoVoltar;
    private JButton botaoOk;
    private JRadioButton assento;

    public TelaEscolherLugar (SalaCinema sala, Filme filme, Date data) {
        ArrayList<JRadioButton> butons1 = new ArrayList<>();
        ArrayList<JRadioButton> butons2 = new ArrayList<>();
        ArrayList<JRadioButton> butons3 = new ArrayList<>();
        ArrayList<JRadioButton> butons4 = new ArrayList<>();
        ArrayList<JRadioButton> butons5 = new ArrayList<>();
        ArrayList<JRadioButton> butons6 = new ArrayList<>();

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        botaoVoltar = new JButton();
        botaoOk = new JButton();
        assento = new JRadioButton();
        titulo = new JLabel();
        a = new JLabel();
        b = new JLabel();
        c = new JLabel();
        d = new JLabel();
        e = new JLabel();
        f = new JLabel();

        for (int i = 0; i<25; i++) {
            butons1.add(new JRadioButton());
            butons2.add(new JRadioButton());
            butons3.add(new JRadioButton());
            butons4.add(new JRadioButton());
            butons5.add(new JRadioButton());
            butons6.add(new JRadioButton());
        }

        titulo.setText("Escolha o local");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        a.setText("A");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(a, g);

        for (int i = 1; i < 25; i++) {
            butons1.get(i).setText(Integer.toString(i));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = i+1;
            g.gridy = 1;
            container.add(butons1.get(i), g);
        }

        b.setText("B");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 2;
        container.add(b, g);

        for (int i = 1; i < 25; i++) {
            butons2.get(i).setText(Integer.toString(i));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = i+1;
            g.gridy = 2;
            container.add(butons2.get(i), g);
        }

        c.setText("C");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 3;
        container.add(c, g);

        for (int i = 1; i < 25; i++) {
            butons3.get(i).setText(Integer.toString(i));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = i + 1;
            g.gridy = 3;
            container.add(butons3.get(i), g);
        }

        d.setText("D");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 4;
        container.add(d, g);

        for (int i = 1; i < 25; i++) {
            butons4.get(i).setText(Integer.toString(i));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = i + 1;
            g.gridy = 4;
            container.add(butons4.get(i), g);
        }

        e.setText("E");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 5;
        container.add(e, g);

        for (int i = 1; i < 25; i++) {
            butons5.get(i).setText(Integer.toString(i));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = i+1;
            g.gridy = 5;
            container.add(butons5.get(i), g);
        }

        f.setText("F");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 6;
        container.add(f, g);

        for (int i = 1; i < 25; i++) {
            butons6.get(i).setText(Integer.toString(i));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = i+1;
            g.gridy = 6;
            container.add(butons6.get(i), g);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 450));
        setLocationRelativeTo(null);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
