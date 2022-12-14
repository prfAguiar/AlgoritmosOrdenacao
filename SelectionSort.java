import java.util.ArrayList;

public class SelectionSort {

    int contador = 0, posicaoAtualDoMenor;
    String aux;

    public void Selectionsort(ArrayList<String> array) {
        for(int i = 0; i < array.size(); i++){
            posicaoAtualDoMenor = i;
            for(int j = i + 1; j < array.size(); j++){
                if (array.get(j).compareToIgnoreCase(array.get(posicaoAtualDoMenor)) < 0){
                    posicaoAtualDoMenor = j;
                }
                else if(array.get(j).compareToIgnoreCase(array.get(posicaoAtualDoMenor)) == 0){
                    contador++;     
                }
            }
            if(array.get(posicaoAtualDoMenor).compareToIgnoreCase(array.get(i)) != 0){
                aux = array.get(i);
                array.set(i, array.get(posicaoAtualDoMenor));
                array.set(posicaoAtualDoMenor, aux);
                contador++;
            }
        }
    }

    public int retornaCont(){
        return contador;
    }
    
}
