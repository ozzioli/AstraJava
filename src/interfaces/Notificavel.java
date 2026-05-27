package interfaces;

/**
 * Interface para entidades que recebem notificações do sistema.
 * Implementada por: Turista, Medico
 */
public interface Notificavel {

    /**
     * Recebe e exibe uma mensagem de notificação do sistema.
     * @param mensagem texto da notificação
     */
    void receberNotificacao(String mensagem);
}
