package br.ufsc.ine5608.cineManagement.models;

import java.util.Date;

public class ConteudoTelaNovoUsuario {

    String nome;
    String CPF;
    Date dataNasc;
    String email;
    String telefone;
    int pontos;

    public ConteudoTelaNovoUsuario(){

    }

    public ConteudoTelaNovoUsuario(String nome, String CPF, Date dataNasc, String email, String telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNasc = dataNasc;
        this.email = email;
        this.telefone = telefone;
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
