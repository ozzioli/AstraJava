package service;

import model.PacoteEspacial;

import java.util.List;

/**
 * Service responsável pela gestão do catálogo de pacotes espaciais.
 */
public class PacoteService {

    // ── Atributo ──────────────────────────────────────────────────────────────
    private List<PacoteEspacial> pacotes;

    // ── Construtor ────────────────────────────────────────────────────────────

    public PacoteService(List<PacoteEspacial> pacotes) {
        this.pacotes = pacotes;
    }

    // ── Métodos de negócio ────────────────────────────────────────────────────

    public void listarPacotesAtivos() {
        // TODO: filtrar pacotes com ativo=true e exibir no console
    }

    public void filtrarPorDestino(String destino) {
        // TODO: filtrar por destino contendo a string e exibir
    }

    public PacoteEspacial buscarPorId(int id) {
        // TODO: percorrer lista e retornar o pacote com o id correspondente
        return null;
    }

    public void cadastrarPacote(PacoteEspacial pacote) {
        // TODO: adicionar pacote na lista
    }

    // ── Getter ────────────────────────────────────────────────────────────────

    public List<PacoteEspacial> getPacotes() { return pacotes; }
}
