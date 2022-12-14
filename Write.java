import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Write extends Read {

    String arqCSV;

    public Write(String arq, String arqCSV) {
        super(arq);
        this.arqCSV = arqCSV;
    }

    public boolean Escrever(ArrayList<String> Texto) {
        try {
            System.out.println("Arquivo '" + Caminho + "' lido com sucesso!");
            FileWriter arq = new FileWriter(arqCSV);
            PrintWriter gravarArq = new PrintWriter(arq);
            for (int i = 0; i < Texto.size(); i++)
                gravarArq.println(Texto.get(i));
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
