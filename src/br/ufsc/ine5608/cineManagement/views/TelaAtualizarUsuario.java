package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorUsuário;
import br.ufsc.ine5608.cineManagement.models.Usuario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaAtualizarUsuario extends JFrame {
    private JLabel titulo;
    private JLabel tituloAux;
    private JLabel labelNome;
    private JTextField textNome;
    private JLabel labelCPF;
    private JTextField textCPF;
    private JLabel labelDataNasc;
    private JTextField textDataNac;
    private JLabel labelEmail;
    private JTextField textEmail;
    private JLabel labelFone;
    private JTextField textFone;
    private JButton botaoCancelar;
    private JButton botaoOk;

    public TelaAtualizarUsuario(Usuario usuario) {
        super("Atualiza Usuário");

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data = dateFormat.format(usuario.getDataNascimento());
        System.out.println(data);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel();
        labelNome = new JLabel();

        tituloAux = new JLabel();
        textNome = new JTextField();
        labelCPF = new JLabel();
        textCPF = new JTextField();
        labelDataNasc = new JLabel();
        labelEmail = new JLabel();
        textEmail = new JTextField();
        labelFone = new JLabel();
        textFone = new JTextField();
        botaoOk = new JButton();
        botaoCancelar = new JButton();
        try {
            textDataNac = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        titulo.setText("Atualiza Usuário");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        container.add(titulo, g);

        tituloAux.setText(" (O preenchimento de todos os campos são orbrigatórios)");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 0;
        container.add(tituloAux, g);

        labelNome.setText("Nome Completo");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        container.add(labelNome, g);

        textNome.setText(usuario.getNome());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(textNome, g);

        labelCPF.setText("CPF");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        container.add(labelCPF, g);

        textCPF.setText(usuario.getCpf());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 2;
        container.add(textCPF, g);

        labelDataNasc.setText("Data de Nascimento");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        container.add(labelDataNasc, g);

        textDataNac.setText(data);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 3;
        container.add(textDataNac, g);

        labelEmail.setText("Email");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 4;
        container.add(labelEmail, g);

        textEmail.setText(usuario.getEmail());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 4;
        container.add(textEmail, g);

        labelFone.setText("Telefone");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 5;
        container.add(labelFone, g);

        textFone.setText(usuario.getTelefone());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 5;
        container.add(textFone, g);

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
            Usuario usuario = new Usuario();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            if (ae.getSource() == botaoCancelar) {
                setVisible(false);
                ControladorUsuário.getInstancia().iniciaMenuUsuario();
            } else if (ae.getSource() == botaoOk) {
                setVisible(false);
                usuario.setCpf(textCPF.getText());
                usuario.setNome(textNome.getText());
                usuario.setEmail(textEmail.getText());
                usuario.setTelefone(textFone.getText());
                try {
                    Date date = formatter.parse(textDataNac.getText());
                    usuario.setDataNascimento(date);
                } catch (ParseException e){
                    e.printStackTrace();
                }
                ControladorUsuário.getInstancia().atualizaInfoUsuario(usuario);
            }
        }
    }
}
