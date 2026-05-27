package abstracts;

 // Classe abstrata base para os serviços do sistema ASTRA.
 // Padroniza a estrutura de execução de operações do catálogo.

public abstract class ServicoEspacial {

    private String nomeServico;
    private String descricao;

    // ── Construtores

    public ServicoEspacial(String nomeServico, String descricao ) {
        this.nomeServico=nomeServico;
        this.descricao=descricao;

    }

    // ── Método abstrato

    //  Executa a lógica principal do serviço.
    //  Cada subclasse implementa com @Override.

    public abstract void executar();

    // ── Getters e Setters

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    // ── toString

    @Override
    public String toString() {
        return "ServicoEspacial{" +
                "nomeServico='" + nomeServico + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
