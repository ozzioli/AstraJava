package model;

import java.util.List;

/**
 * Plano de preparação gerado automaticamente após aprovação médica do turista.
 * Contém cronograma de treinos, orientações nutricionais e datas-chave.
 */
public class PlanoPreparacao {

    // ── Atributos ────────────────────────────────────────────────────────────
    private int          id;
    private List<String> treinos;             // lista de atividades físicas recomendadas
    private List<String> orientacoesNutricionais;
    private String       dataInicio;
    private String       dataLimite;          // calculada com base na data do pacote reservado
    private String       observacoes;

    // ── Construtores ─────────────────────────────────────────────────────────

    public PlanoPreparacao() {
    }

    public PlanoPreparacao(int id, List<String> treinos, List<String> orientacoesNutricionais,
                           String dataInicio, String dataLimite) {
    }

    // ── Getters e Setters ─────────────────────────────────────────────────────

    public int getId() { return id; }
    public void setId(int id) { }

    public List<String> getTreinos() { return treinos; }
    public void setTreinos(List<String> treinos) { }

    public List<String> getOrientacoesNutricionais() { return orientacoesNutricionais; }
    public void setOrientacoesNutricionais(List<String> orientacoesNutricionais) { }

    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { }

    public String getDataLimite() { return dataLimite; }
    public void setDataLimite(String dataLimite) { }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return null;
    }
}
