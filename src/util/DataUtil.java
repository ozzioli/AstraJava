package util;

/**
 * Classe utilitária com métodos estáticos para operações com datas.
 * Trabalha com datas no formato dd/MM/yyyy como String.
 */
public class DataUtil {

    private DataUtil() {
    }

    /**
     * Calcula a diferença em dias entre duas datas.
     * @param dataInicio data inicial no formato dd/MM/yyyy
     * @param dataFim    data final no formato dd/MM/yyyy
     * @return número de dias entre as duas datas
     */
    public static long calcularDiferencaDias(String dataInicio, String dataFim) {
        return 0;
    }

    /**
     * Verifica se a data da viagem está com pelo menos 6 meses (180 dias) de antecedência.
     * Regra de negócio RN05.
     * @param dataViagem data do pacote no formato dd/MM/yyyy
     * @return true se a antecedência for suficiente
     */
    public static boolean verificarAntecedenciaMinima(String dataViagem) {
        return false;
    }

    /**
     * Retorna a data atual formatada como dd/MM/yyyy.
     * @return string com a data de hoje
     */
    public static String getDataAtual() {
        return null;
    }
}
