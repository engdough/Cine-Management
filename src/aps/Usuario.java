package aps;

public class Usuario {
    
    private String nome;
    private String cpf;
    private int pontos;

    public Usuario(String nome, String cpf, int pontos) {
        this.nome = nome;
        this.cpf = cpf;
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    
}
