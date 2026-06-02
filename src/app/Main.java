package app;

import model.*;
import service.*;
import util.DataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 // Ponto de entrada do sistema ASTRA.
 // Inicializa as listas em memória com dados de exemplo e inicia o menu principal.

public class Main {

    public static void main(String[] args) {

        // ── Listas em memória
        List<Turista> turistas = new ArrayList<>();
        List<Medico> medicos    = new ArrayList<>();
        List<Operadora> operadoras = new ArrayList<>();
        List<PacoteEspacial> pacotes   = new ArrayList<>();
        List<Reserva> reservas   = new ArrayList<>();

        // ── Dados de exemplo

        // Turistas
        turistas.add(new Turista(1, "Carlos Mendonca", "teste",
                "123", DataUtil.getDataAtual(), 45, "123.456.789-00"));

        for (Turista t : turistas) {
            if (t.getId() == 1) {
                t.setStatusAptidao(StatusTurista.APROVADO);
                break;
            }
        }

        turistas.add(new Turista(2, "Ana Lima", "ana@email.com",
                "senha123", DataUtil.getDataAtual(), 32, "987.654.321-00"));

        // Medico
        medicos.add(new Medico(3, "Dra. Aline Ferreira", "aline@clinica.com",
                "senha123", DataUtil.getDataAtual(), "54321", "Medicina Esportiva"));

        // operadoras
        operadoras.add(new Operadora(1, "SpaceX Tourism", "spacex",
                "123", DataUtil.getDataAtual(), "LIC-SPACE-001"));

        // Pacotes
        pacotes.add(new PacoteEspacial(1, "Lua", 850000.00, 12,
                "15/12/2028", "Experiencia orbital com hospedagem na estacao lunar Artemis."));

        pacotes.add(new PacoteEspacial(2, "Marte", 2500000.00, 6,
                "03/08/2028", "Missao interplanetaria premium com treinamento intensivo."));

        // ── Instância dos services
        ScoreService scoreService = new ScoreService();
        PacoteService pacoteService = new PacoteService(pacotes);
        ReservaService reservaService = new ReservaService(reservas);
        MedicoService medicoService = new MedicoService(turistas);
        AutenticacaoService autenticacaoService = new AutenticacaoService(turistas, medicos, operadoras);

        // ── Scanner compartilhado
        Scanner scanner = new Scanner(System.in);

        // ── Inicialização do menu principal
        MenuPrincipal menuPrincipal = new MenuPrincipal(scanner, autenticacaoService, pacoteService, reservaService, scoreService, medicoService);

        menuPrincipal.iniciar(scanner);

        scanner.close();
    }
}
