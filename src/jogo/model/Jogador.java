package jogo.model;

public class Jogador {

    private int codigo, jogadas;
    private String nome, email, senha;
    private double pontos;

    public Jogador(int codigo, int jogadas, String nome, String email, String senha, double pontos) {
        this.codigo = codigo;
        this.jogadas = jogadas;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pontos = pontos;
    }

    public Jogador(int jogadas, String nome, String email, String senha, double pontos) {
        this.jogadas = jogadas;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pontos = pontos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }
}
