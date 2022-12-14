

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read {

    String Caminho;
    public Read(String arq) {
        this.Caminho = arq;
    }

    public ArrayList<String> linhas;

    public ArrayList<String> Ler() {
        ArrayList<String> linhas = new ArrayList<String>();
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                do {
                    linhas.add(linha);
                    linha = lerArq.readLine();
                } while (linha != null);

                arq.close();
                linhas.remove(0);
                return linhas;
            } catch (IOException ex) {
                System.err.println("Erro: Não foi possível ler o arquivo!");
                return null;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Erro: Arquivo não encontrado!");
            return null;
        }
    }

    public ArrayList<String> getLinhas() {
        return linhas;
    }
}
