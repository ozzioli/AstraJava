package model;

import abstracts.UsuarioBase;
import interfaces.Notificavel;

/**
 * Representa um médico avaliador no sistema ASTRA.
 * Estende UsuarioBase e implementa Notificavel.
 */
public class Medico extends UsuarioBase implements Notificavel {

    // ── Atributos específicos do Médico ───────────────────────────────────────
    private String crm;
    private String especialidade;

    // ── Construtores ─────────────────────────────────────────────────────────

    public Medico() {
    }

    public Medico(int id, String nome, String email, String senha,
                  String dataCadastro, String crm, String especialidade) {
    }

    // ── Implementação de UsuarioBase ──────────────────────────────────────────

    /**
     * Exibe perfil do médico: nome, CRM e especialidade.
     */
    @Override
    public void exibirPerfil() {
    }

    // ── Implementação de Notificavel ──────────────────────────────────────────

    /**
     * Exibe uma notificação para o médico no console.
     */
    @Override
    public void receberNotificacao(String mensagem) {
    }

    // ── Métodos de domínio ────────────────────────────────────────────────────

    /**
     * Aprova ou reprova um turista após análise do questionário.
     * Atualiza o status do turista e registra a justificativa.
     * @param turista   turista a ser avaliado
     * @param aprovado  true = aprovado | false = reprovado
     * @param justificativa texto com o parecer médico
     */
    public void avaliarCandidato(Turista turista, boolean aprovado, String justificativa) {
    }

    // ── Getters e Setters ─────────────────────────────────────────────────────

    public String getCrm() { return crm; }
    public void setCrm(String crm) { }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return null;
    }
}
