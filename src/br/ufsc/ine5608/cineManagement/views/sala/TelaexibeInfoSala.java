package br.ufsc.ine5608.cineManagement.views.sala;

import br.ufsc.ine5608.cineManagement.controladores.ControladorSala;
import br.ufsc.ine5608.cineManagement.enums.TipoSala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaexibeInfoSala extends JFrame {
    private JLabel titulo;
    private JLabel colunanome;
    private JLabel colunaCapacidade;
    private JLabel colunaEstado;
    private JLabel colunaTipo;
    private JButton botaoVoltar;

    public TelaexibeInfoSala(String nome, int fileiras, int cadeirasPorFileira, boolean estados, TipoSala tipos) {

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        colunanome = new JLabel();
        colunaCapacidade = new JLabel();
        colunaEstado = new JLabel();
        colunaTipo = new JLabel();
        botaoVoltar = new JButton();

        titulo.setText("Salas Cadastradas");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        colunanome.setText("Nome");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(colunanome, g);

        colunaCapacidade.setText("Capacidade       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(colunaCapacidade, g);

        colunaEstado.setText("Estado       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 1;
        container.add(colunaEstado, g);

        colunaTipo.setText("Tipo       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 3;
        g.gridy = 1;
        container.add(colunaTipo, g);

        JLabel nomeSala = new JLabel();
        JLabel capacidade = new JLabel();
        JLabel estado = new JLabel();
        JLabel tipo = new JLabel();

       nomeSala.setText(nome);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        container.add(nomeSala, g);

        capacidade.setText(Integer.toString(fileiras * cadeirasPorFileira));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 3;
        container.add(capacidade, g);

        estado.setText(estados ? "Aberta" : "Em manutenção");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 3;
        container.add(estado, g);

        tipo.setText(tipos.equals(TipoSala.TIPO_NORMAL) ? "Sala normal" : "Sala 3D");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 3;
        g.gridy = 3;
        container.add(tipo, g);

        botaoVoltar.setText("Voltar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 4;
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

            ControladorSala.getInstancia().iniciaMenuSala();
        }

    }
}

