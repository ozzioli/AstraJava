package service;

import abstracts.UsuarioBase;
import model.Medico;
import model.Operadora;
import model.Turista;

import java.util.List;

/**
 * Service responsável pela autenticação de usuários no sistema ASTRA.
 * Valida email e senha contra as listas em memória e retorna o tipo de perfil.
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
    }

    // ── Métodos de autenticação ───────────────────────────────────────────────

    /**
     * Autentica um usuário pelo email e senha informados.
     * Verifica nas três listas (turistas, médicos, operadoras).
     * @param email email informado
     * @param senha senha informada
     * @return objeto UsuarioBase autenticado ou null se não encontrado
     */
    public UsuarioBase autenticar(String email, String senha) {
        return null;
    }

    /**
     * Retorna o tipo de perfil do usuário autenticado como String.
     * @param usuario usuário já autenticado
     * @return "TURISTA", "MEDICO", "OPERADORA" ou "DESCONHECIDO"
     */
    public String getTipoPerfil(UsuarioBase usuario) {
        return null;
    }

    /**
     * Verifica se um email já está cadastrado em qualquer lista.
     * Usado no cadastro para evitar duplicatas.
     * @param email email a verificar
     * @return true se já existe
     */
    public boolean emailJaCadastrado(String email) {
        return false;
    }
}
