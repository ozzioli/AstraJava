package model;

 // Representa os possíveis estados de um turista no sistema ASTRA.
public enum StatusTurista {

    CADASTRADO,       // recém-cadastrado, ainda não avaliado
    EM_AVALIACAO,     // questionário respondido, aguardando médico
    APROVADO,         // médico aprovou — pode reservar pacotes
    REPROVADO,        // médico reprovou — precisa se preparar mais
    INAPTO            // score abaixo de 60 — não avança para médico

}
