package app;

import model.Operadora;
import model.PacoteEspacial;
import model.Turista;
import service.PacoteService;
import service.ReservaService;

import java.util.List;
import java.util.Scanner;

 // Menu do painel da operadora espacial.
 // Opções: ver pacotes, cadastrar pacote, ver passageiros, ver status de prontidão.

public class MenuOperadora {

    // ── Atributos
    private Operadora operadora;
    private Scanner scanner;
    private PacoteService pacoteService;
    private ReservaService reservaService;

    // ── Construtor

    public MenuOperadora(Operadora operadora, Scanner scanner, PacoteService pacoteService, ReservaService reservaService) {
        this.operadora = operadora;
        this.scanner = scanner;
        this.pacoteService = pacoteService;
        this.reservaService = reservaService;
    }


    // ── Loop principal do menu

     // Exibe o menu e processa a opção escolhida pela operadora.
     // Continua em loop até a opção 0 (sair).

    public void exibir(Scanner scanner) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("=========================================");
            System.out.println("MENU DA OPERADORA");
            System.out.println("=========================================");
            System.out.println("1 - Ver Meus Pacotes");
            System.out.println("2 - Cadastrar Novo Pacote");
            System.out.println("3 - Ver Passageiros por Missao");
            System.out.println("4 - Ver Status de Prontidao");
            System.out.println("5 - Exibir Perfil  ");
            System.out.println("0 - Logout");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                verMeusPacotes();
            }

            if (opcao == 2) {
                scanner.nextLine();
                cadastrarNovoPacote();
            }

            if (opcao == 3) {
                verPassageirosPorMissao();
            }

            if (opcao == 4) {
                verStatusProntidao();
            }
            if (opcao == 5) {
                exibirPerfil();
            }
        }
    }

    // ── Opções do menu

    // Opção 1 — Lista todos os pacotes cadastrados pela operadora.
    private void verMeusPacotes() {
        System.out.println("========= SEUS PACOTES =========");
        operadora.listarPacotes();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("0 - Voltar");
            System.out.print(": ");
            opcao = scanner.nextInt();
        }

    }

    // Opção 2 — Formulário para cadastrar um novo pacote espacial.
    private void cadastrarNovoPacote() {
        System.out.println("Digite o Destino");
        System.out.print(": ");
        String destino = scanner.nextLine();

        System.out.println("Digite o preco");
        System.out.print(": ");
        double preco = scanner.nextDouble();

        System.out.println("Digite as vagas totais");
        System.out.print(": ");
        int vagasTotais = scanner.nextInt();

        scanner.nextLine(); // limpa o ENTER

        System.out.println("Digite a data da viagem (Ex: DD/MM/AAAA)");
        System.out.print(": ");
        String dataViagem = scanner.nextLine();

        System.out.println("Digite a descricao da viagem");
        System.out.print(": ");
        String descricao = scanner.nextLine();

        PacoteEspacial pacote = new PacoteEspacial(pacoteService.getLastID(),destino,preco,vagasTotais,dataViagem,descricao);
        pacoteService.cadastrarPacote(pacote);
        operadora.cadastrarPacote(pacote);

    }

     // Opção 3 — Lista os passageiros confirmados de uma missão específica,
     // filtrando pelo pacote escolhido.

    private void verPassageirosPorMissao() {
        System.out.println("======== Pacotes disponiveis: ========");
        operadora.listarPacotes();
        System.out.println("======================================");

        System.out.println("Digite o ID do pacote que deseja visualizar os passageiros");
        System.out.print(": ");
        int idPacote = scanner.nextInt();

        for (PacoteEspacial p : operadora.getPacotes()) {
            if (p.getId() == idPacote) {
                System.out.println("RESERVA: " + p);
                reservaService.listarPassageirosPorPacote(p);
            }
        }
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("0 - Voltar");
            System.out.print(": ");
            opcao = scanner.nextInt();
        }

    }

     // Opção 4 — Exibe o status de prontidão de todos os passageiros
     // confirmados, destacando os pendentes de avaliação médica.

    private void verStatusProntidao() {
        System.out.println("======== Pacotes disponiveis: ========");
        operadora.listarPacotes();
        System.out.println("======================================");

        System.out.println("Digite o ID do pacote que deseja visualizar os status dos passageiros");
        System.out.print(": ");
        int idPacote = scanner.nextInt();

        for (PacoteEspacial p : operadora.getPacotes()) {
            if (p.getId() == idPacote) {
                System.out.println("RESERVA: " + p);
                reservaService.listarStatusPassageiros(p);
            }
        }
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("0 - Voltar");
            System.out.print(": ");
            opcao = scanner.nextInt();
        }
    }
    // Opção 5 — Exibir perfil completo
    private void exibirPerfil() {
        operadora.exibirPerfil();
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("0 - Voltar");
            System.out.print(": ");
            opcao = scanner.nextInt();
        }
    }
}
