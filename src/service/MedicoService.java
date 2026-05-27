package service;

import model.Medico;
import model.PlanoPreparacao;
import model.Turista;

import java.util.List;

/**
 * Service responsável pelas operações do painel médico.
 * Processa aprovações, reprovações e geração do plano de preparação.
 */
public class MedicoService {

    // ── Atributo ──────────────────────────────────────────────────────────────
    private List<Turista> turistas; // referência à lista global em memória

    // ── Construtor ────────────────────────────────────────────────────────────

    public MedicoService(List<Turista> turistas) {
    }

    // ── Métodos de negócio ────────────────────────────────────────────────────

    /**
     * Lista todos os turistas com status EM_AVALIACAO (pendentes de revisão médica).
     */
    public void listarCandidatosPendentes() {
    }

    /**
     * Processa a decisão do médico sobre um turista.
     * Se aprovado: atualiza status para APROVADO e gera PlanoPreparacao.
     * Se reprovado: atualiza status para REPROVADO e registra justificativa.
     * @param medico       médico responsável pela avaliação
     * @param turista      turista avaliado
     * @param aprovado     true = aprovado | false = reprovado
     * @param justificativa parecer médico obrigatório
     */
    public void processarDecisao(Medico medico, Turista turista,
                                 boolean aprovado, String justificativa) {
    }

    /**
     * Gera automaticamente um plano de preparação para o turista aprovado.
     * @param turista turista aprovado
     * @return PlanoPreparacao gerado
     */
    public PlanoPreparacao gerarPlanoPreparacao(Turista turista) {
        return null;
    }

    // ── Getter ────────────────────────────────────────────────────────────────

    public List<Turista> getTuristas() { return turistas; }
}
