package service;

import abstracts.UsuarioBase;
import app.MenuTurista;
import model.Medico;
import model.Operadora;
import model.Turista;
import util.Validador;

import java.util.List;
import java.util.Scanner;

import static util.DataUtil.getDataAtual;

 // Service responsável pela autenticação de usuários no sistema ASTRA.

public class AutenticacaoService {

    // ── Atributos
    private List<Turista>   turistas;
    private List<Medico>    medicos;
    private List<Operadora> operadoras;

    // ── Construtor

    public AutenticacaoService(List<Turista> turistas,
                               List<Medico> medicos,
                               List<Operadora> operadoras) {
        this.turistas   = turistas;
        this.medicos    = medicos;
        this.operadoras = operadoras;
    }

    // ── Métodos de negócio

    public UsuarioBase autenticar(String email, String senha){
        // TODO: buscar nas 3 listas e retornar o usuário encontrado
        for (Turista t : turistas) {
            if (t.getEmail().equals(email) && t.getSenha().equals(senha)) {
                return t;
            }
        }
        for (Medico m : medicos) {
            if (m.getEmail().equals(email) && m.getSenha().equals(senha)) {
                return m;
            }
        }
        for (Operadora o : operadoras) {
            if (o.getEmail().equals(email) && o.getSenha().equals(senha)) {
                return o;
            }
        }
        return null;
    }

    public String getTipoPerfil(UsuarioBase usuario) {
        // TODO: usar instanceof para retornar "TURISTA", "MEDICO" ou "OPERADORA"
        if (usuario instanceof Turista) {
            return "TURISTA";
        }
        if (usuario instanceof Medico) {
            return "MEDICO";
        }
        if (usuario instanceof Operadora) {
            return "OPERADORA";
        }
        return "DESCONHECIDO";
    }

    public boolean emailJaCadastrado(String email) {
        // TODO: verificar nas 3 listas se o email já existe

        for (Turista turista : turistas) {
            if (turista.getEmail().equals(email)) {
                System.out.println("Email ja cadastrado!");
                return true;
            }
        }
        for (Medico medico : medicos) {
            if (medico.getEmail().equals(email)) {
                System.out.println("Email ja cadastrado!");
                return true;
            }
        }
        for (Operadora operadora : operadoras) {
            if (operadora.getEmail().equals(email)) {
                System.out.println("Email ja cadastrado!");
                return true;
            }
        }
        return false;
    }

    public void cadastroTurista(Scanner scanner) {
        System.out.println("Digite seu Nome");
        System.out.print(": ");
        String nomeTurista = scanner.nextLine();

        System.out.println("Digite seu Email");
        System.out.print(": ");
        String emailTurista = scanner.nextLine();
        if (emailJaCadastrado(emailTurista)) {
            return;
        }

        System.out.println("Digite sua Senha");
        System.out.print(": ");
        String senhaTurista = scanner.nextLine();

        System.out.println("Digite sua Idade");
        System.out.print(": ");
        int IdadeTurista = scanner.nextInt();

        if (!Validador.validarIdade(IdadeTurista)) {
            System.out.println("Voce precisa ter mais de 18 anos!");
            return;
        }

        System.out.println("Digite seu CPF");
        System.out.print(": ");
        String cpfTurista = scanner.nextLine();
        scanner.nextLine();

        // gerar novo id
        int gerarID = turistas.stream().mapToInt(Turista::getId).max().orElse(0) + 1;

        turistas.add(new Turista(gerarID,nomeTurista,emailTurista,senhaTurista, getDataAtual(),IdadeTurista,cpfTurista));

        System.out.println("Turista cadastrado com sucesso!");

    }

    public void cadastroMedico(Scanner scanner) {

        System.out.println("Digite seu Nome");
        System.out.print(": ");
        String nomeMedico = scanner.nextLine();

        System.out.println("Digite seu Email");
        System.out.print(": ");
        String emailMedico = scanner.nextLine();
        if (emailJaCadastrado(emailMedico)) {
            return;
        }

        System.out.println("Digite sua Senha");
        System.out.print(": ");
        String senhaMedico = scanner.nextLine();

        System.out.println("Digite seu CRM");
        System.out.print(": ");
        String crmMedico = scanner.nextLine();

        System.out.println("Digite sua Especialidade");
        System.out.print(": ");
        String especMedico = scanner.nextLine();

        // gerar novo id
        int gerarID = medicos.stream().mapToInt(Medico::getId).max().orElse(0) + 1;

        medicos.add(new Medico(gerarID,nomeMedico,emailMedico,senhaMedico, getDataAtual(),crmMedico,especMedico));

        System.out.println("Medico cadastrado com sucesso!");

    }

    public void cadastroOperadora(Scanner scanner) {

        System.out.println("Digite seu Nome");
        System.out.print(": ");
        String nomeOperadora = scanner.nextLine();

        System.out.println("Digite seu Email");
        System.out.print(": ");
        String emailOperadora = scanner.nextLine();
        if (emailJaCadastrado(emailOperadora)) {
            return;
        }

        System.out.println("Digite sua Senha");
        System.out.print(": ");
        String senhaOperadora = scanner.nextLine();

        System.out.println("Digite sua Licenca");
        System.out.print(": ");
        String licencaOperadora = scanner.nextLine();

        // gerar novo id
        int gerarID = operadoras.stream().mapToInt(Operadora::getId).max().orElse(0) + 1;

        operadoras.add(new Operadora(gerarID,nomeOperadora,emailOperadora,senhaOperadora, getDataAtual(),licencaOperadora));

        System.out.println("Operadora cadastrada com sucesso!");

    }

    // ── Getters

    public List<Turista> getTuristas() {
        return turistas;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Operadora> getOperadoras() {
        return operadoras;
    }
}
