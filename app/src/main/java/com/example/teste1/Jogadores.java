package com.example.teste1;

//Como usar database SQLite
//https://www.youtube.com/watch?v=-wor0Po7SEc
public class Jogadores {

    private Integer idJogador;
    private String nomeJogador;
    private Integer idadeJogador;
    private Integer overallJogador;
    private Integer potencialJogador;

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public Integer getIdadeJogador() {
        return idadeJogador;
    }

    public void setIdadeJogador(Integer idadeJogador) {
        this.idadeJogador = idadeJogador;
    }

    public Integer getOverallJogador() {
        return overallJogador;
    }

    public void setOverallJogador(Integer overallJogador) {
        this.overallJogador = overallJogador;
    }

    public Integer getPotencialJogador() {
        return potencialJogador;
    }

    public void setPotencialJogador(Integer potencialJogador) {
        this.potencialJogador = potencialJogador;
    }

    public String toString(){
        return nomeJogador;
    }
}
