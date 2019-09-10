package br.ufsc.ine5608.cineManagement.views;

import br.ufsc.ine5608.cineManagement.controladores.ControladorUsuário;
import br.ufsc.ine5608.cineManagement.models.ConteudoTelaNovoUsuario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaCadastroNovoUsuario extends JFrame {
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

    public TelaCadastroNovoUsuario() {
        super("Cadastro Novo Usuário");

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
        try {
            textDataNac = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        labelEmail = new JLabel();
        textEmail = new JTextField();
        labelFone = new JLabel();
        textFone = new JTextField();
        botaoOk = new JButton();
        botaoCancelar = new JButton();

        titulo.setText("Cadastrar Novo Usuário");
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

        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 1;
        container.add(textNome, g);

        labelCPF.setText("CPF");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        container.add(labelCPF, g);

        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 2;
        container.add(textCPF, g);

        labelDataNasc.setText("Data de Nascimento");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        container.add(labelDataNasc, g);

        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 3;
        container.add(textDataNac, g);

        labelEmail.setText("Email");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 4;
        container.add(labelEmail, g);

        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 4;
        container.add(textEmail, g);

        labelFone.setText("Telefone");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 5;
        container.add(labelFone, g);

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

        setSize(600, 400);

        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class GerenciadorBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            ConteudoTelaNovoUsuario conteudoTelaNovoUsuario = new ConteudoTelaNovoUsuario();
            if (ae.getSource() == botaoCancelar) {
                setVisible(false);
                ControladorUsuário.getInstancia().iniciaMenuUsuario();
            } else if (ae.getSource() == botaoOk) {
                setVisible(false);
                conteudoTelaNovoUsuario.setCPF(textCPF.getText());
                conteudoTelaNovoUsuario.setNome(textNome.getText());
                conteudoTelaNovoUsuario.setEmail(textEmail.getText());
                conteudoTelaNovoUsuario.setTelefone(textFone.getText());
                ControladorUsuário.getInstancia().adicionaUsuario(conteudoTelaNovoUsuario);
            }
        }
    }
}
