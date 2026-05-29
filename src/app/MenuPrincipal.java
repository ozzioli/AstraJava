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
import util.DataUtil;

import java.util.List;
import java.util.Scanner;

import static util.DataUtil.getDataAtual;

 // Menu principal do sistema ASTRA.
 // Responsável pela tela de login e redirecionamento para o painel correto.

public class MenuPrincipal {

    // ── Atributos
    private Scanner scanner;
    private AutenticacaoService autenticacaoService;
    private PacoteService pacoteService;
    private ReservaService reservaService;
    private ScoreService scoreService;
    private MedicoService medicoService;

    // ── Construtor

    public MenuPrincipal(Scanner scanner, AutenticacaoService autenticacaoService,
                         PacoteService pacoteService, ReservaService reservaService,
                         ScoreService scoreService, MedicoService medicoService) {
        this.scanner = scanner;
        this.autenticacaoService = autenticacaoService;
        this.pacoteService = pacoteService;
        this.reservaService = reservaService;
        this.scoreService = scoreService;
        this.medicoService = medicoService;
    }

    // ── Loop principal

     // Inicia o loop do sistema.
     // Exibe a tela de boas-vindas e processa o login até o usuário encerrar.

    public void iniciar(Scanner scanner) {
        exibirBoasVindas();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("1 - Login | 2 - Cadastro | 0 - Sair");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa ENTER
            if (opcao == 1) {
                UsuarioBase user = realizarLogin();
                System.out.println(user);
                if (user != null) redirecionarParaMenu(user);
            }
            if (opcao == 2) {
                int opcao2 = -1;
                while (opcao2 != 0) {
                    System.out.println("1 - Cadastrar Turista | 2 - Cadastrar Medico | 2 - Cadastrar Operadora | 0 - Voltar");
                    System.out.print("Opcao: ");
                    opcao2 = scanner.nextInt();
                    scanner.nextLine(); // limpa ENTER

                    if (opcao2 == 1) {
                        autenticacaoService.cadastroTurista(scanner);
                    }
                    if (opcao2 == 2) {
                        autenticacaoService.cadastroMedico(scanner);
                    }
                    if (opcao2 == 3) {
                        autenticacaoService.cadastroOperadora(scanner);
                    }
                }
            }
            }
        System.out.println("Encerrando ASTRA. Ate logo!");
    }

    // ── Métodos privados ──────────────────────────────────────────────────────

    // Exibe a tela inicial de boas-vindas com o nome do sistema.
    private void exibirBoasVindas() {
        System.out.println("=========================================\n" +
                "ASTRA — Space Tourism & Readiness\n" +
                "=========================================");
    }

     // Solicita email e senha via Scanner e chama AutenticacaoService.
     // @return UsuarioBase autenticado ou null se as credenciais forem inválidas

    private UsuarioBase realizarLogin() {
        System.out.println("Digite o seu email");
        System.out.print(": ");
        String userEmail = scanner.nextLine();

        System.out.println("Digite a sua senha");
        System.out.print(": ");
        String userSenha = scanner.nextLine();

        return autenticacaoService.autenticar(userEmail,userSenha);
    }

     // Redireciona o usuário autenticado para o menu do seu perfil.
     // @param usuario usuário já autenticado

    private void redirecionarParaMenu(UsuarioBase usuario) {
        if (autenticacaoService.getTipoPerfil(usuario).equals("TURISTA")) {
            String email = usuario.getEmail();
            String senha = usuario.getSenha();

            Turista user = (Turista) autenticacaoService.autenticar(email, senha);

            MenuTurista menuTurista = new MenuTurista(user,scanner, pacoteService, reservaService, scoreService, medicoService);
            menuTurista.exibir(scanner);
        };

        if (autenticacaoService.getTipoPerfil(usuario).equals("MEDICO")) {
            String email = usuario.getEmail();
            String senha = usuario.getSenha();

            Medico user = (Medico) autenticacaoService.autenticar(email, senha);

            MenuMedico menuMedico = new MenuMedico(medicoService,scanner,user);
            menuMedico.exibir();
        };

        if (autenticacaoService.getTipoPerfil(usuario).equals("OPERADORA")) {
            String email = usuario.getEmail();
            String senha = usuario.getSenha();

            Operadora user = (Operadora) autenticacaoService.autenticar(email, senha);

            MenuOperadora menuOperadora = new MenuOperadora(user,scanner,pacoteService,reservaService);
            menuOperadora.exibir();
        };

    }

}
