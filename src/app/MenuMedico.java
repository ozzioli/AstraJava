package app;

import model.Medico;
import model.StatusTurista;
import model.Turista;
import service.MedicoService;

import java.util.List;
import java.util.Scanner;

/**
 * Menu do painel do médico avaliador.
 * Opções: ver candidatos pendentes, avaliar candidato, ver histórico.
 */
public class MenuMedico {

    // ── Atributos ────────────────────────────────────────────────────────────
    private Medico medico;
    private Scanner scanner;
    private MedicoService medicoService;

    // ── Construtor ────────────────────────────────────────────────────────────

    public MenuMedico(MedicoService medicoService, Scanner scanner, Medico medico) {
        this.medicoService = medicoService;
        this.scanner = scanner;
        this.medico = medico;
    }


    // ── Loop principal do menu ────────────────────────────────────────────────

    /**
     * Exibe o menu e processa a opção escolhida pelo médico.
     * Continua em loop até a opção 0 (sair).
     */
    public void exibir() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║       PAINEL DO MÉDICO           ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ 1 - Ver candidatos pendentes     ║");
            System.out.println("║ 2 - Avaliar candidato            ║");
            System.out.println("║ 3 - Ver histórico de avaliações  ║");
            System.out.println("║ 0 - Sair                         ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> verCandidatosPendentes();
                case 2 -> avaliarCandidato();
                case 3 -> verHistoricoAvaliacoes();
                case 0 -> System.out.println("Saindo do painel médico...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // ── Opções do menu ────────────────────────────────────────────────────────

    /**
     * Opção 1 — Lista todos os turistas com status EM_AVALIACAO.
     */
    private void verCandidatosPendentes() {
        System.out.println("\n── CANDIDATOS PENDENTES ─────────────────────");
        medicoService.listarCandidatosPendentes();
    }

    /**
     * Opção 2 — Permite ao médico escolher um candidato, visualizar
     * o questionário respondido e registrar aprovação ou reprovação.
     */
    private void avaliarCandidato() {
        List<Turista> pendentes = medicoService.getTuristas()
                .stream()
                .filter(t -> t.getStatusAptidao() == StatusTurista.EM_AVALIACAO)
                .toList();

        if (pendentes.isEmpty()) {
            System.out.println("\nNenhum candidato pendente no momento.");
            return;
        }

        System.out.println("\n── SELECIONE O CANDIDATO ────────────────────");
        for (int i = 0; i < pendentes.size(); i++) {
            Turista t = pendentes.get(i);
            System.out.printf("[%d] %s (Score: %.1f)%n", i + 1, t.getNome(), t.getScoreAtual());
        }

        System.out.print("Número do candidato: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 1 || escolha > pendentes.size()) {
            System.out.println("Seleção inválida.");
            return;
        }

        Turista turista = pendentes.get(escolha - 1);

        System.out.println("\n── DADOS DO CANDIDATO ───────────────────────");
        turista.exibirPerfil();

        if (turista.getAvaliacao() != null) {
            System.out.println("\nQuestionário respondido:");
            System.out.println(turista.getAvaliacao());
        } else {
            System.out.println("\n(Candidato ainda não respondeu o questionário.)");
        }

        System.out.println("\nDecisão: 1 - Aprovar  |  2 - Reprovar");
        System.out.print("Opção: ");
        int decisao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Justificativa: ");
        String justificativa = scanner.nextLine();

        boolean aprovado = decisao == 1;

        medicoService.processarDecisao(medico, turista, aprovado, justificativa);

        if (aprovado) {
            System.out.println("\n✔ Candidato APROVADO. Plano de preparação gerado.");
            System.out.println(turista.getPlanoPreparacao());
        } else {
            System.out.println("\n✘ Candidato REPROVADO. Justificativa registrada.");
        }

        medico.receberNotificacao("Avaliação de " + turista.getNome() + " concluída.");
        turista.receberNotificacao(aprovado
                ? "Parabéns! Você foi aprovado(a). Seu plano de preparação está disponível."
                : "Infelizmente você foi reprovado(a). Motivo: " + justificativa);

        // apos aprovacao o plano de preparacao tem que ser gerado para o usuario
    }

    /**
     * Opção 3 — Exibe o histórico de avaliações realizadas pelo médico.
     */
    private void verHistoricoAvaliacoes() {
        List<Turista> avaliados = medicoService.getTuristas()
                .stream()
                .filter(t -> t.getStatusAptidao() == StatusTurista.APROVADO
                        || t.getStatusAptidao() == StatusTurista.REPROVADO)
                .toList();

        if (avaliados.isEmpty()) {
            System.out.println("Nenhuma avaliação realizada ainda.");
            return;
        }

        for (Turista t : avaliados) {
            System.out.printf("• %s | Status: %s%n", t.getNome(), t.getStatusAptidao());
            if (t.getJustificativaMedica() != null && !t.getJustificativaMedica().isBlank()) {
                System.out.println("  Justificativa: " + t.getJustificativaMedica());
            }
        }
    }
}