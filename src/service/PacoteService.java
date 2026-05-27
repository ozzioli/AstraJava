package service;

import model.PacoteEspacial;

import java.util.List;

/**
 * Service responsável pela gestão do catálogo de pacotes espaciais.
 */
public class PacoteService {

    // ── Atributo ──────────────────────────────────────────────────────────────
    private List<PacoteEspacial> pacotes; // lista em memória de todos os pacotes

    // ── Construtor ────────────────────────────────────────────────────────────

    public PacoteService(List<PacoteEspacial> pacotes) {
    }

    // ── Métodos de negócio ────────────────────────────────────────────────────

    /**
     * Lista todos os pacotes ativos disponíveis para reserva.
     */
    public void listarPacotesAtivos() {
    }

    /**
     * Filtra e exibe pacotes por destino.
     * @param destino nome ou trecho do destino buscado
     */
    public void filtrarPorDestino(String destino) {
    }

    /**
     * Busca um pacote pelo seu ID.
     * @param id identificador do pacote
     * @return PacoteEspacial encontrado ou null
     */
    public PacoteEspacial buscarPorId(int id) {
        return null;
    }

    /**
     * Cadastra um novo pacote na lista em memória.
     * @param pacote pacote a ser adicionado
     */
    public void cadastrarPacote(PacoteEspacial pacote) {
    }

    // ── Getter ────────────────────────────────────────────────────────────────

    public List<PacoteEspacial> getPacotes() { return pacotes; }
}
