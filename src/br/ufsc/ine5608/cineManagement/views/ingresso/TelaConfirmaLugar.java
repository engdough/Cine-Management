package br.ufsc.ine5608.cineManagement.views.ingresso;

import br.ufsc.ine5608.cineManagement.controladores.ControladorPrincipal;
import br.ufsc.ine5608.cineManagement.controladores.ControladorUsuário;
import br.ufsc.ine5608.cineManagement.controladores.ControladorVendas;
import br.ufsc.ine5608.cineManagement.models.Sessao;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TelaConfirmaLugar extends JFrame {

    private JButton botaoVoltar;
    private JButton botaook;
    private Sessao sessao;
    private JLabel filme;
    private JLabel hora;
    private JLabel assento;
    private JLabel CPF;
    private boolean[][] assentosEscolhidos;
    private String[] nomeFileiras;
    private ArrayList<String> cpfs;
    private ArrayList<JButton> arrayColunaButton;

    public TelaConfirmaLugar(Sessao sessao, boolean[][] assentosEscolhidos) {
        this.botaoVoltar = new JButton();
        this.botaook = new JButton();
        this.sessao = sessao;
        this.filme = new JLabel();
        this.hora = new JLabel();
        this.assento = new JLabel();
        this.CPF = new JLabel();
        this.assentosEscolhidos = assentosEscolhidos;
        int totalAssentos = 0;
        this.nomeFileiras = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        ArrayList<JLabel> arrayColunaFilme = new ArrayList<>();
        ArrayList<JLabel> arrayColunaHora = new ArrayList<>();
        ArrayList<JLabel> arrayColunaAssento = new ArrayList<>();
        ArrayList<JTextField> arrayColunaCPF = new ArrayList<>();
        this.arrayColunaButton = new ArrayList<>();

        for (int i=0; i<sessao.getLugares().length; i++){
            for (int j=0; j<sessao.getLugares()[i].length; j++) {
                if (assentosEscolhidos[i][j]){
                    totalAssentos++;
                }
            }
        }

        String[] arrayFilme = new String[totalAssentos];
        String[] arrayHorario = new String[totalAssentos];
        String[] arrayAssento = new String[totalAssentos];

        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 450));
        setLocationRelativeTo(null);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        filme.setText("Filme     ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(filme, g);

        hora.setText("Horário    ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(hora, g);

        assento.setText("Lugar   ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 1;
        container.add(assento, g);

        CPF.setText("CPF                    ");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 3;
        g.gridy = 1;
        container.add(CPF, g);

        int n = 0;
        for (int i=0; i<assentosEscolhidos.length; i++) {
            for (int j=0; j<assentosEscolhidos[i].length; j++) {
                if (assentosEscolhidos[i][j]) {
                    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                    String hora = dateFormat.format(sessao.getHoraInicio());

                    arrayFilme[n] = sessao.getFilme().getNome();
                    arrayHorario[n] = hora;
                    arrayAssento[n] = nomeFileiras[i] + (j + 1);
                    n++;
                }
            }
        }

        int k = 0;
        for (String response: arrayFilme) {
            arrayColunaFilme.add(new JLabel());
            arrayColunaHora.add(new JLabel());
            arrayColunaAssento.add(new JLabel());
            arrayColunaCPF.add(new JTextField());
            arrayColunaButton.add(new JButton());

            arrayColunaFilme.get(k).setText(response);
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = k+2;
            container.add(arrayColunaFilme.get(k), g);

            arrayColunaHora.get(k).setText(arrayHorario[k]);
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 1;
            g.gridy = k+2;
            container.add(arrayColunaHora.get(k), g);

            arrayColunaAssento.get(k).setText(arrayAssento[k]);
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 2;
            g.gridy = k+2;
            container.add(arrayColunaAssento.get(k), g);

            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 3;
            g.gridy = k+2;
            container.add(arrayColunaCPF.get(k), g);

            arrayColunaButton.get(k).setText("Validar");
            g.gridx = 4;
            g.gridy = k+2;
            container.add(arrayColunaButton.get(k), g);

            int m = k;
            arrayColunaButton.get(k).addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    validaCPFActionPerformed(evt, arrayColunaCPF.get(m).getText());
                }
            });

            k++;
        }

        botaoVoltar.setText("Voltar");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = k+2;
        container.add(botaoVoltar, g);

        botaook.setText("OK");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = k+2;
        container.add(botaook, g);

        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        botaook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
        ControladorPrincipal.getInstancia().iniciaSistema();
    }

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(null, "Valor total: R$" + (this.arrayColunaButton.size() * sessao.getPreco()));
        setVisible(false);
        ControladorVendas.getInstancia().encerravenda(sessao, cpfs);
    }

    private void validaCPFActionPerformed(java.awt.event.ActionEvent evt, String cpf) {//GEN-FIRST:event_jButton4ActionPerformed
        if (!ControladorUsuário.getInstancia().verificaCpf(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF não encontrado!");
        } else {
            JOptionPane.showMessageDialog(null, "CPF validado!");
            this.cpfs.add(cpf);
        }
    }
}
