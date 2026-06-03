package model;

import abstracts.UsuarioBase;
import java.util.ArrayList;
import java.util.List;

 // Representa uma operadora de turismo espacial no sistema ASTRA.
 // Estende UsuarioBase. Gerencia os pacotes de viagem oferecidos.

public class Operadora extends UsuarioBase {

    // ── Atributos específicos da Operadora
    private String licenca;
    private List<PacoteEspacial> pacotes;

    // ── Construtores

    public Operadora() {
        this.pacotes = new ArrayList<>();
    }

    public Operadora(int id, String nome, String email, String senha,
                     String dataCadastro, String licenca) {
        super(id, nome, email, senha, dataCadastro);
        this.licenca = licenca;
        this.pacotes = new ArrayList<>();
    }

    // ── Implementação de UsuarioBase

    @Override
    public void exibirPerfil() {
        // TODO: implementar exibição no console
    }

    // ── Métodos de domínio

    public void cadastrarPacote(PacoteEspacial pacote) {
        // TODO: implementar cadastro de pacote
        pacotes.add(pacote);
        System.out.println("Pacote adicionado com sucesso");

    }

    public void listarPacotes() {
        // TODO: implementar listagem de pacotes
        for (PacoteEspacial pacote : pacotes) {
            System.out.println("PACOTE #"  + pacote.getId()  + " | " +  pacote.toString()  + " | ");
        }
    }

    // ── Getters e Setters

    public String getLicenca() { return licenca; }
    public void setLicenca(String licenca) { this.licenca = licenca; }

    public List<PacoteEspacial> getPacotes() { return pacotes; }
    public void setPacotes(List<PacoteEspacial> pacotes) { this.pacotes = pacotes; }

    // ── toString

    @Override
    public String toString() {
        return "Operadora{id=" + getId() +
                ", nome='" + getNome() +
                "', licenca='" + licenca +
                "', pacotes=" + (pacotes != null ? pacotes.size() : 0) + "}";
    }
}
