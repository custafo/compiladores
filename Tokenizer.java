import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    String type;
    String value;


    public Tokenizer(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public static List<String> analyzer(String txt) {
        int cont = 0;

        List<String> tokens = new ArrayList<>();

        while (cont < txt.length()) {

            char caracter = txt.charAt(cont);

            if (caracter == '(') {
                Tokenizer token = new Tokenizer("paren", "(");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == ')') {
                Tokenizer token = new Tokenizer("paren", ")");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '{') {
                Tokenizer token = new Tokenizer("chave", "{");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '}') {
                Tokenizer token = new Tokenizer("chave", "{");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '[') {
                Tokenizer token = new Tokenizer("colchete", "[");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == ']') {
                Tokenizer token = new Tokenizer("colchete", "]");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '_') {
                Tokenizer token = new Tokenizer("sublinhado", "_");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == ',') {
                Tokenizer token = new Tokenizer("virgula", ",");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == ';') {
                Tokenizer token = new Tokenizer("pontoVirgula", ";");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }


            if (caracter == '.') {
                Tokenizer token = new Tokenizer("ponto", ".");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '=') {
                Tokenizer token = new Tokenizer("igual", "=");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '+') {
                Tokenizer token = new Tokenizer("soma", "+");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '-') {
                Tokenizer token = new Tokenizer("sub", "-");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '*') {
                Tokenizer token = new Tokenizer("mult", "*");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '/') {
                Tokenizer token = new Tokenizer("div", "/");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '%') {
                Tokenizer token = new Tokenizer("porc", "%");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '&') {
                Tokenizer token = new Tokenizer("porc", "%");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '|') {
                Tokenizer token = new Tokenizer("porc", "%");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '!') {
                Tokenizer token = new Tokenizer("exc", "!");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '>') {
                Tokenizer token = new Tokenizer("maior", ">");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '<') {
                Tokenizer token = new Tokenizer("menor", "<");
                tokens.add(String.valueOf(caracter));
                cont++;
                continue;
            }

            if (caracter == '"') {
                Tokenizer token = new Tokenizer("aspas", "");
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
                tokens.add(new Tokenizer("number", value.toString()).toString());
                continue;
            }


            String LETTERS = "[a-zA-Z]";
            if (String.valueOf(caracter).matches(LETTERS)) {
                StringBuilder value = new StringBuilder();
                while (String.valueOf(caracter).matches(LETTERS)) {
                    value.append(caracter);
                    caracter = txt.charAt(++cont);
                }
                tokens.add(String.valueOf(new Tokenizer("name", value.toString()).toString()));
                continue;
            }

            throw new IllegalArgumentException("ERRO: caracter não reconhecido." + caracter);
        }
        return tokens;
    }
}


