package app;

import model.Operadora;
import service.PacoteService;
import service.ReservaService;

import java.util.Scanner;

/**
 * Menu do painel da operadora espacial.
 * Opções: ver pacotes, cadastrar pacote, ver passageiros, ver status de prontidão.
 */
public class MenuOperadora {

    // ── Atributos ────────────────────────────────────────────────────────────
    private Operadora      operadora;
    private Scanner        scanner;
    private PacoteService  pacoteService;
    private ReservaService reservaService;

    // ── Construtor ────────────────────────────────────────────────────────────

    public MenuOperadora(Operadora operadora, Scanner scanner,
                         PacoteService pacoteService,
                         ReservaService reservaService) {
    }

    // ── Loop principal do menu ────────────────────────────────────────────────

    /**
     * Exibe o menu e processa a opção escolhida pela operadora.
     * Continua em loop até a opção 0 (sair).
     */
    public void exibir() {
    }

    // ── Opções do menu ────────────────────────────────────────────────────────

    /** Opção 1 — Lista todos os pacotes cadastrados pela operadora. */
    private void verMeusPacotes() {
    }

    /** Opção 2 — Formulário para cadastrar um novo pacote espacial. */
    private void cadastrarNovoPacote() {
    }

    /**
     * Opção 3 — Lista os passageiros confirmados de uma missão específica,
     * filtrando pelo pacote escolhido.
     */
    private void verPassageirosPorMissao() {
    }

    /**
     * Opção 4 — Exibe o status de prontidão de todos os passageiros
     * confirmados, destacando os pendentes de avaliação médica.
     */
    private void verStatusProntidao() {
    }
}
