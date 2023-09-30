import java.util.ArrayList;
import java.util.List;

public class AnalisadorLexico {
    String tipo;
    String valor;


    public AnalisadorLexico(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public static List<String> analisador(String txt) {
        int cont = 0;

        List<String> tokens = new ArrayList<>();

        while (cont < txt.length()) {

            char caracter = txt.charAt(cont);

            if (caracter == '(') {
                AnalisadorLexico token = new AnalisadorLexico("paren", "(");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == ')') {
                AnalisadorLexico token = new AnalisadorLexico("paren", ")");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '{') {
                AnalisadorLexico token = new AnalisadorLexico("chave", "{");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '}') {
                AnalisadorLexico token = new AnalisadorLexico("chave", "{");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '[') {
                AnalisadorLexico token = new AnalisadorLexico("colchete", "[");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == ']') {
                AnalisadorLexico token = new AnalisadorLexico("colchete", "]");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '_') {
                AnalisadorLexico token = new AnalisadorLexico("sublinhado", "_");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == ',') {
                AnalisadorLexico token = new AnalisadorLexico("virgula", ",");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == ';') {
                AnalisadorLexico token = new AnalisadorLexico("pontoVirgula", ";");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }


            if (caracter == '.') {
                AnalisadorLexico token = new AnalisadorLexico("ponto", ".");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '=') {
                AnalisadorLexico token = new AnalisadorLexico("igual", "=");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '+') {
                AnalisadorLexico token = new AnalisadorLexico("soma", "+");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '-') {
                AnalisadorLexico token = new AnalisadorLexico("sub", "-");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '*') {
                AnalisadorLexico token = new AnalisadorLexico("mult", "*");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '/') {
                AnalisadorLexico token = new AnalisadorLexico("div", "/");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '%') {
                AnalisadorLexico token = new AnalisadorLexico("porc", "%");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '&') {
                AnalisadorLexico token = new AnalisadorLexico("porc", "%");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '|') {
                AnalisadorLexico token = new AnalisadorLexico("porc", "%");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '!') {
                AnalisadorLexico token = new AnalisadorLexico("exc", "!");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '>') {
                AnalisadorLexico token = new AnalisadorLexico("maior", ">");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '<') {
                AnalisadorLexico token = new AnalisadorLexico("menor", "<");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '"') {
                AnalisadorLexico token = new AnalisadorLexico("aspas", "");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            String WHITESPACE = "\\s";
            if (WHITESPACE.matches(caracter + "")) {
                cont++;
                continue;
            }

            String NUMBERS = "[0-9]";
            if (String.valueOf(caracter).matches(NUMBERS)) {
                StringBuilder value = new StringBuilder();
                while (String.valueOf(caracter).matches(NUMBERS)) {
                    value.append(caracter);
                    caracter = txt.charAt(++cont);
                }
                tokens.add(new AnalisadorLexico("number", value.toString()).toString());
                continue;
            }


            String LETTERS = "[a-zA-Z]";
            if (String.valueOf(caracter).matches(LETTERS)) {
                StringBuilder value = new StringBuilder();
                while (String.valueOf(caracter).matches(LETTERS)) {
                    value.append(caracter);
                    caracter = txt.charAt(++cont);
                }
                tokens.add(String.valueOf(new AnalisadorLexico("name", value.toString()).toString()));
                continue;
            }

            throw new IllegalArgumentException("ERRO: caracter não reconhecido." + caracter);
        }
        return tokens;
    }
}


