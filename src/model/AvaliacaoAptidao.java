package model;

  // Armazena as respostas do questionário de aptidão e o score calculado.
  // Gerada quando o turista conclui o questionário.

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
    }

    // ── Getters e Setters

    public int getId() { return id; }
    public void setId(int id) { }

    public int[] getRespostas() { return respostas; }
    public void setRespostas(int[] respostas) { }

    public double getScoreFisico() { return scoreFisico; }
    public void setScoreFisico(double scoreFisico) { }

    public double getScoreCardiovascular() { return scoreCardiovascular; }
    public void setScoreCardiovascular(double scoreCardiovascular) { }

    public double getScorePsicologico() { return scorePsicologico; }
    public void setScorePsicologico(double scorePsicologico) { }

    public double getScoreTotal() { return scoreTotal; }
    public void setScoreTotal(double scoreTotal) { }

    public ClassificacaoScore getClassificacao() { return classificacao; }
    public void setClassificacao(ClassificacaoScore classificacao) { }

    public String getDataRealizacao() { return dataRealizacao; }
    public void setDataRealizacao(String dataRealizacao) { }

    // ── toString

    @Override
    public String toString() {
        return null;
    }
}
