package model;

 // Representa a classificação do Space Readiness Score do turista.

public enum ClassificacaoScore {

    INAPTO,             // score < 40
    EM_DESENVOLVIMENTO, // score >= 40 e < 60
    APTO                // score >= 60 — avança para avaliação médica
}
