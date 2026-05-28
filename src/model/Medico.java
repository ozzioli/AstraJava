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
        super(id, nome, email, senha, dataCadastro);
        this.crm          = crm;
        this.especialidade = especialidade;
    }

    // ── Implementação de UsuarioBase ──────────────────────────────────────────

    @Override
    public void exibirPerfil() {
        // TODO: implementar exibição no console
    }

    // ── Implementação de Notificavel ──────────────────────────────────────────

    @Override
    public void receberNotificacao(String mensagem) {
        // TODO: implementar exibição de notificação
    }

    // ── Métodos de domínio ────────────────────────────────────────────────────

    public void avaliarCandidato(Turista turista, boolean aprovado, String justificativa) {
        // TODO: implementar aprovação/reprovação
    }

    // ── Getters e Setters ─────────────────────────────────────────────────────

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Medico{id=" + getId() +
                ", nome='" + getNome() +
                "', crm='" + crm +
                "', especialidade='" + especialidade + "'}";
    }
}
