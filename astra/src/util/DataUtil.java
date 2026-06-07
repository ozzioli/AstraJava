package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

 // Classe utilitária com métodos estáticos para operações com datas.
 // Trabalha com datas no formato dd/MM/yyyy como String.

public class DataUtil {

    private DataUtil() {
    }

     //Calcula a data limite (100 dias) para concluir a preparacao espacial

    public static String calcularDataLimite(String dataInicio) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate data = LocalDate.parse(dataInicio, formato);

        LocalDate dataLimite = data.plusDays(100);

        return dataLimite.format(formato);
    }

     // Retorna a data atual formatada como dd/MM/yyyy.
     // @return string com a data de hoje

    public static String getDataAtual() {
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return  hoje.format(formato);
    }
}
