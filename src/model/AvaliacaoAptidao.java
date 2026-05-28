package model;

  // Armazena as respostas do questionário de aptidão e o score calculado.
  // Gerada quando o turista conclui o questionário.

import java.util.Arrays;

public class AvaliacaoAptidao {

    // ── Atributos
    private int id;
    private int[]  respostas; // array com todas as respostas brutas
    private double scoreFisico; // sub-score categoria física (peso 40%)
    private double scoreCardiovascular; // sub-score categoria cardiovascular (peso 35%)
    private double scorePsicologico; // sub-score categoria psicológica (peso 25%)
    private double scoreTotal; // score final ponderado (0–100)
    private ClassificacaoScore classificacao;
    private String dataRealizacao;

    // ── Construtores

    public AvaliacaoAptidao() {
    }

    public AvaliacaoAptidao(int id, int[] respostas, String dataRealizacao) {
        this.id=id;
        this.respostas=respostas;
        this.dataRealizacao=dataRealizacao;
    }

    // ── Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getRespostas() {
        return respostas;
    }

    public void setRespostas(int[] respostas) {
        this.respostas = respostas;
    }

    public double getScoreFisico() {
        return scoreFisico;
    }

    public void setScoreFisico(double scoreFisico) {
        this.scoreFisico = scoreFisico;
    }

    public double getScoreCardiovascular() {
        return scoreCardiovascular;
    }

    public void setScoreCardiovascular(double scoreCardiovascular) {
        this.scoreCardiovascular = scoreCardiovascular;
    }

    public double getScorePsicologico() {
        return scorePsicologico;
    }

    public void setScorePsicologico(double scorePsicologico) {
        this.scorePsicologico = scorePsicologico;
    }

    public double getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(double scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public ClassificacaoScore getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoScore classificacao) {
        this.classificacao = classificacao;
    }

    public String getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }


    // ── toString

    @Override
    public String toString() {
        return "AvaliacaoAptidao{" +
                "id=" + id +
                ", respostas=" + Arrays.toString(respostas) +
                ", scoreFisico=" + scoreFisico +
                ", scoreCardiovascular=" + scoreCardiovascular +
                ", scorePsicologico=" + scorePsicologico +
                ", scoreTotal=" + scoreTotal +
                ", classificacao=" + classificacao +
                ", dataRealizacao='" + dataRealizacao + '\'' +
                '}';
    }
}

