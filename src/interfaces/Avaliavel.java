package interfaces;

/**
 * Interface para entidades que passam pelo processo de avaliação de aptidão.
 * Implementada por: Turista
 */
public interface Avaliavel {

    /**
     * Inicia o questionário de aptidão do turista.
     * Preenche as respostas das categorias físico, cardiovascular e psicológico.
     */
    void responderQuestionario();

    /**
     * Retorna o score atual calculado para a entidade.
     * @return pontuação de 0 a 100
     */
    double getScoreAtual();
}
