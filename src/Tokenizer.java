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

            char myChar = txt.charAt(cont);

            if (myChar == '(') {
                Tokenizer token = new Tokenizer("paren", "(");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == ')') {
                Tokenizer token = new Tokenizer("paren", ")");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '{') {
                Tokenizer token = new Tokenizer("chave", "{");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '}') {
                Tokenizer token = new Tokenizer("chave", "{");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '[') {
                Tokenizer token = new Tokenizer("colchete", "[");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == ']') {
                Tokenizer token = new Tokenizer("colchete", "]");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '_') {
                Tokenizer token = new Tokenizer("sublinhado", "_");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == ',') {
                Tokenizer token = new Tokenizer("virgula", ",");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == ';') {
                Tokenizer token = new Tokenizer("pontoVirgula", ";");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '=') {
                Tokenizer token = new Tokenizer("igual", "=");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '+') {
                Tokenizer token = new Tokenizer("soma", "+");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '-') {
                Tokenizer token = new Tokenizer("sub", "-");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '*') {
                Tokenizer token = new Tokenizer("mult", "*");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '/') {
                Tokenizer token = new Tokenizer("div", "/");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '%') {
                Tokenizer token = new Tokenizer("porc", "%");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '!') {
                Tokenizer token = new Tokenizer("exc", "!");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '>') {
                Tokenizer token = new Tokenizer("maior", ">");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '<') {
                Tokenizer token = new Tokenizer("menor", "<");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            String WHITESPACE = "\\s";
            if (WHITESPACE.matches(myChar + "")) {
                cont++;
                continue;
            }

            String NUMBERS = "[0-9]";
            if (String.valueOf(myChar).matches(NUMBERS)) {
                StringBuilder value = new StringBuilder();
                while (String.valueOf(myChar).matches(NUMBERS)) {
                    value.append(myChar);
                    myChar = txt.charAt(++cont);
                }
                tokens.add(new Tokenizer("number", value.toString()).toString());
                continue;
            }

            if (myChar == '"') {
                StringBuilder value = new StringBuilder();
                myChar = txt.charAt(++cont);
                while (myChar != '"') {
                    value.append(myChar);
                    myChar = txt.charAt(++cont);
                }
                tokens.add(new Tokenizer("string", value.toString()).toString());
                continue;
            }


            String LETTERS = "[a-zA-Z]";
            if (String.valueOf(myChar).matches(LETTERS)) {
                StringBuilder value = new StringBuilder();
                while (String.valueOf(myChar).matches(LETTERS)) {
                    value.append(myChar);
                    myChar = txt.charAt(++cont);
                }
                tokens.add(String.valueOf(new Tokenizer("name", value.toString()).toString()));
                continue;
            }


            throw new IllegalArgumentException("ERRO: caracter não reconhecido." + myChar);
        }
        return tokens;
    }
}


