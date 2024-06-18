import java.util.regex.Pattern;

public class CPFValidator {

    public static boolean isValidCPF(String cpf) {
        // Verifica se o CPF está no formato correto
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            return false;
        }

        // Remove os caracteres de pontuação
        cpf = cpf.replace(".", "").replace("-", "");

        // Verifica se todos os dígitos são iguais (ex.: 111.111.111-11)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula os dígitos verificadores
        try {
            int[] cpfDigits = new int[11];
            for (int i = 0; i < 11; i++) {
                cpfDigits[i] = Integer.parseInt(cpf.substring(i, i + 1));
            }

            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < 9; i++) {
                sum1 += cpfDigits[i] * (10 - i);
                sum2 += cpfDigits[i] * (11 - i);
            }

            int digit1 = 11 - (sum1 % 11);
            if (digit1 >= 10) {
                digit1 = 0;
            }

            sum2 += digit1 * 2;
            int digit2 = 11 - (sum2 % 11);
            if (digit2 >= 10) {
                digit2 = 0;
            }

            // Verifica se os dígitos calculados conferem com os dígitos fornecidos
            return (digit1 == cpfDigits[9] && digit2 == cpfDigits[10]);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
