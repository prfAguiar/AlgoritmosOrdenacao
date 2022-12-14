import java.util.ArrayList;

public class Quicksort {

    private int contadorMovimentos = 0;

    public void quickSort(ArrayList<String> nomes, int esquerda, int direita) {
        if (esquerda < direita) {
            int pivot = separar(nomes, esquerda, direita);
            quickSort(nomes, esquerda, pivot);
            quickSort(nomes, pivot + 1, direita);
        }

    }

    private int separar(ArrayList<String> nomes, int esquerda, int direita) {
        int auxEsquerda = esquerda - 1;
        int meioVetor = (esquerda + direita) / 2;
        String pivot = nomes.get(meioVetor);
        int auxDireita = direita + 1;
        while (true) {
            do {
                auxEsquerda++;
            } while (nomes.get(auxEsquerda).compareToIgnoreCase(pivot) < 0);
            do {
                auxDireita--;
            } while (nomes.get(auxDireita).compareToIgnoreCase(pivot) > 0);
            if (auxEsquerda >= auxDireita) {
                return auxDireita;
            }
            trocar(nomes, auxEsquerda, auxDireita);
        }
    }

    private void trocar(ArrayList<String> nomes, int auxEsquerda, int auxDireita) {
        contadorMovimentos++;
        String aux = nomes.get(auxEsquerda);
        nomes.set(auxEsquerda, nomes.get(auxDireita));
        nomes.set(auxDireita, aux);
    }

    public int quantidadeMovimentos() {
        return contadorMovimentos;
    }
}
