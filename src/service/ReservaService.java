package service;

import model.PacoteEspacial;
import model.Reserva;
import model.Turista;

import java.util.List;

/**
 * Service responsável pela gestão de reservas e cancelamentos.
 */
public class ReservaService {

    // ── Atributo ──────────────────────────────────────────────────────────────
    private List<Reserva> reservas;

    // ── Construtor ────────────────────────────────────────────────────────────

    public ReservaService(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // ── Métodos de negócio ────────────────────────────────────────────────────

    public Reserva realizarReserva(Turista turista, PacoteEspacial pacote) {
        // TODO: validar status APROVADO, vagas e antecedência mínima (DataUtil)
        return null;
    }

    public void cancelarReserva(Reserva reserva) {
        // TODO: chamar calcularReembolso(), exibir tipo antes de confirmar, marcar como inativa
    }

    public void listarReservasPorTurista(Turista turista) {
        // TODO: filtrar reservas pelo turista e exibir
    }

    public void listarPassageirosPorPacote(PacoteEspacial pacote) {
        // TODO: filtrar reservas pelo pacote e exibir turistas
    }

    // ── Getter ────────────────────────────────────────────────────────────────

    public List<Reserva> getReservas() { return reservas; }
}
