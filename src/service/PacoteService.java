package service;

import model.PacoteEspacial;

import java.util.List;
import java.util.Scanner;

// Service responsável pela gestão do catálogo de pacotes espaciais.

public class PacoteService {

    // ── Atributo
    private List<PacoteEspacial> pacotes;

    // ── Construtor

    public PacoteService(List<PacoteEspacial> pacotes) {
        this.pacotes = pacotes;
    }

    // ── Métodos de negócio

    public void listarPacotesAtivos() {
        // TODO: filtrar pacotes com ativo=true e exibir no console
        System.out.println("===== PACOTES ATIVOS =====");
        for (PacoteEspacial p : pacotes) {
            if (p.isAtivo()) {
                System.out.println("PACOTE | " + p);
            }
        }
    }

    public void filtrarPorDestino(String destino) {
        // TODO: filtrar por destino contendo a string e exibir
    }

    public PacoteEspacial buscarPorId(int id) {
        // TODO: percorrer lista e retornar o pacote com o id correspondente
        return null;
    }

    public void cadastrarPacote(PacoteEspacial pacote, Scanner scanner) {
        // TODO: adicionar pacote na lista
        System.out.println("Digite o Destino");
        System.out.print(": ");
        String destino = scanner.nextLine();

        System.out.println("Digite o preco");
        System.out.print(": ");
        double preco = scanner.nextDouble();

        System.out.println("Digite as vagas totais");
        System.out.print(": ");
        int vagasTotais = scanner.nextInt();

        System.out.println("Digite a data da viagem (Ex: DD/MM/AAAA)");
        System.out.print(": ");
        String dataViagem = scanner.nextLine();

        System.out.println("Digite a descricao da viagem");
        System.out.print(": ");
        String descricao = scanner.nextLine();
        scanner.nextLine();

        pacotes.add(new PacoteEspacial(0,destino,preco,vagasTotais,dataViagem,descricao));

       System.out.println("Pacote cadastrado com sucesso");
    }

    // ── Getter

    public List<PacoteEspacial> getPacotes() { return pacotes; }
}
