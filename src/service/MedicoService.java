package service;

import model.Medico;
import model.PlanoPreparacao;
import model.Turista;

import java.util.List;

/**
 * Service responsável pelas operações do painel médico.
 */
public class MedicoService {

    // ── Atributo ──────────────────────────────────────────────────────────────
    private List<Turista> turistas;

    // ── Construtor ────────────────────────────────────────────────────────────

    public MedicoService(List<Turista> turistas) {
        this.turistas = turistas;
    }

    // ── Métodos de negócio ────────────────────────────────────────────────────

    public void listarCandidatosPendentes() {
        // TODO: filtrar turistas com status EM_AVALIACAO e exibir
    }

    public void processarDecisao(Medico medico, Turista turista,
                                 boolean aprovado, String justificativa) {
        // TODO: atualizar status do turista e gerar plano se aprovado
    }

    public PlanoPreparacao gerarPlanoPreparacao(Turista turista) {
        // TODO: montar PlanoPreparacao com treinos e orientações padrão
        return null;
    }

    // ── Getter ────────────────────────────────────────────────────────────────

    public List<Turista> getTuristas() { return turistas; }
}
