package app;

import model.*;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 // Ponto de entrada do sistema ASTRA.
 // Inicializa as listas em memória com dados de exemplo e inicia o menu principal.

public class Main {

    public static void main(String[] args) {

        // ── Listas em memória
        List<Turista> turistas  = new ArrayList<>();
        List<Medico> medicos    = new ArrayList<>();
        List<Operadora> operadoras = new ArrayList<>();
        List<PacoteEspacial> pacotes   = new ArrayList<>();
        List<Reserva> reservas   = new ArrayList<>();

        // ── Dados de exemplo
        // TODO: instanciar pelo menos 2 turistas, 1 médico, 1 operadora e 2 pacotes

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
