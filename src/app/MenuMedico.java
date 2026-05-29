package app;

import model.Medico;
import service.MedicoService;

import java.util.Scanner;

/**
 * Menu do painel do médico avaliador.
 * Opções: ver candidatos pendentes, avaliar candidato, ver histórico.
 */
public class MenuMedico {

    // ── Atributos ────────────────────────────────────────────────────────────
    private Medico        medico;
    private Scanner       scanner;
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
        System.out.println("Iniciado");
    }

    // ── Opções do menu ────────────────────────────────────────────────────────

    /** Opção 1 — Lista todos os turistas com status EM_AVALIACAO. */
    private void verCandidatosPendentes() {
    }

    /**
     * Opção 2 — Permite ao médico escolher um candidato, visualizar
     * o questionário respondido e registrar aprovação ou reprovação.
     */
    private void avaliarCandidato() {
    }

    /** Opção 3 — Exibe o histórico de avaliações realizadas pelo médico. */
    private void verHistoricoAvaliacoes() {
    }
}
