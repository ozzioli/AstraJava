package service;

import model.PacoteEspacial;

import java.util.List;

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

    public int getLastID() {
        // TODO: Pegar o ultimo id do pacote para gerar um novo ID
        return pacotes.stream().mapToInt(PacoteEspacial::getId).max().orElse(0) + 1;
    }

    public PacoteEspacial buscarPorId(int id) {
        // TODO: percorrer lista e retornar o pacote com o id correspondente

        for (PacoteEspacial p : pacotes) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void cadastrarPacote(PacoteEspacial pacote) {
        // TODO: adicionar pacote na lista
        pacotes.add(pacote);
       System.out.println("Pacote cadastrado com sucesso");
    }

    // ── Getter

    public List<PacoteEspacial> getPacotes() { return pacotes; }
}
