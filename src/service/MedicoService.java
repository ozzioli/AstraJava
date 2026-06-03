package service;

import model.Medico;
import model.PlanoPreparacao;
import model.StatusTurista;
import model.Turista;
import util.DataUtil;

import java.util.Arrays;
import java.util.List;

 // Service responsável pelas operações do painel médico.

public class MedicoService {

    // ── Atributo
    private List<Turista> turistas;

    // ── Construtor

    public MedicoService(List<Turista> turistas) {
        this.turistas = turistas;
    }

    // ── Métodos de negócio

    public void listarCandidatosPendentes() {
        List<Turista> pendentes = turistas.stream()
                .filter(t -> t.getStatusAptidao() == StatusTurista.EM_AVALIACAO)
                .toList();

        if (pendentes.isEmpty()) {
            System.out.println("Nenhum candidato pendente no momento.");
            return;
        }

        pendentes.forEach(t -> System.out.printf(
                "• [ID %d] %s | Score: %.1f%n", t.getId(), t.getNome(), t.getScoreAtual()));
    }

    public void processarDecisao(Medico medico, Turista turista,
                                 boolean aprovado, String justificativa) {
        medico.avaliarCandidato(turista, aprovado, justificativa);

        if (!aprovado) {
            turista.setJustificativaMedica(justificativa);
        } else {
            PlanoPreparacao plano = gerarPlanoPreparacao(turista);
            turista.setPlanoPreparacao(plano);
        }
    }

    public PlanoPreparacao gerarPlanoPreparacao(Turista turista) {
        List<String> treinos = Arrays.asList(
                "Corrida leve 30min (3x por semana)",
                "Treino de força funcional (2x por semana)",
                "Yoga ou alongamento (2x por semana)",
                "Simulação de ambiente de gravidade reduzida (1x por semana)"
        );

        List<String> orientacoes = Arrays.asList(
                "Manter hidratação adequada (mínimo 2L de água/dia)",
                "Dieta rica em proteínas e baixo sódio",
                "Evitar bebidas alcoólicas e cafeína em excesso",
                "Dormir pelo menos 8 horas por noite"
        );

        String dataInicio = DataUtil.getDataAtual();
        String dataLimite = DataUtil.getDataAtual();

        PlanoPreparacao plano = new PlanoPreparacao(
                turista.getId(),
                treinos,
                orientacoes,
                dataInicio,
                dataLimite
        );

        plano.setObservacoes("Plano gerado automaticamente após aprovação médica.");
        return plano;
    }

    // ── Getter

    public List<Turista> getTuristas() { return turistas; }
}