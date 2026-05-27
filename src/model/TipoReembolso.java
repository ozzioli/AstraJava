package model;

/**
 * Representa o tipo de reembolso ao cancelar uma reserva.
 * Regra: >180 dias = TOTAL | 90–180 dias = PARCIAL | <90 dias = SEM_REEMBOLSO
 */
public enum TipoReembolso {

    TOTAL,          // cancelamento com mais de 180 dias de antecedência
    PARCIAL,        // cancelamento entre 90 e 180 dias
    SEM_REEMBOLSO   // cancelamento com menos de 90 dias
}
