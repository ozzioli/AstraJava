package app;

import abstracts.UsuarioBase;
import model.*;
import service.MedicoService;
import service.PacoteService;
import service.ReservaService;
import service.ScoreService;
import util.DataUtil;
import util.Formatador;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

 // Menu do painel do turista.
 // Opções: ver catálogo, responder questionário, ver score,
 //         reservar pacote, cancelar reserva, ver plano de preparação.

public class MenuTurista {

    // ── Atributos
    private Turista turista;
    private Scanner scanner;
    private PacoteService pacoteService;
    private ReservaService reservaService;
    private ScoreService scoreService;
    private MedicoService medicoService;

    // ── Construtor

    public MenuTurista(Turista turista, Scanner scanner, PacoteService pacoteService, ReservaService reservaService, ScoreService scoreService, MedicoService medicoService) {
        this.turista = turista;
        this.scanner = scanner;
        this.pacoteService = pacoteService;
        this.reservaService = reservaService;
        this.scoreService = scoreService;
        this.medicoService = medicoService;
    }


    // ── Loop principal do menu

     // Exibe o menu e processa a opção escolhida pelo turista.
     // Continua em loop até a opção 0 (sair).

    public void exibir(Scanner scanner) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("=========================================");
            System.out.println("MENU DO TURISTA");
            System.out.println("=========================================");
            System.out.println("1 - Ver Catalogo");
            System.out.println("2 - Responder Questionario");
            System.out.println("3 - Ver Score");
            System.out.println("4 - Reservar Pacote");
            System.out.println("5 - Cancelar Reserva");
            System.out.println("6 - Ver Plano de Preparacao");
            System.out.println("7 - Exibir Perfil  ");
            System.out.println("0 - Logout");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            if (opcao == 1) {
                verCatalogo();
            }
            if (opcao == 2) {
                responderQuestionario();
            }
            if (opcao == 3) {
                verScore();
            }
            if (opcao == 4) {
                reservarPacote();
            }
            if (opcao == 5) {
                cancelarReserva();
            }
            if (opcao == 6) {
                verPlanoPreparacao();
            }
            if (opcao == 7) {
                exibirPerfil();
            }
        }
    }

    // ── Opções do menu

    // Opção 1 — Exibe todos os pacotes ativos do catálogo.
    private void verCatalogo() {

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("===================================");
            pacoteService.listarPacotesAtivos();
            System.out.println("===================================");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
        }


    }

    // Opção 2 — Inicia o questionário de aptidão e calcula o score.
    private void responderQuestionario() {
        scanner.nextLine();
        if (turista.getStatusAptidao() != StatusTurista.APROVADO) {
            System.out.println("===== QUESTIONÁRIO DE APTIDÃO ESPACIAL =====");
            System.out.println("Responda de 0 a 10 em cada pergunta.");
            System.out.println("(0 = péssimo  |  5 = regular  |  10 = excelente)\n");

            // ── Categoria 1: Físico (3 perguntas) ────────────────────────
            System.out.println("--- FÍSICO ---");

            System.out.print("1. Como você avalia sua resistência física geral? ");
            int f1 = scanner.nextInt();

            System.out.print("2. Você pratica exercícios físicos regularmente? ");
            int f2 = scanner.nextInt();

            System.out.print("3. Como está seu nível de energia no dia a dia? ");
            int f3 = scanner.nextInt();

            // ── Categoria 2: Cardiovascular (3 perguntas) ─────────────────
            System.out.println("\n--- CARDIOVASCULAR ---");

            System.out.print("4. Você tem histórico de problemas cardíacos? (0=sim / 10=não) ");
            int c1 = scanner.nextInt();

            System.out.print("5. Como é sua pressão arterial normalmente? ");
            int c2 = scanner.nextInt();

            System.out.print("6. Você consegue subir 4 lances de escada sem se cansar? ");
            int c3 = scanner.nextInt();

            // ── Categoria 3: Psicológico (3 perguntas) ────────────────────
            System.out.println("\n--- PSICOLÓGICO ---");

            System.out.print("7. Como você lida com situações de estresse intenso? ");
            int p1 = scanner.nextInt();

            System.out.print("8. Você tem medo de altura ou espaços fechados? (0=sim / 10=não) ");
            int p2 = scanner.nextInt();

            System.out.print("9. Como você avalia seu equilíbrio emocional geral? ");
            int p3 = scanner.nextInt();

            System.out.print("Formulario concluido com sucesso ");

            // ── Montar array e criar objeto AvaliacaoAptidao ──────────────
            int[] respostas = { f1, f2, f3, c1, c2, c3, p1, p2, p3 };

            double[] scoresSeparados =  scoreService.calcularScore(respostas);

            System.out.println("Score calculado: " + "Fisico: " + scoresSeparados[0] + " | Cardio: " + scoresSeparados[1] + " | Psicologico: " + scoresSeparados[2]);

            AvaliacaoAptidao nova = new AvaliacaoAptidao(1, respostas, DataUtil.getDataAtual());

            double score = scoreService.calcularScore(nova);

            turista.setScoreAtual(score);
            turista.responderQuestionario(turista);
            Formatador.exibirRelatorioScore(nova);

        }
        else {
            System.out.println("Voce ja esta aprovado no teste de aptidao!");
        }
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("0 - Voltar");
            System.out.print(": ");
            opcao = scanner.nextInt();
        }
    }

    // Opção 3 — Exibe o score atual e a classificação do turista.
    private void verScore() {
        System.out.println("Score atual: " + turista.getScoreAtual() + " | Faca o questionario para subitr seu score e ser avaliado pelo medico!");
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("0 - Voltar");
            System.out.print(": ");
            opcao = scanner.nextInt();
        }
    }

    // Opção 4 — Permite reservar um pacote (somente se status APROVADO).
    private void reservarPacote() {
        pacoteService.listarPacotesAtivos();

        System.out.println("=================================================");
        System.out.println("Selecione o id do pacote que voce pretende reservar: ");
        System.out.print(": ");
        int idPacote = scanner.nextInt();
        PacoteEspacial pacote = pacoteService.buscarPorId(idPacote);
        if (pacote != null) {
            reservaService.realizarReserva(turista,pacote);
        }
        else {
            System.out.println("Pacote incexistente");
        }

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("0 - Voltar");
            System.out.print(": ");
            opcao = scanner.nextInt();
        }

    }

    // Opção 5 — Cancela uma reserva ativa e informa o tipo de reembolso.
    private void cancelarReserva() {
        System.out.println("------------ CANCELAR RESERVA ------------");
        reservaService.listarReservasPorTurista(turista);
        System.out.println("------------------------------------------");
        System.out.println("Digite o id da reserva que voce deseja cancelar");

        Reserva reservaParaCancelar = null;

        int idReserva = scanner.nextInt();

        for (Reserva reserva : reservaService.getReservas()) {
            if (idReserva == reserva.getId()) {
                reservaParaCancelar = reserva;
                break;
            }
        }
        if (reservaParaCancelar != null) {
            reservaService.cancelarReserva(reservaParaCancelar);
        }
    }

    // Opção 6 — Exibe o plano de preparação gerado pelo médico.
    private void verPlanoPreparacao() {
        if (turista.getStatusAptidao() == StatusTurista.APROVADO) {

            PlanoPreparacao plano = turista.getPlanoPreparacao();

            System.out.println("\n========================================");
            System.out.println("      PLANO DE PREPARAÇÃO ESPACIAL");
            System.out.println("========================================");

            System.out.println("\nPeríodo");
            System.out.println("Início : " + plano.getDataInicio());
            System.out.println("Limite : " + plano.getDataLimite());

            System.out.println("\nTreinos Recomendados");
            for (String treino : plano.getTreinos()) {
                System.out.println("• " + treino);
            }

            System.out.println("\nOrientações Nutricionais");
            for (String orientacao : plano.getOrientacoesNutricionais()) {
                System.out.println("• " + orientacao);
            }

            System.out.println("\nObservações");
            System.out.println(plano.getObservacoes());

            System.out.println("\n========================================");
        }
        else {
            System.out.println("SEM PLANO AINDA (ESPERANDO SER APROVADO)");
        }
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("0 - Voltar");
            System.out.print(": ");
            opcao = scanner.nextInt();
        }
    }

    // Opção 7 — Exibir perfil completo
    private void exibirPerfil() {
       turista.exibirPerfil();
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("0 - Voltar");
            System.out.print(": ");
            opcao = scanner.nextInt();
        }
    }
}
