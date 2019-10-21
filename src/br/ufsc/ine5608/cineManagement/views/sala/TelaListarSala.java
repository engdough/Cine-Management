package br.ufsc.ine5608.cineManagement.views.sala;

import br.ufsc.ine5608.cineManagement.controladores.ControladorFilme;
import br.ufsc.ine5608.cineManagement.controladores.ControladorSala;
import br.ufsc.ine5608.cineManagement.enums.TipoSala;
import br.ufsc.ine5608.cineManagement.models.Filme;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.views.filme.TelaListaFilmes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class TelaListarSala extends JFrame{
    private JLabel titulo;
    private JLabel colunanome;
    private JLabel colunaCapacidade;
    private JLabel colunaEstado;
    private JLabel colunaTipo;
    private JButton botaoVoltar;

    public TelaListarSala(Collection<SalaCinema> salas) {

        ArrayList<JLabel> arrayColunaNome = new ArrayList<>();
        ArrayList<JLabel> arrayColunaCapacidade = new ArrayList<>();
        ArrayList<JLabel> arrayColunaEstado = new ArrayList<>();
        ArrayList<JLabel> arrayColunaTipo = new ArrayList<>();

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

        int i = 0;

        for (SalaCinema sala: salas) {
            arrayColunaNome.add(new JLabel());
            arrayColunaCapacidade.add(new JLabel());
            arrayColunaEstado.add(new JLabel());
            arrayColunaTipo.add(new JLabel());

            arrayColunaNome.get(i).setText(sala.getNome());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = i+2;
            container.add(arrayColunaNome.get(i), g);

            arrayColunaCapacidade.get(i).setText(Integer.toString(sala.getCapacidade()));
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 1;
            g.gridy = i+2;
            container.add(arrayColunaCapacidade.get(i), g);

            arrayColunaEstado.get(i).setText(sala.isStatus() ? "Aberta" : "Em manutenção");
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 2;
            g.gridy = i+2;
            container.add(arrayColunaEstado.get(i), g);

            arrayColunaTipo.get(i).setText(sala.getTipoSala().equals(TipoSala.TIPO_NORMAL) ? "Sala normal" : "Sala 3D");
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 3;
            g.gridy = i+2;
            container.add(arrayColunaTipo.get(i), g);

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

            ControladorSala.getInstancia().iniciaMenuSala();
        }

    }
}
