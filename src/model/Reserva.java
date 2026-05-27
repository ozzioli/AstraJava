package model;

/**
 * Representa a reserva de um turista em um pacote espacial.
 * Registra o vínculo Turista <-> PacoteEspacial com status e tipo de reembolso.
 */
public class Reserva {

    // ── Atributos ────────────────────────────────────────────────────────────
    private int            id;
    private Turista        turista;
    private PacoteEspacial pacote;
    private String         dataReserva;    // formato: dd/MM/yyyy
    private boolean        ativa;
    private TipoReembolso  tipoReembolso;  // calculado ao cancelar

    // ── Construtores ─────────────────────────────────────────────────────────

    public Reserva() {
    }

    public Reserva(int id, Turista turista, PacoteEspacial pacote, String dataReserva) {
    }

    // ── Métodos de domínio ────────────────────────────────────────────────────

    /**
     * Calcula o tipo de reembolso com base nos dias restantes para a viagem.
     * Regras: >180 dias = TOTAL | 90–180 dias = PARCIAL | <90 dias = SEM_REEMBOLSO
     * @return TipoReembolso correspondente ao prazo
     */
    public TipoReembolso calcularReembolso() {
        return null;
    }

    // ── Getters e Setters ─────────────────────────────────────────────────────

    public int getId() { return id; }
    public void setId(int id) { }

    public Turista getTurista() { return turista; }
    public void setTurista(Turista turista) { }

    public PacoteEspacial getPacote() { return pacote; }
    public void setPacote(PacoteEspacial pacote) { }

    public String getDataReserva() { return dataReserva; }
    public void setDataReserva(String dataReserva) { }

    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { }

    public TipoReembolso getTipoReembolso() { return tipoReembolso; }
    public void setTipoReembolso(TipoReembolso tipoReembolso) { }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return null;
    }
}
