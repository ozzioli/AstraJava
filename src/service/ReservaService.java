package service;

import model.PacoteEspacial;
import model.Reserva;
import model.Turista;

import java.util.List;

/**
 * Service responsável pela gestão de reservas e cancelamentos.
 * Aplica as regras de negócio: status APROVADO, antecedência mínima e política de reembolso.
 */
public class ReservaService {

    // ── Atributo ──────────────────────────────────────────────────────────────
    private List<Reserva> reservas; // lista em memória de todas as reservas

    // ── Construtor ────────────────────────────────────────────────────────────

    public ReservaService(List<Reserva> reservas) {
    }

    // ── Métodos de negócio ────────────────────────────────────────────────────

    /**
     * Realiza a reserva de um pacote para um turista.
     * Valida: status APROVADO, vagas disponíveis e antecedência mínima de 6 meses.
     * @param turista turista que deseja reservar
     * @param pacote  pacote escolhido
     * @return Reserva criada ou null em caso de falha
     */
    public Reserva realizarReserva(Turista turista, PacoteEspacial pacote) {
        return null;
    }

    /**
     * Cancela uma reserva ativa e calcula o tipo de reembolso.
     * Exibe o tipo de reembolso antes de confirmar o cancelamento.
     * @param reserva reserva a ser cancelada
     */
    public void cancelarReserva(Reserva reserva) {
    }

    /**
     * Lista todas as reservas ativas de um turista específico.
     * @param turista turista consultado
     */
    public void listarReservasPorTurista(Turista turista) {
    }

    /**
     * Lista todos os passageiros confirmados de um pacote específico.
     * @param pacote pacote consultado
     */
    public void listarPassageirosPorPacote(PacoteEspacial pacote) {
    }

    // ── Getter ────────────────────────────────────────────────────────────────

    public List<Reserva> getReservas() { return reservas; }
}
