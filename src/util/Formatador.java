package util;

import model.AvaliacaoAptidao;

 // Classe utilitária com métodos estáticos de formatação para exibição no console.

public class Formatador {

    private Formatador() {
    }

    //  Formata um valor monetário para exibição em reais.
    //  Exemplo: 15000.0 → "R$ 15.000,00"
    //  @param valor double a formatar
    //  @return string formatada

    public static String formatarMoeda(double valor) {
        return String.format("R$ %,.2f", valor)
                .replace(",", "X")
                .replace(".", ",")
                .replace("X", ".");
    }

     // Formata e exibe no console o relatório completo do Space Readiness Score.
     // Exibe score total, sub-scores por categoria e classificação.
     // @param avaliacao objeto com os dados do score

    public static void exibirRelatorioScore(AvaliacaoAptidao avaliacao) {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║       SPACE READINESS SCORE REPORT       ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf( "║  Físico          (40%%): %6.2f pts        ║%n", avaliacao.getScoreFisico());
        System.out.printf( "║  Cardiovascular  (35%%): %6.2f pts        ║%n", avaliacao.getScoreCardiovascular());
        System.out.printf( "║  Psicológico     (25%%): %6.2f pts        ║%n", avaliacao.getScorePsicologico());
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf( "║  Score Total         : %6.2f pts        ║%n", avaliacao.getScoreTotal());
        System.out.printf( "║  Classificação       : %-18s║%n", avaliacao.getClassificacao());
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf( "║  Data de realização  : %-18s║%n", avaliacao.getDataRealizacao());
        System.out.println("╚══════════════════════════════════════════╝");
    }

     // Exibe uma linha separadora no console para melhorar a legibilidade dos menus.

    public static void exibirSeparador() {
        System.out.println("──────────────────────────────────────────");
    }

     // Exibe um cabeçalho formatado com o título do menu ou seção.
     // @param titulo texto do cabeçalho

    public static void exibirCabecalho(String titulo) {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.printf( "║  %-40s║%n", titulo);
        System.out.println("╚══════════════════════════════════════════╝");
    }
}