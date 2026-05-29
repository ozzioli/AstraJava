package app;

import abstracts.UsuarioBase;
import model.PacoteEspacial;
import model.Turista;
import service.MedicoService;
import service.PacoteService;
import service.ReservaService;
import service.ScoreService;

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
        System.out.println("Iniciado");

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
        turista.responderQuestionario(turista);
    }

    // Opção 3 — Exibe o score atual e a classificação do turista.
    private void verScore() {
        System.out.println("Score atual: " + turista.getScoreAtual());
    }

    // Opção 4 — Permite reservar um pacote (somente se status APROVADO).
    private void reservarPacote() {
        pacoteService.listarPacotesAtivos();

        System.out.println("=================================================");
        System.out.println("Selecione o id do pacote que voce pretende  reservar: ");
        System.out.print(": ");
        int idPacote = scanner.nextInt();

        List<PacoteEspacial> pacotes = pacoteService.getPacotes();
        for (PacoteEspacial p : pacotes) {
            if (p.getId() == idPacote) {
                reservaService.realizarReserva(turista,p);
            }
        }
    }

    // Opção 5 — Cancela uma reserva ativa e informa o tipo de reembolso.
    private void cancelarReserva() {
    }

    // Opção 6 — Exibe o plano de preparação gerado pelo médico.
    private void verPlanoPreparacao() {
    }
}
