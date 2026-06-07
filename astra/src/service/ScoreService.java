package service;

import model.AvaliacaoAptidao;
import model.ClassificacaoScore;

import java.util.Arrays;

// Service responsável pelo cálculo do Space Readiness Score.

 // Demonstra SOBRECARGA DE MÉTODOS: calcularScore() com três assinaturas.

 // Pesos: Físico 40% | Cardiovascular 35% | Psicológico 25%
 // Classificação: < 40 = INAPTO | 40–59 = EM_DESENVOLVIMENTO | >= 60 = APTO

public class ScoreService {

    // ── Sobrecarga 1: array de respostas brutas

    public double[] calcularScore(int[] respostas) {
        // TODO: dividir respostas entre as 3 categorias e calcular score ponderado
        int valor1 = respostas[0]; // f1
        int valor2 = respostas[1]; // f2
        int valor3 = respostas[2]; // f3

        double fisicoTotal = (valor1 + valor2 + valor3) / 3.0;

        int valor4 = respostas[3]; // c1
        int valor5 = respostas[4]; // c2
        int valor6 = respostas[5]; // c3

        double cardioTotal = (valor4 + valor5 + valor6) / 3.0;

        int valor7 = respostas[6]; // p1
        int valor8 = respostas[7]; // p2
        int valor9 = respostas[8]; // p3

        double psicoTotal  = (valor7 + valor8 + valor9) / 3.0;

        double fisico = fisicoTotal * 10;
        double cardio = cardioTotal * 10;
        double psico  = psicoTotal  * 10;

        return calcularScore(fisico, cardio, psico); // chama a sobrecarga 2
    }

    // ── Sobrecarga 2: três sub-scores separados

    public double[] calcularScore(double scoreFisico, double scoreCardiovascular, double scorePsicologico) {
        // TODO: aplicar pesos (40%, 35%, 25%) e retornar score total

        return new double[]{(scoreFisico * 0.40), (scoreCardiovascular * 0.35), (scorePsicologico * 0.25)};
    }

    // ── Sobrecarga 3: objeto AvaliacaoAptidao completo

    public double calcularScore(AvaliacaoAptidao avaliacao) {
        // TODO: usar sub-scores do objeto, calcular total e setar classificacao

        double[] respostas = calcularScore(avaliacao.getRespostas());

        double scoreFisico = respostas[0];
        double scoreCardio = respostas[1];
        double scorePsico = respostas[2];

        double total = Arrays.stream(respostas).sum();

        avaliacao.setScoreFisico(scoreFisico);
        avaliacao.setScoreCardiovascular(scoreCardio);
        avaliacao.setScorePsicologico(scorePsico);

        avaliacao.setScoreTotal(total);
        avaliacao.setClassificacao(classificar(total)); // chama o método classificar()

        return total;
    }

    // ── Métodos auxiliares

    public ClassificacaoScore classificar(double scoreTotal) {
        // TODO: retornar INAPTO, EM_DESENVOLVIMENTO ou APTO
        if (scoreTotal < 40) {
            return ClassificacaoScore.INAPTO;
        }
        if (scoreTotal >= 40 && scoreTotal < 60) {
            return ClassificacaoScore.EM_DESENVOLVIMENTO;
        }
        if (scoreTotal >= 60) {
            return ClassificacaoScore.APTO;
        }
        return null;
    }

}
