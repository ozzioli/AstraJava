package service;

import model.*;
import util.DataUtil;

import java.util.List;

 // Service responsável pela gestão de reservas e cancelamentos.

public class ReservaService {

    // ── Atributo
    private List<Reserva> reservas;

    // ── Construtor

    public ReservaService(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // ── Métodos de negócio

    public void realizarReserva(Turista turista, PacoteEspacial pacote) {
        // TODO: validar status APROVADO, vagas e antecedência mínima (DataUtil)

        if (turista.getStatusAptidao().equals(StatusTurista.APROVADO)) {
            if (pacote.temVagaDisponivel()){
                int gerarID = reservas.stream().mapToInt(Reserva::getId).max().orElse(0) + 1;
                Reserva reserva = new Reserva(gerarID, turista, pacote, DataUtil.getDataAtual());
                pacote.reservar(turista);
                reservas.add(reserva);
                System.out.println("Reserva feita com sucesso!");
                return;

            }
        }
        System.out.println("Erro ao realizar reserva");
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
                System.out.println("ID: " + reserva.getId() + ". "+ reserva);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("SEM RESERVAS");
        }

    }

    public void listarPassageirosPorPacote(PacoteEspacial pacote) {
        // TODO: filtrar reservas pelo pacote e exibir turistas

        System.out.println("===== PASSAGEIROS =====");
        boolean encontrou = false;
        for (Reserva reserva : reservas) {
            if (reserva.getPacote() == pacote) {
                System.out.println("ID: " + reserva.getId() + ". PASSAGEIRO: "+ reserva.getTurista().getNome());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("SEM PASSAGEIROS");
        }

    }

    public void listarStatusPassageiros(PacoteEspacial pacote) {
        // TODO: filtrar reservas pelo pacote e exibir turistas

        System.out.println("===== RESERVAS  FEITAS =====");
        boolean encontrou = false;
        for (Reserva reserva : reservas) {
            if (reserva.getPacote() == pacote) {
                System.out.println("ID: " + reserva.getId() + ". PASSAGEIRO: "+ reserva.getTurista().getNome() + " | STATUS: " + reserva.getTurista().getStatusAptidao());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("SEM PASSAGEIROS");
        }

    }



    // ── Getter

    public List<Reserva> getReservas() { return reservas; }
}
