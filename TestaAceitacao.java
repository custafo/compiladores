public class TestaAceitacao {

    public static void analisadorLexico(String textoDoArquivo) {
        int state = 0, i = 0;
        boolean finalState = false;

        if (i < textoDoArquivo.length()) {

            if (Character.isLetter(textoDoArquivo.charAt(0)) || textoDoArquivo.charAt(0) == '_') { // Reconhece ID
                do {
                    if (state == 0) {
                        i++;
                        state = 1;
                    }
                    if (state == 1) {
                        if (Character.isLetter(textoDoArquivo.charAt(i)) || Character.isDigit(textoDoArquivo.charAt(i)) || textoDoArquivo.charAt(i) == '_') {
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
                } while (i < textoDoArquivo.length());
            }

            if (Character.isDigit(textoDoArquivo.charAt(i))) { // Reconhece números inteiros
                state = 1;
                i++;
                do {
                    if (state == 1) {
                        if (Character.isDigit(textoDoArquivo.charAt(i))) {
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
                } while (i < textoDoArquivo.length());
            }

            if (Character.isDigit(textoDoArquivo.charAt(i-1))) { // Reconhece números decimais
                state = 1;
                do {
                    switch (state) {
                        case (0):
                            i++;
                            state = 1;
                        case (1):
                            if (Character.isDigit(textoDoArquivo.charAt(i))) {
                                i++;
                                state = 1;
                            } else if (textoDoArquivo.charAt(i) == '.') {
                                i++;
                                state = 2;
                            } else {
                                System.out.println("ERRO");
                                break;
                            }
                        case (2):
                            if (Character.isDigit(textoDoArquivo.charAt(i))) {
                                state = 3;
                                finalState = true;
                            } else {
                                break;
                            }
                        case (3):
                            if (Character.isDigit(textoDoArquivo.charAt(i))) {
                                i++;
                                finalState = true;
                                state = 3;
                            } else {
                                finalState = false;
                                break;
                            }

                    }
                } while (i < textoDoArquivo.length());
            }
        }
        if (finalState == true) {
            System.out.println("A sequência foi aceita!");
        } else {
            System.out.println("ERRO: A SEQUÊNCIA NÃO FOI ACEITA!");
        }
    }
}
