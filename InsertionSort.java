import java.util.ArrayList;

public class InsertionSort{

    int cont = 0;
    public void Insertionsort(ArrayList<String> a) {  
        int n = a.size();
        for (int i = 1; i < n; i++) {
            String nome = a.get(i);
            int j = i - 1;
            while (j >= 0 && a.get(j).compareToIgnoreCase(nome) > 0) {
                a.set(j + 1, a.get(j));
                cont++;
                j--;
            }
            a.set(j+1, nome);
            if(j != i-1){
                cont++;
            }
        }
    }

    public int retornaCont(){
        return cont;
    }
}




