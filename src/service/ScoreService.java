package service;

import model.AvaliacaoAptidao;
import model.ClassificacaoScore;

/**
 * Service responsável pelo cálculo do Space Readiness Score.
 *
 * Demonstra SOBRECARGA DE MÉTODOS: calcularScore() possui três assinaturas.
 *
 * Pesos das categorias:
 *   Físico          → 40%
 *   Cardiovascular  → 35%
 *   Psicológico     → 25%
 *
 * Classificação:
 *   < 40  → INAPTO
 *   40–59 → EM_DESENVOLVIMENTO
 *   >= 60 → APTO
 */
public class ScoreService {

    // ── Sobrecarga 1 ─────────────────────────────────────────────────────────

    /**
     * Calcula o score a partir de um array de respostas brutas do questionário.
     * As primeiras N perguntas são físico, as seguintes cardiovascular, o restante psicológico.
     * @param respostas array com todas as respostas (valores de 0 a 10 cada)
     * @return score total ponderado de 0 a 100
     */
    public double calcularScore(int[] respostas) {
        return 0;
    }

    // ── Sobrecarga 2 ─────────────────────────────────────────────────────────

    /**
     * Calcula o score a partir dos três sub-scores já separados por categoria.
     * @param scoreFisico          sub-score físico (0–100)
     * @param scoreCardiovascular  sub-score cardiovascular (0–100)
     * @param scorePsicologico     sub-score psicológico (0–100)
     * @return score total ponderado de 0 a 100
     */
    public double calcularScore(double scoreFisico, double scoreCardiovascular, double scorePsicologico) {
        return 0;
    }

    // ── Sobrecarga 3 ─────────────────────────────────────────────────────────

    /**
     * Calcula o score a partir do objeto completo de avaliação.
     * Atualiza o scoreTotal e a classificação dentro do próprio objeto.
     * @param avaliacao objeto AvaliacaoAptidao preenchido com os sub-scores
     * @return score total ponderado de 0 a 100
     */
    public double calcularScore(AvaliacaoAptidao avaliacao) {
        return 0;
    }

    // ── Métodos auxiliares ────────────────────────────────────────────────────

    /**
     * Define a classificação do score com base no valor total.
     * @param scoreTotal score calculado
     * @return ClassificacaoScore correspondente
     */
    public ClassificacaoScore classificar(double scoreTotal) {
        return null;
    }

    /**
     * Exibe no console o relatório detalhado do score com as três categorias.
     * @param avaliacao avaliação com os dados preenchidos
     */
    public void exibirRelatorioScore(AvaliacaoAptidao avaliacao) {
    }
}
