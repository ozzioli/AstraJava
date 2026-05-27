package util;

import model.AvaliacaoAptidao;

/**
 * Classe utilitária com métodos estáticos de formatação para exibição no console.
 */
public class Formatador {

    private Formatador() {
    }

    /**
     * Formata um valor monetário para exibição em reais.
     * Exemplo: 15000.0 → "R$ 15.000,00"
     * @param valor double a formatar
     * @return string formatada
     */
    public static String formatarMoeda(double valor) {
        return null;
    }

    /**
     * Formata e exibe no console o relatório completo do Space Readiness Score.
     * Exibe score total, sub-scores por categoria e classificação.
     * @param avaliacao objeto com os dados do score
     */
    public static void exibirRelatorioScore(AvaliacaoAptidao avaliacao) {
    }

    /**
     * Exibe uma linha separadora no console para melhorar a legibilidade dos menus.
     */
    public static void exibirSeparador() {
    }

    /**
     * Exibe um cabeçalho formatado com o título do menu ou seção.
     * @param titulo texto do cabeçalho
     */
    public static void exibirCabecalho(String titulo) {
    }
}
