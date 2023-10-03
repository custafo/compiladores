package src;

import java.io.*;

//DUPLA: Gustavo Pereira Oliveira Lima e Maria Eduarda Santana da Silva Barros

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String caminhoArquivo = "C:/Users/medua/IdeaProjects/analisadorLexico_compiladores/out/arqTx.txt"; // Caminho para o arquivo de texto

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            StringBuilder conteudo = new StringBuilder();

            while ((linha = leitor.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }

            String textoDoArquivo = conteudo.toString();

            AnalisadorLexico.analisador(textoDoArquivo); // reconhece caracteres
            GeradorTokens.listaTokens(textoDoArquivo); // gera lista de tokens
            System.out.println("\nA SEQUÊNCIA FOI ACEITA!\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

