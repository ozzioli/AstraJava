package app;

import model.Turista;
import service.MedicoService;
import service.PacoteService;
import service.ReservaService;
import service.ScoreService;

import java.util.Scanner;

/**
 * Menu do painel do turista.
 * Opções: ver catálogo, responder questionário, ver score,
 *         reservar pacote, cancelar reserva, ver plano de preparação.
 */
public class MenuTurista {

    // ── Atributos ────────────────────────────────────────────────────────────
    private Turista        turista;
    private Scanner        scanner;
    private PacoteService  pacoteService;
    private ReservaService reservaService;
    private ScoreService   scoreService;
    private MedicoService  medicoService;

    // ── Construtor ────────────────────────────────────────────────────────────

    public MenuTurista(Turista turista, Scanner scanner,
                       PacoteService pacoteService,
                       ReservaService reservaService,
                       ScoreService scoreService,
                       MedicoService medicoService) {
    }

    // ── Loop principal do menu ────────────────────────────────────────────────

    /**
     * Exibe o menu e processa a opção escolhida pelo turista.
     * Continua em loop até a opção 0 (sair).
     */
    public void exibir() {
    }

    // ── Opções do menu ────────────────────────────────────────────────────────

    /** Opção 1 — Exibe todos os pacotes ativos do catálogo. */
    private void verCatalogo() {
    }

    /** Opção 2 — Inicia o questionário de aptidão e calcula o score. */
    private void responderQuestionario() {
    }

    /** Opção 3 — Exibe o score atual e a classificação do turista. */
    private void verScore() {
    }

    /** Opção 4 — Permite reservar um pacote (somente se status APROVADO). */
    private void reservarPacote() {
    }

    /** Opção 5 — Cancela uma reserva ativa e informa o tipo de reembolso. */
    private void cancelarReserva() {
    }

    /** Opção 6 — Exibe o plano de preparação gerado pelo médico. */
    private void verPlanoPreparacao() {
    }
}
