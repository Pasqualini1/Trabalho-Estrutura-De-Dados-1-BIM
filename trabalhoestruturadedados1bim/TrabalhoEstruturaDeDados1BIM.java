package br.pasqualini.trabalhoestruturadedados1bim;

import javax.swing.JOptionPane;

public class TrabalhoEstruturaDeDados1BIM {

    public static void main(String[] args) {
       String[] opcoes = {"1. Ordenação por inserção", 
           "2. Ordenação por seleção", 
           "3. Ordenação bolha"};
       
        String escolha = (String) JOptionPane.showInputDialog(null, "Escolha o método de ordenação:", 
                "Método de Ordenação",
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        int opcao = Integer.parseInt(escolha.substring(0, 1));

        int tamanho = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o tamanho do vetor:"));
        int[] vetorOriginal = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetorOriginal[i] = Integer.parseInt(JOptionPane.showInputDialog(
                    "Informe o elemento " + (i + 1) + ":"));
        }

        switch (opcao) {
            case 1:
                int[] vetorInsercao = vetorOriginal.clone();
                long tempoInicialInsercao = System.currentTimeMillis();
                Ordenacao.ordenacaoInsercao(vetorInsercao);
                long tempoExecucaoInsercao = System.currentTimeMillis() - tempoInicialInsercao;
                Output.exibirResultado(vetorOriginal, vetorInsercao, tempoExecucaoInsercao);
                break;
                
            case 2:
                int[] vetorSelecao = vetorOriginal.clone();
                long tempoInicialSelecao = System.currentTimeMillis();
                Ordenacao.ordenacaoSelecao(vetorSelecao);
                long tempoExecucaoSelecao = System.currentTimeMillis() - tempoInicialSelecao;
                Output.exibirResultado(vetorOriginal, vetorSelecao, tempoExecucaoSelecao);
                break;
                
            case 3:
                int[] vetorBolha = vetorOriginal.clone();
                long tempoInicialBolha = System.currentTimeMillis();
                Ordenacao.ordenacaoBolha(vetorBolha);
                long tempoExecucaoBolha = System.currentTimeMillis() - tempoInicialBolha;
                Output.exibirResultado(vetorOriginal, vetorBolha, tempoExecucaoBolha);
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
    }
}

class Ordenacao {
    public static void ordenacaoInsercao(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    }

    public static void ordenacaoSelecao(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            int temp = vetor[indiceMenor];
            vetor[indiceMenor] = vetor[i];
            vetor[i] = temp;
        }
    }
    
    public static void ordenacaoBolha(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }
}

class Output {
    public static void exibirResultado(int[] vetorOriginal, int[] vetorOrdenado, long tempoExecucao) {
        StringBuilder original = new StringBuilder("Vetor original:\n");
        StringBuilder ordenado = new StringBuilder("Vetor ordenado:\n");

        for (int i = 0; i < vetorOriginal.length; i++) {
            original.append(vetorOriginal[i]).append(" ");
            ordenado.append(vetorOrdenado[i]).append(" ");
        }

        JOptionPane.showMessageDialog(null, original.toString() + "\n" + 
                ordenado.toString() + "\nTempo de execução: "
                + tempoExecucao + " milissegundos");
    }   
}
