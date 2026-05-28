package service;

import model.AvaliacaoAptidao;
import model.ClassificacaoScore;

/**
 * Service responsável pelo cálculo do Space Readiness Score.
 *
 * Demonstra SOBRECARGA DE MÉTODOS: calcularScore() com três assinaturas.
 *
 * Pesos: Físico 40% | Cardiovascular 35% | Psicológico 25%
 * Classificação: < 40 = INAPTO | 40–59 = EM_DESENVOLVIMENTO | >= 60 = APTO
 */
public class ScoreService {

    // ── Sobrecarga 1: array de respostas brutas ───────────────────────────────

    public double calcularScore(int[] respostas) {
        // TODO: dividir respostas entre as 3 categorias e calcular score ponderado
        return 0;
    }

    // ── Sobrecarga 2: três sub-scores separados ───────────────────────────────

    public double calcularScore(double scoreFisico, double scoreCardiovascular, double scorePsicologico) {
        // TODO: aplicar pesos (40%, 35%, 25%) e retornar score total
        return 0;
    }

    // ── Sobrecarga 3: objeto AvaliacaoAptidao completo ────────────────────────

    public double calcularScore(AvaliacaoAptidao avaliacao) {
        // TODO: usar sub-scores do objeto, calcular total e setar classificacao
        return 0;
    }

    // ── Métodos auxiliares ────────────────────────────────────────────────────

    public ClassificacaoScore classificar(double scoreTotal) {
        // TODO: retornar INAPTO, EM_DESENVOLVIMENTO ou APTO
        return null;
    }

    public void exibirRelatorioScore(AvaliacaoAptidao avaliacao) {
        // TODO: exibir relatório formatado no console
    }
}
