package app;

import abstracts.UsuarioBase;
import model.Medico;
import model.Operadora;
import model.Turista;
import service.AutenticacaoService;
import service.MedicoService;
import service.PacoteService;
import service.ReservaService;
import service.ScoreService;

import java.util.Scanner;

/**
 * Menu principal do sistema ASTRA.
 * Responsável pela tela de login e redirecionamento para o painel correto.
 */
public class MenuPrincipal {

    // ── Atributos ────────────────────────────────────────────────────────────
    private Scanner              scanner;
    private AutenticacaoService  autenticacaoService;
    private PacoteService        pacoteService;
    private ReservaService       reservaService;
    private ScoreService         scoreService;
    private MedicoService        medicoService;

    // ── Construtor ────────────────────────────────────────────────────────────

    public MenuPrincipal(Scanner scanner,
                         AutenticacaoService autenticacaoService,
                         PacoteService pacoteService,
                         ReservaService reservaService,
                         ScoreService scoreService,
                         MedicoService medicoService) {
    }

    // ── Loop principal ────────────────────────────────────────────────────────

    /**
     * Inicia o loop do sistema.
     * Exibe a tela de boas-vindas e processa o login até o usuário encerrar.
     */
    public void iniciar() {
    }

    // ── Métodos privados ──────────────────────────────────────────────────────

    /** Exibe a tela inicial de boas-vindas com o nome do sistema. */
    private void exibirBoasVindas() {
    }

    /**
     * Solicita email e senha via Scanner e chama AutenticacaoService.
     * @return UsuarioBase autenticado ou null se as credenciais forem inválidas
     */
    private UsuarioBase realizarLogin() {
        return null;
    }

    /**
     * Redireciona o usuário autenticado para o menu do seu perfil.
     * @param usuario usuário já autenticado
     */
    private void redirecionarParaMenu(UsuarioBase usuario) {
    }
}
