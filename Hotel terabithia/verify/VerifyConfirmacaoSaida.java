package verify;

import java.nio.file.Files;
import java.nio.file.Path;

public class VerifyConfirmacaoSaida {
    static Boolean confirmouSaidaDoCadastro(String resposta) {
        String normalizada = resposta.trim().toUpperCase();
        if (normalizada.equals("S")) {
            return Boolean.TRUE;
        }
        if (normalizada.equals("N")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        Path kotlinHelper = Path.of("src", "confirmacaoSaida.kt");
        String source = Files.readString(kotlinHelper);
        if (!source.contains("\"S\" -> true")) {
            throw new AssertionError("Kotlin helper must map S to true");
        }
        if (!source.contains("\"N\" -> false")) {
            throw new AssertionError("Kotlin helper must map N to false");
        }
        if (!source.contains("else -> null")) {
            throw new AssertionError("Kotlin helper must reject other answers");
        }

        Path cadastro = Path.of("src", "cadastro de hospedes.kt");
        String cadastroSource = Files.readString(cadastro);
        if (cadastroSource.contains("exitProcess")) {
            throw new AssertionError("Guest menu must not kill the whole program");
        }
        int start = cadastroSource.indexOf("fun sairCadastroDeHospedes()");
        int end = cadastroSource.indexOf("fun erroCadastroDeHospedes()");
        if (start < 0 || end < 0 || end <= start) {
            throw new AssertionError("Could not locate sairCadastroDeHospedes");
        }
        String sairBody = cadastroSource.substring(start, end);
        if (sairBody.contains("cadastrarHospedes()")) {
            throw new AssertionError("Leaving the guest menu must not restart cadastrarHospedes");
        }
        if (!cadastroSource.contains("if (sairCadastroDeHospedes())")) {
            throw new AssertionError("Option 7 must honor the confirmation result");
        }

        check(confirmouSaidaDoCadastro("S") == Boolean.TRUE);
        check(confirmouSaidaDoCadastro("s") == Boolean.TRUE);
        check(confirmouSaidaDoCadastro("  s  ") == Boolean.TRUE);
        check(confirmouSaidaDoCadastro("N") == Boolean.FALSE);
        check(confirmouSaidaDoCadastro("n") == Boolean.FALSE);
        check(confirmouSaidaDoCadastro("nao") == null);
        check(confirmouSaidaDoCadastro("sim") == null);
        check(confirmouSaidaDoCadastro("") == null);
        System.out.println("VerifyConfirmacaoSaida: all checks passed");
    }

    static void check(boolean condition) {
        if (!condition) {
            throw new AssertionError("check failed");
        }
    }
}
