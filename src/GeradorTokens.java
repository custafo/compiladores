package src;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class GeradorTokens {
    public static List<Token> listaTokens(String txt) {
        List<Token> tokens = new ArrayList<>();

        Pattern pattern = Pattern.compile(
                "\\s*" +  // ignora espaços em branco
                        "([a-zA-Z_][a-zA-Z_0-9]*|" + //identificadores
                        "\\d+\\.\\d+|\\d+|" + //números inteiros e decimais
                        "\"[^\"]*\"|" + //string entre aspa dupla
                        "//.*|" + //comentarios
                        "&&|\\|\\||!=|==|>=|<=|[<>+\\-*/%&|!(){}//,;=])" + //operadores lógicos
                        "\\s*"
        );

        Matcher matcher = pattern.matcher(txt);

        while (matcher.find()) {
            String valorToken = matcher.group(1);
            TipoToken tipo = getTokenType(valorToken);
            tokens.add(new Token(tipo, valorToken));
        }

        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(tokens.get(i));
        }
        return tokens;
    }

    private static TipoToken getTokenType(String tokenValue) {
        if (tokenValue.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            if(tokenValue.matches("int|float|char|boolean|void|if|else|for|while|scanf|println|main|return")){
                return TipoToken.PALAVRA_RESERVADA;
            }
            return TipoToken.ID;
        } else if (tokenValue.matches("\\d+")) {
            return TipoToken.NUM_INT;
        } else if (tokenValue.matches("\\d+\\.\\d+")) {
            return TipoToken.NUM_DEC;
        } else if (tokenValue.matches("\"[^\"]*\"")) {
            return TipoToken.CTE_TEXTO;
        } else if (tokenValue.matches("int|float|char|boolean|void|if|else|for|while|scanf|println|main|return")) {
            return TipoToken.PALAVRA_RESERVADA;
        } else if (tokenValue.matches("//.*")) {
            return TipoToken.COMENTARIO;
        } else {
            return TipoToken.OPERADOR;
        }
    }
}




