package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a reserva de um turista em um pacote espacial.
 */
public class Reserva {

    // ── Atributos ────────────────────────────────────────────────────────────
    private int id;
    private Turista turista;
    private PacoteEspacial pacote;
    private String dataReserva;
    private boolean ativa;
    private TipoReembolso  tipoReembolso;

    // ── Construtores ─────────────────────────────────────────────────────────

    public Reserva() {
    }

    public Reserva(int id, Turista turista, PacoteEspacial pacote, String dataReserva) {
        this.id          = id;
        this.turista     = turista;
        this.pacote      = pacote;
        this.dataReserva = dataReserva;
        this.ativa       = true;
    }

    // ── Métodos de domínio ────────────────────────────────────────────────────

    public TipoReembolso calcularReembolso() {
        // TODO: usar DataUtil para calcular dias restantes e aplicar regra dos 180/90 dias
        return null;
    }

    // ── Getters e Setters ─────────────────────────────────────────────────────

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Turista getTurista() { return turista; }
    public void setTurista(Turista turista) { this.turista = turista; }

    public PacoteEspacial getPacote() { return pacote; }
    public void setPacote(PacoteEspacial pacote) { this.pacote = pacote; }

    public String getDataReserva() { return dataReserva; }
    public void setDataReserva(String dataReserva) { this.dataReserva = dataReserva; }

    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }

    public TipoReembolso getTipoReembolso() { return tipoReembolso; }
    public void setTipoReembolso(TipoReembolso tipoReembolso) { this.tipoReembolso = tipoReembolso; }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Reserva{id=" + id +
                ", turista='" + (turista != null ? turista.getNome() : "N/A") +
                "', pacote='" + (pacote != null ? pacote.getDestino() : "N/A") +
                "', dataReserva='" + dataReserva +
                "', ativa=" + ativa + "}";
    }
}
