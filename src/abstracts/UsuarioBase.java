package abstracts;

 // Classe abstrata base para todos os tipos de usuário do sistema ASTRA.
 // Contém os atributos e comportamentos comuns a Turista, Medico e Operadora.

public abstract class UsuarioBase {

    // ── Atributos
    private int    id;
    private String nome;
    private String email;
    private String senha;
    private String dataCadastro;

    // ── Construtores

    public UsuarioBase() {
    }

    public UsuarioBase(int id, String nome, String email, String senha, String dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }

    // ── Método abstrato (sobrescrito por cada subclasse)

     // Exibe no console as informações específicas do perfil de cada tipo de usuário.
     // Cada subclasse implementa com @Override.

    public abstract void exibirPerfil();

    // ── Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    // ── toString

    @Override
    public String toString() {
        return "UsuarioBase{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataCadastro='" + dataCadastro + '\'' +
                '}';
    }
}
