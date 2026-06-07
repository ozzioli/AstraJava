package model;

import java.util.List;

  // Plano de preparação gerado automaticamente após aprovação médica do turista.
  // Contém cronograma de treinos, orientações nutricionais e datas-chave.

public class PlanoPreparacao {

    // ── Atributos
    private int id;
    private List<String> treinos; // lista de atividades físicas recomendadas
    private List<String> orientacoesNutricionais;
    private String dataInicio;
    private String dataLimite; // calculada com base na data do pacote reservado
    private String observacoes;

    // ── Construtores

    public PlanoPreparacao() {

    }

    public PlanoPreparacao(int id, List<String> treinos, List<String> orientacoesNutricionais,
                           String dataInicio, String dataLimite) {
        this.id = id; // mudar depois
        this.treinos = treinos;
        this.orientacoesNutricionais = orientacoesNutricionais;
        this.dataInicio = dataInicio;
        this.dataLimite = dataLimite;
    }

    // ── Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public List<String> getOrientacoesNutricionais() {
        return orientacoesNutricionais;
    }

    public void setOrientacoesNutricionais(List<String> orientacoesNutricionais) {
        this.orientacoesNutricionais = orientacoesNutricionais;
    }

    public List<String> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<String> treinos) {
        this.treinos = treinos;
    }

    // ── toString

    @Override
    public String toString() {
        return "PlanoPreparacao{" +
                "treinos=" + treinos +
                ", orientacoesNutricionais=" + orientacoesNutricionais +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataLimite='" + dataLimite + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
