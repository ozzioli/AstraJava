package model;

import abstracts.UsuarioBase;
import java.util.List;

/**
 * Representa uma operadora de turismo espacial no sistema ASTRA.
 * Estende UsuarioBase. Gerencia os pacotes de viagem oferecidos.
 */
public class Operadora extends UsuarioBase {

    // ── Atributos específicos da Operadora ────────────────────────────────────
    private String            licenca;
    private List<PacoteEspacial> pacotes;

    // ── Construtores ─────────────────────────────────────────────────────────

    public Operadora() {
    }

    public Operadora(int id, String nome, String email, String senha,
                     String dataCadastro, String licenca) {
    }

    // ── Implementação de UsuarioBase ──────────────────────────────────────────

    /**
     * Exibe perfil da operadora: nome, licença e quantidade de pacotes ativos.
     */
    @Override
    public void exibirPerfil() {
    }

    // ── Métodos de domínio ────────────────────────────────────────────────────

    /**
     * Adiciona um novo pacote espacial ao catálogo da operadora.
     * @param pacote pacote a ser cadastrado
     */
    public void cadastrarPacote(PacoteEspacial pacote) {
    }

    /**
     * Lista todos os pacotes cadastrados pela operadora.
     */
    public void listarPacotes() {
    }

    // ── Getters e Setters ─────────────────────────────────────────────────────

    public String getLicenca() { return licenca; }
    public void setLicenca(String licenca) { }

    public List<PacoteEspacial> getPacotes() { return pacotes; }
    public void setPacotes(List<PacoteEspacial> pacotes) { }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return null;
    }
}
