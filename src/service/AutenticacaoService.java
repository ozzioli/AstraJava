package service;

import abstracts.UsuarioBase;
import model.Medico;
import model.Operadora;
import model.Turista;

import java.util.List;

/**
 * Service responsável pela autenticação de usuários no sistema ASTRA.
 */
public class AutenticacaoService {

    // ── Atributos ────────────────────────────────────────────────────────────
    private List<Turista>   turistas;
    private List<Medico>    medicos;
    private List<Operadora> operadoras;

    // ── Construtor ────────────────────────────────────────────────────────────

    public AutenticacaoService(List<Turista> turistas,
                               List<Medico> medicos,
                               List<Operadora> operadoras) {
        this.turistas   = turistas;
        this.medicos    = medicos;
        this.operadoras = operadoras;
    }

    // ── Métodos de negócio ────────────────────────────────────────────────────

    public UsuarioBase autenticar(String email, String senha) {
        // TODO: buscar nas 3 listas e retornar o usuário encontrado
        return null;
    }

    public String getTipoPerfil(UsuarioBase usuario) {
        // TODO: usar instanceof para retornar "TURISTA", "MEDICO" ou "OPERADORA"
        return null;
    }

    public boolean emailJaCadastrado(String email) {
        // TODO: verificar nas 3 listas se o email já existe
        return false;
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    public List<Turista> getTuristas() { return turistas; }
    public List<Medico> getMedicos() { return medicos; }
    public List<Operadora> getOperadoras() { return operadoras; }
}
