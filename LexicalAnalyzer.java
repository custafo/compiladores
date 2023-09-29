import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer {
    public static void main(String[] args) throws FileNotFoundException {
        String caminhoArquivo = "C:/Users/medua/IdeaProjects/analisadorLexico/out/arqTx.txt"; // Caminho para o arquivo de texto

        OutputStream os = new FileOutputStream("saida.txt");

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            StringBuilder conteudo = new StringBuilder();

            while ((linha = leitor.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }

            leitor.close(); // Fecha o leitor quando terminar de ler

            String textoDoArquivo = conteudo.toString();
            textoDoArquivo = textoDoArquivo.replaceAll("\\s", ""); //apaga espaços em branco
//            Tokenizer.analyzer(textoDoArquivo); classe infuncional
            TesteAceitacao.analisadorLexico(textoDoArquivo);
            tokenList(textoDoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Token> tokenList(String input) {
        List<Token> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile(
                "\\s*" +  // Ignora espaços em branco
                        "(\\d+\\.\\d+|\\d+|\"[^\"]*\"|//.*|&&|\\|\\||!=|==|>=|<=|[<>+\\-*/%&|!(){}[//],;=])" +
                        "\\s*"
        );
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String tokenValue = matcher.group(1);
            TokenType type = getTokenType(tokenValue);
            tokens.add(new Token(type, tokenValue));
        }

        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(tokens.get(i));
        }
        return tokens;
    }

    private static TokenType getTokenType(String tokenValue) {
        if (tokenValue.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return TokenType.ID;
        } else if (tokenValue.matches("\\d+")) {
            return TokenType.NUM_INT;
        } else if (tokenValue.matches("\\d+\\.\\d+")) {
            return TokenType.NUM_DEC;
        } else if (tokenValue.matches("\"[^\"]*\"")) {
            return TokenType.TEXTO;
        } else if (tokenValue.matches("int|float|char|boolean|void|if|else|for|while|scanf|println|main|return")) {
            return TokenType.RESERVADA;
        } else if (tokenValue.matches("//.*")) {
            return TokenType.COMENTARIO;
        } else {
                return TokenType.OPERADOR_SIMBOLO;
            }
        }
    }




