package model;

import interfaces.Reservavel;

/**
 * Representa um pacote de viagem espacial disponível no catálogo.
 * Implementa Reservavel para gerenciar reservas e cancelamentos.
 */
public class PacoteEspacial implements Reservavel {

    // ── Atributos ────────────────────────────────────────────────────────────
    private int    id;
    private String destino;
    private double preco;
    private int    vagasTotais;
    private int    vagasDisponiveis;
    private String dataViagem;          // formato: dd/MM/yyyy
    private String descricao;
    private boolean ativo;

    // ── Construtores ─────────────────────────────────────────────────────────

    public PacoteEspacial() {
    }

    public PacoteEspacial(int id, String destino, double preco,
                          int vagasTotais, String dataViagem, String descricao) {
    }

    // ── Implementação de Reservavel ───────────────────────────────────────────

    /**
     * Registra a reserva do turista neste pacote.
     * Decrementa o número de vagas disponíveis.
     * @param turista turista que deseja reservar
     * @return Reserva criada
     */
    @Override
    public Reserva reservar(Turista turista) {
        return null;
    }

    /**
     * Cancela uma reserva existente.
     * Incrementa o número de vagas disponíveis.
     * @param reserva reserva a ser cancelada
     */
    @Override
    public void cancelar(Reserva reserva) {
    }

    // ── Métodos de domínio ────────────────────────────────────────────────────

    /**
     * Verifica se ainda há vagas disponíveis no pacote.
     * @return true se há pelo menos uma vaga
     */
    public boolean temVagaDisponivel() {
        return false;
    }

    // ── Getters e Setters ─────────────────────────────────────────────────────

    public int getId() { return id; }
    public void setId(int id) { }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { }

    public int getVagasTotais() { return vagasTotais; }
    public void setVagasTotais(int vagasTotais) { }

    public int getVagasDisponiveis() { return vagasDisponiveis; }
    public void setVagasDisponiveis(int vagasDisponiveis) { }

    public String getDataViagem() { return dataViagem; }
    public void setDataViagem(String dataViagem) { }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return null;
    }
}
