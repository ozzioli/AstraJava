package util;

 // Classe utilitária com métodos estáticos de validação de dados.
 // Usada em qualquer ponto do sistema para verificar entradas do usuário.

public class Validador {

    // Construtor
    private Validador() {
    }

     // Verifica se o email tem formato válido (contém @ e domínio).
     // @param email string a validar
     // @return true se o formato for válido

    public static boolean validarEmail(String email) {
        if (email == null) return false;
        return email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

     // Verifica se a senha tem comprimento mínimo de 6 caracteres.
     // @param senha string a validar
     // @return true se a senha for válida

    public static boolean validarSenha(String senha) {
        if (senha == null) return false;
        return senha.length() >= 6;
    }


     // Verifica se o CRM do médico tem formato válido (somente números, 4–6 dígitos).
     // @param crm string a validar
     // @return true se o CRM for válido

    public static boolean validarCrm(String crm) {
        if (crm == null) return false;
        return crm.matches("^\\d{4,6}$");
    }


     // Verifica se o turista tem pelo menos 18 anos (regra RN08).
     // @param idade idade informada
     // @return true se a idade for >= 18

    public static boolean validarIdade(int idade) {
        return idade >= 18;
    }

     // Verifica se uma string não está vazia nem nula.
     // @param valor string a verificar
     // @return true se não for vazia

    public static boolean campoPreenchido(String valor) {
        return valor != null && !valor.isBlank();
    }
}