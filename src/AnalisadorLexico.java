package src;
public class AnalisadorLexico {
    String tipo;
    String valor;


    public AnalisadorLexico(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public static void analisador(String txt) {
        txt = txt.replaceAll("\\s", "");

        int cont = 0;

        while (cont < txt.length()) {

            char caracter = txt.charAt(cont);

            if (caracter == '(') {
                cont++;
                continue;
            }

            if (caracter == ')') {
                cont++;
                continue;
            }

            if (caracter == '{') {
                cont++;
                continue;
            }

            if (caracter == '}') {
                cont++;
                continue;
            }

            if (caracter == '[') {
                cont++;
                continue;
            }

            if (caracter == ']') {
                cont++;
                continue;
            }

            if (caracter == '_') {
                cont++;
                continue;
            }

            if (caracter == ',') {
                cont++;
                continue;
            }

            if (caracter == ';') {
                cont++;
                continue;
            }

            if (caracter == '.') {
                cont++;
                continue;
            }

            if (caracter == '=') {
                cont++;
                continue;
            }

            if (caracter == '+') {
                cont++;
                continue;
            }

            if (caracter == '-') {
                cont++;
                continue;
            }

            if (caracter == '*') {
                cont++;
                continue;
            }

            if (caracter == '/') {
                cont++;
                continue;
            }

            if (caracter == '%') {
                cont++;
                continue;
            }

            if (caracter == '&') {
                cont++;
                continue;
            }

            if (caracter == '|') {
                cont++;
                continue;
            }

            if (caracter == '!') {
                cont++;
                continue;
            }

            if (caracter == '>') {
                cont++;
                continue;
            }

            if (caracter == '<') {
                cont++;
                continue;
            }

            if (caracter == '"') {
                cont++;
                continue;
            }

//            if (caracter == '\'') {
//                cont++;
//                continue;
//            }

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
                continue;
            }


            String LETTERS = "[\\p{L}]";
            if (String.valueOf(caracter).matches(LETTERS)) {
                StringBuilder value = new StringBuilder();
                while (String.valueOf(caracter).matches(LETTERS)) {
                    value.append(caracter);
                    caracter = txt.charAt(++cont);
                }
                continue;
            }

            throw new IllegalArgumentException("ERRO! caracter não reconhecido: " + caracter);
        }
    }
}


