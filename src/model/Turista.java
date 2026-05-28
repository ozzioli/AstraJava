package model;

import abstracts.UsuarioBase;
import interfaces.Avaliavel;
import interfaces.Notificavel;

 // Representa um turista espacial no sistema ASTRA.
 // Estende UsuarioBase e implementa Avaliavel e Notificavel.

public class Turista extends UsuarioBase implements Avaliavel, Notificavel {

    // ── Atributos específicos do Turista
    private int               idade;
    private String            cpf;
    private double            scoreAtual;
    private StatusTurista     statusAptidao;
    private AvaliacaoAptidao  avaliacao;
    private PlanoPreparacao   planoPreparacao;
    private String            justificativaMedica; // preenchida pelo médico ao reprovar

    // ── Construtores

    public Turista() {
    }

    public Turista(int id, String nome, String email, String senha,
                   String dataCadastro, int idade, String cpf) {
    }

    // ── Implementação de UsuarioBase

     // Exibe perfil completo do turista: nome, email, score e status de aptidão.

    @Override
    public void exibirPerfil() {
    }

    // ── Implementação de Avaliavel


    //  Inicia o questionário de aptidão via console (Scanner).
    //  Preenche as categorias físico, cardiovascular e psicológico.

    @Override
    public void responderQuestionario() {
    }

    // Retorna o score atual do turista.

    @Override
    public double getScoreAtual() {
        return scoreAtual;
    }

    // ── Implementação de Notificavel

    //  Exibe uma notificação para o turista no console.

    @Override
    public void receberNotificacao(String mensagem) {
    }

    // ── Getters e Setters

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setScoreAtual(double scoreAtual) {
        this.scoreAtual = scoreAtual;
    }

    public StatusTurista getStatusAptidao() {
        return statusAptidao;
    }

    public void setStatusAptidao(StatusTurista statusAptidao) {
        this.statusAptidao = statusAptidao;
    }

    public AvaliacaoAptidao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(AvaliacaoAptidao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public PlanoPreparacao getPlanoPreparacao() {
        return planoPreparacao;
    }

    public void setPlanoPreparacao(PlanoPreparacao planoPreparacao) {
        this.planoPreparacao = planoPreparacao;
    }

    public String getJustificativaMedica() {
        return justificativaMedica;
    }

    public void setJustificativaMedica(String justificativaMedica) {
        this.justificativaMedica = justificativaMedica;
    }


    // ── toString

    @Override
    public String toString() {
        return "Turista{" +
                "idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", scoreAtual=" + scoreAtual +
                ", statusAptidao=" + statusAptidao +
                ", avaliacao=" + avaliacao +
                ", planoPreparacao=" + planoPreparacao +
                ", justificativaMedica='" + justificativaMedica + '\'' +
                '}';
    }
}

