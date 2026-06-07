package model;

import abstracts.UsuarioBase;
import interfaces.Notificavel;

import static model.StatusTurista.APROVADO;

// Representa um médico avaliador no sistema ASTRA.
 // Estende UsuarioBase e implementa Notificavel.

public class Medico extends UsuarioBase implements Notificavel {

    // ── Atributos específicos do Médico
    private String crm;
    private String especialidade;

    // ── Construtores

    public Medico() {
    }

    public Medico(int id, String nome, String email, String senha,
                  String dataCadastro, String crm, String especialidade) {
        super(id, nome, email, senha, dataCadastro);
        this.crm          = crm;
        this.especialidade = especialidade;
    }

    // ── Implementação de UsuarioBase

    @Override
    public void exibirPerfil() {
        // TODO: implementar exibição no console
        System.out.println("PERFIL DO MEDICO:");
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("CRM: " + getCrm());
        System.out.println("Especialidade: " + getEspecialidade());
    }

    // ── Implementação de Notificavel

    @Override
    public void receberNotificacao(String mensagem) {
        // TODO: implementar exibição de notificação
        System.out.println("Notificacao - " + getNome() + " | " + mensagem );
    }

    // ── Métodos de domínio


    public void avaliarCandidato(Turista turista, boolean aprovado, String justificativa) {
        // TODO: implementar aprovação/reprovação
        if (aprovado) {
            turista.setStatusAptidao(APROVADO);
        }
        else {
            turista.setStatusAptidao(StatusTurista.REPROVADO);
        }

    }

    // ── Getters e Setters

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    // ── toString

    @Override
    public String toString() {
        return "Medico{id=" + getId() +
                ", nome='" + getNome() +
                "', crm='" + crm +
                "', especialidade='" + especialidade + "'}";
    }
}
