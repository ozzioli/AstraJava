package util;

 // Classe utilitária com métodos estáticos de validação de dados.
 // Usada em qualquer ponto do sistema para verificar entradas do usuário.

public class Validador {

    // Construtor
    private Validador() {
    }

     // Verifica se o turista tem pelo menos 18 anos (regra RN08).
     // @param idade idade informada
     // @return true se a idade for >= 18

    public static boolean validarIdade(int idade) {
        return idade >= 18;
    }
}