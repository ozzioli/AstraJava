package model;

import interfaces.Reservavel;
import service.PacoteService;
import util.DataUtil;

import java.util.Scanner;

/**
 * Representa um pacote de viagem espacial disponível no catálogo.
 * Implementa Reservavel para gerenciar reservas e cancelamentos.
 */
public class PacoteEspacial implements Reservavel {

    // ── Atributos ────────────────────────────────────────────────────────────
    private int     id;
    private String  destino;
    private double  preco;
    private int     vagasTotais;
    private int     vagasDisponiveis;
    private String  dataViagem;
    private String  descricao;
    private boolean ativo;
    private PacoteService pacoteService;

    // ── Construtores ─────────────────────────────────────────────────────────

    public PacoteEspacial() {
    }

    public PacoteEspacial(int id, String destino, double preco,
                          int vagasTotais, String dataViagem, String descricao) {
        this.id               = id;
        this.destino          = destino;
        this.preco            = preco;
        this.vagasTotais      = vagasTotais;
        this.vagasDisponiveis = vagasTotais;
        this.dataViagem       = dataViagem;
        this.descricao        = descricao;
        this.ativo            = true;
    }

    // ── Implementação de Reservavel ───────────────────────────────────────────

    @Override
    public Reserva reservar(Turista turista) {
        // TODO: implementar reserva e decrementar vagas
        if (!temVagaDisponivel()) {
            return null;
        }

        if (turista == null) {
            return null;
        }

        this.vagasTotais--;
        System.out.println("Vaga ocupada com sucesso!");
        return new Reserva(0, turista, this, DataUtil.getDataAtual());
    }

    @Override
    public void cancelar(Reserva reserva) {
        // TODO: implementar cancelamento e incrementar vagas
    }

    // ── Métodos de domínio ────────────────────────────────────────────────────

    public boolean temVagaDisponivel() {
        // TODO: implementar verificação de vagas
        if (this.vagasTotais > 0) {
            return true;
        }
        if (this.vagasTotais <= 0) {
            throw new IllegalStateException("Sem vagas disponíveis nesse pacote.");
        }
        return false;
    }

    // ── Getters e Setters ─────────────────────────────────────────────────────

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getVagasTotais() { return vagasTotais; }
    public void setVagasTotais(int vagasTotais) { this.vagasTotais = vagasTotais; }

    public int getVagasDisponiveis() { return vagasDisponiveis; }
    public void setVagasDisponiveis(int vagasDisponiveis) { this.vagasDisponiveis = vagasDisponiveis; }

    public String getDataViagem() { return dataViagem; }
    public void setDataViagem(String dataViagem) { this.dataViagem = dataViagem; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "PacoteEspacial{id=" + id +
                ", destino='" + destino +
                "', preco=" + preco +
                ", vagasDisponiveis=" + vagasDisponiveis + "/" + vagasTotais +
                ", dataViagem='" + dataViagem + "'}";
    }
}
