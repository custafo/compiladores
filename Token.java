import java.util.ArrayList;
import java.util.List;

public class Token {
    String type;
    String value;


    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public static List<String> tokenizer(String txt) {
        int cont = 0;

        List<String> tokens = new ArrayList<>();

        while (cont < txt.length()) {

            char myChar = txt.charAt(cont);

            if (myChar == '(') {
                Token token = new Token("paren", "(");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == ')') {
                Token token = new Token("paren", ")");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if(myChar == '/' && txt.charAt(cont + 1) == '/') {
                do{
                    cont++;
                    myChar = txt.charAt(cont);
                }while (myChar != '¬');
                continue;
            }

            if (myChar == '{') {
                Token token = new Token("colchete", "{");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '{') {
                Token token = new Token("colchete", "{");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '}') {
                Token token = new Token("colchete", "}");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '[') {
                Token token = new Token("chave", "[");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == ']') {
                Token token = new Token("chave", "]");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '_') {
                Token token = new Token("sublinhado", "_");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == ',') {
                Token token = new Token("virgula", ",");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == ';') {
                Token token = new Token("pontoVirgula", ";");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '=') {
                Token token = new Token("igual", "=");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '+') {
                Token token = new Token("soma", "+");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '-') {
                Token token = new Token("sub", "-");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '*') {
                Token token = new Token("mult", "*");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '/') {
                Token token = new Token("div", "/");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '%') {
                Token token = new Token("porc", "%");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '!') {
                Token token = new Token("exc", "!");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '>') {
                Token token = new Token("maior", ">");
                tokens.add(String.valueOf(myChar));
                cont++;
                continue;
            }

            if (myChar == '<') {
                Token token = new Token("menor", "<");
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
                tokens.add(new Token("number", value.toString()).toString());
                continue;
            }

            if (myChar == '"') {
                StringBuilder value = new StringBuilder();
                myChar = txt.charAt(++cont);
                while (myChar != '"') {
                    value.append(myChar);
                    myChar = txt.charAt(++cont);
                }
                tokens.add(new Token("string", value.toString()).toString());
                continue;
            }


            String LETTERS = "[a-zA-Z]";
            if (String.valueOf(myChar).matches(LETTERS)) {
                StringBuilder value = new StringBuilder();
                while (String.valueOf(myChar).matches(LETTERS)) {
                    value.append(myChar);
                    myChar = txt.charAt(++cont);
                }
                tokens.add(String.valueOf(new Token("name", value.toString()).toString()));
                continue;
            }


            throw new IllegalArgumentException("ERRO: caracter não reconhecido." + myChar);
        }
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(tokens.get(i));
        }
        return tokens;
    }
}


