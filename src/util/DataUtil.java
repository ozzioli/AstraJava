package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

 // Classe utilitária com métodos estáticos para operações com datas.
 // Trabalha com datas no formato dd/MM/yyyy como String.

public class DataUtil {

    private DataUtil() {
    }

     //Calcula a diferença em dias entre duas datas.
     // @param dataInicio data inicial no formato dd/MM/yyyy
     // @param dataFim    data final no formato dd/MM/yyyy
     // @return número de dias entre as duas datas

    public static long calcularDiferencaDias(String dataInicio, String dataFim) {
        return 0;
    }

     // Retorna a data atual formatada como dd/MM/yyyy.
     // @return string com a data de hoje

    public static String getDataAtual() {
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return  hoje.format(formato);
    }
}
