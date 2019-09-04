package jogo.model;

public class Jogo {

    int codigo, id1, id2, soma, aposta1, aposta2;


    public Jogo(int codigo, int id1, int id2, int soma, int aposta1, int aposta2) {
        this.codigo = codigo;
        this.id1 = id1;
        this.id2 = id2;
        this.soma = soma;
        this.aposta1 = aposta1;
        this.aposta2 = aposta2;
    }

    public Jogo(int id1, int id2, int soma, int aposta1, int aposta2) {
        this.id1 = id1;
        this.id2 = id2;
        this.soma = soma;
        this.aposta1 = aposta1;
        this.aposta2 = aposta2;
    }

    public Jogo() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getSoma() {
        return soma;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }

    public int getAposta1() {
        return aposta1;
    }

    public void setAposta1(int aposta1) {
        this.aposta1 = aposta1;
    }

    public int getAposta2() {
        return aposta2;
    }

    public void setAposta2(int aposta2) {
        this.aposta2 = aposta2;
    }
}
