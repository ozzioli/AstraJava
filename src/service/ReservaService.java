package service;

import model.PacoteEspacial;
import model.Reserva;
import model.StatusTurista;
import model.Turista;
import util.DataUtil;

import javax.xml.crypto.Data;
import java.util.List;

 // Service responsável pela gestão de reservas e cancelamentos.

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

        if (turista.getStatusAptidao().equals(StatusTurista.APROVADO)) {
            if (pacote.temVagaDisponivel()){
                Reserva reserva = pacote.reservar(turista);
                reservas.add(reserva);
                System.out.println("Reserva feita com sucesso!");
                return reserva;

            }
        }
        System.out.println("Erro ao realizar reserva");
        return null;
    }

    public void cancelarReserva(Reserva reserva) {
        // TODO: exibir tipo antes de confirmar, marcar como inativa
        reserva.getPacote().cancelar(reserva);
        reservas.remove(reserva);
    }

    public void listarReservasPorTurista(Turista turista) {
        // TODO: filtrar reservas pelo turista e exibir
        System.out.println("===== SUAS RESERVAS =====");
        boolean encontrou = false;
        for (Reserva reserva : reservas) {
            if (reserva.getTurista() == turista) {
                System.out.println(reserva.getId() + ". "+ reserva);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("SEM RESERVAS");
        }

    }

    public void listarPassageirosPorPacote(PacoteEspacial pacote) {
        // TODO: filtrar reservas pelo pacote e exibir turistas
    }

    // ── Getter ────────────────────────────────────────────────────────────────

    public List<Reserva> getReservas() { return reservas; }
}
