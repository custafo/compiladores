public class Main {
    public static void main(String[] args) {
        String txt = "Olá este é um teste de números inteiros como 2 e decimais como 2.35";
        removeBrancos(txt);
    }

    public static void removeBrancos(String txt) {
        txt = txt.replaceAll("\\s", ""); // retira os espaços em branco
        System.out.println(txt);
        Token(txt);
    }

    public static void Token(String txt) {
        int state = 0, i = 0;
        boolean finalState = false;

        if (Character.isLetter(txt.charAt(0)) || txt.charAt(0) == '_') { // Reconhece ID
            do {
                if (state == 0) {
                    i++;
                    state = 1;
                }
                if (state == 1) {
                    if (Character.isLetter(txt.charAt(i)) || Character.isDigit(txt.charAt(i)) || txt.charAt(i) == '_') {
                        i++;
                        state = 1;
                        finalState = true;
                    } else {
                        state = 2;
                    }
                } else if (state == 2) {
                    finalState = false;
                    break;
                }
            } while (i < txt.length());
        }

        if (i < txt.length()) {
            if (Character.isDigit(txt.charAt(i))) { // Reconhece números inteiros
                state = 1;
                i++;
                do {
                    if (state == 1) {
                        if (Character.isDigit(txt.charAt(i))) {
                            i++;
                            state = 1;
                            finalState = true;
                        } else {
                            state = 2;
                        }
                    } else if (state == 2) {
                        finalState = false;
                        break;
                    }
                } while (i < txt.length());
            }
        }

        if (i < txt.length()) {
            i--;
            state = 0;
            if (Character.isDigit(txt.charAt(i))) { // Reconhece números decimais
                do {
                    switch (state) {
                        case (0):
                            i++;
                            state = 1;
                        case (1):
                            if (Character.isDigit(txt.charAt(i))) {
                                i++;
                                state = 1;
                            } else if (txt.charAt(i) == '.') {
                                i++;
                                state = 2;
                            } else {
                                System.out.println("ERRO");
                                break;
                            }
                        case (2):
                            if (Character.isDigit(txt.charAt(i))) {
                                state = 3;
                                finalState = true;
                            } else {
                                break;
                            }
                        case (3):
                            if (Character.isDigit(txt.charAt(i))) {
                                i++;
                                finalState = true;
                                state = 3;
                            } else {
                                finalState = false;
                                break;
                            }

                    }
                } while (i < txt.length());
            }
        }

        if (txt.charAt(0) == '"') { // Reconhece constantes de texto (strings)
            do {
                if (state == 0) {
                    i++;
                    state = 1;
                } else if (state == 1) {
                    if (txt.charAt(i) == '\\') { // Verifica se há um caractere de escape
                        i++;
                        state = 2;
                    } else if (txt.charAt(i) == '"') { // Verifica se é o fim da string
                        i++;
                        state = 3;
                        finalState = true;
                    } else {
                        i++;
                    }
                } else if (state == 2) {
                    // Lida com escapes específicos, como \n, \t, \", etc.
                    if (isEscapeCharacter(txt.charAt(i))) {
                        i++;
                        state = 1;
                    } else {
                        System.out.println("ERRO: Sequência de escape inválida!");
                        break;
                    }
                }
            } while (i < txt.length());
        }

        if (finalState == true) {
            System.out.println("A sequência foi aceita!");
        } else {
            System.out.println("ERRO: A SEQUÊNCIA NÃO FOI ACEITA!");
        }
    }

    public static boolean isEscapeCharacter(char c) {
        switch (c) {
            case 'n': // Quebra de linha
            case 't': // Tabulação
            case 'r': // Retorno de carro
            case 'b': // Retrocesso (backspace)
            case 'f': // Avanço de página
            case '\\': // Barra invertida
            case '\'': // Aspa simples
            case '\"': // Aspa dupla
                return true;
            default:
                return false;
        }
    }
}

