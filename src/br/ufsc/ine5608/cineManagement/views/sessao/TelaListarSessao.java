package br.ufsc.ine5608.cineManagement.views.sessao;

import br.ufsc.ine5608.cineManagement.controladores.ControladorSala;
import br.ufsc.ine5608.cineManagement.controladores.ControladorSessao;
import br.ufsc.ine5608.cineManagement.enums.TipoSala;
import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.models.Sessao;
import br.ufsc.ine5608.cineManagement.views.sala.TelaListarSala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class TelaListarSessao extends JFrame {
    private JLabel titulo;
    private JLabel colunaFilme;
    private JLabel colunaSala;
    private JLabel colunaHora;
    private JButton botaoVoltar;

    public TelaListarSessao(Collection<Sessao> sessoes) {

        ArrayList<JLabel> arrayColunaFilme = new ArrayList<>();
        ArrayList<JLabel> arrayColunaSala = new ArrayList<>();
        ArrayList<JLabel> arrayColunaHota = new ArrayList<>();

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        colunaFilme = new JLabel();
        colunaSala = new JLabel();
        colunaHora = new JLabel();
        botaoVoltar = new JButton();

        titulo.setText("Sessões Cadastradas");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        colunaFilme.setText("Filme");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(colunaFilme, g);

        colunaSala.setText("Sala       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(colunaSala, g);

        colunaHora.setText("Hora       ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 1;
        container.add(colunaHora, g);

        int i = 0;

        for (Sessao sessao: sessoes) {
            arrayColunaFilme.add(new JLabel());
            arrayColunaSala.add(new JLabel());
            arrayColunaHota.add(new JLabel());

            arrayColunaFilme.get(i).setText(sessao.getFilme().getNome());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = i+2;
            container.add(arrayColunaFilme.get(i), g);

            arrayColunaSala.get(i).setText(sessao.getSala().getNome());
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 1;
            g.gridy = i+2;
            container.add(arrayColunaSala.get(i), g);

            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            String hora = dateFormat.format(sessao.getHoraInicio());
            arrayColunaHota.get(i).setText(hora);
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 2;
            g.gridy = i+2;
            container.add(arrayColunaHota.get(i), g);

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

            ControladorSessao.getInstancia().iniciaMenuSessao();
        }

    }
}
