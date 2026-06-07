package interfaces;

import model.Reserva;
import model.Turista;

// Interface para entidades que podem ser reservadas e canceladas.
 // Implementada por: PacoteEspacial

public interface Reservavel {

     // Registra a reserva de um turista no pacote.
     // @param turista turista que deseja reservar
     // @return Reserva criada

    void reservar(Turista turista);

     // Cancela uma reserva existente e calcula o tipo de reembolso.
     // @param reserva reserva a ser cancelada

    void cancelar(Reserva reserva);
}
