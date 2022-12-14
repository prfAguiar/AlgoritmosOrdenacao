import java.util.Scanner;
import java.io.IOException;

public class index {

    public static void main(String[] args) throws IOException, InterruptedException {
        int escolha = 0, segundaEscolha = 0;  //variáveis para escolha do usuário
        String arq = ""; //variável para armazenar o nome do arquivo
        String fileCSV = ""; //variável para armazenar o nome do arquivo CSV
        Scanner ler = new Scanner(System.in); //objeto para ler o teclado
        
        do{
            do{
                limpaConsole();
                System.out.printf("|------------------------------------------------------------------------|\n"); //Menu principal que terá os métodos de ordenação
                System.out.printf("|                                                                        |\n");
                System.out.printf("|        Escolha o método de ordenação que deseja utilizar               |\n");
                System.out.printf("|        1) InsertionSort                                                |\n");
                System.out.printf("|        2) QuickSort                                                    |\n");
                System.out.printf("|        3) SelectionSort                                                |\n");
                System.out.printf("|        4) Sair                                                         |\n");
                System.out.printf("|                                                                        |\n"); 
                System.out.printf("|------------------------------------------------------------------------|\n");

                System.out.println("Escolha uma opção: "); 
                escolha = ler.nextInt();
            } while(escolha < 1 || escolha > 4); //Caso o usuário digita algum número que não é correspondente ao menu

            if(escolha == 4){ //Caso o usuário escolha sair
                System.out.println("Saindo..."); //Saida do programa
                Thread.sleep(1000); 
                System.exit(0);
            }

            do{
                limpaConsole();
                System.out.printf("|------------------------------------------------------------------------|\n"); //Menu que o usuário escolherá o arquivo                                                                                                       que será ordenado
                System.out.printf("|                                                                        |\n"); //que será ordenado 
                System.out.printf("|        Escolha qual arquivo que deseja ordenar:                        |\n"); 
                System.out.printf("|        1) 100 entradas aleatórias                                      |\n");
                System.out.printf("|        2) 100 entradas crescentes                                      |\n");
                System.out.printf("|        3) 100 entradas decrescentes                                    |\n");
                System.out.printf("|        4) 1000 entradas aleatórias                                     |\n");
                System.out.printf("|        5) 1000 entradas crescentes                                     |\n");
                System.out.printf("|        6) 1000 entradas descrescentes                                  |\n"); 
                System.out.printf("|        7) 10000 entradas aleatórias                                    |\n"); 
                System.out.printf("|        8) 10000 entradas crescentes                                    |\n"); 
                System.out.printf("|        9) 10000 entradas decrescentes                                  |\n");
                System.out.printf("|                                                                        |\n");  
                System.out.printf("|------------------------------------------------------------------------|\n");
            
                System.out.println("Escolha uma opção: "); 
                segundaEscolha = ler.nextInt();
            } while(segundaEscolha < 1 || segundaEscolha > 9); //Caso o usuário digita algum número que não é correspondente ao menu

            switch(escolha){ //Switch para escolha do método de ordenação
                    case 1: 
                        String auxiliar; //variável que terá parte do nome do arquivo que será lido e consequentemente escrito com o arquivo ordenado
                        limpaConsole();
                        System.out.println("Opção escolhida: InsertionSort");
                        auxiliar = verificaArquivoEscolhido(segundaEscolha); //Método que verifica qual arquivo será lido e retorna o nome do arquivo
                        arq = "entrada-" + auxiliar + ".txt"; //Nome do arquivo que será lido
                        fileCSV = "InsertionSort-saida-" + auxiliar + ".csv"; //Nome do arquivo que será escrito
                        trataArquivoInsertionSort(arq, fileCSV);
                                break;
                        case 2:
                        limpaConsole(); 
                        System.out.println("Opção escolhida: QuickSort");
                        auxiliar = verificaArquivoEscolhido(segundaEscolha);  //Método que verifica qual arquivo será lido e retorna o nome do arquivo
                        arq = "entrada-" + auxiliar + ".txt"; //Nome do arquivo que será lido
                        fileCSV = "QuickSort-saida-" + auxiliar + ".csv"; //Nome do arquivo que será escrito
                        trataArquivoQuickSort(arq, fileCSV); 
                                break;
                        case 3:
                        limpaConsole();
                        System.out.println("Opção escolhida: SelectionSort");
                        auxiliar = verificaArquivoEscolhido(segundaEscolha);  //Método que verifica qual arquivo será lido e retorna o nome do arquivo
                        arq = "entrada-" + auxiliar + ".txt"; //Nome do arquivo que será lido
                        fileCSV = "SelectionSort-saida-" + auxiliar + ".csv"; //Nome do arquivo que será escrito
                        trataArquivoSelectionSort(arq, fileCSV);
                            break;
                        default:
                            break;
                            
                }

                System.out.println("Deseja realizar outra operação? (1 - Sim / 2 - Não)"); //Caso o usuário deseje realizar outra operação
                escolha = ler.nextInt();
                limpaConsole();
        }while(escolha == 1);
            ler.close(); //Fecha o Scanner
    }

    public static void limpaConsole() throws IOException, InterruptedException { //Método para limpar o console
        if(System.getProperty("os.name").contains("Windows")){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }else{
            Runtime.getRuntime().exec("clear");
        }
    }

    private static void trataArquivoInsertionSort(String arq, String arqCSV) { //Método para tratar o arquivo com o método InsertionSort(Ordenar, ler e escrever no arquivo)
        int contadorMovimentos = 0;
        String ultimaLinha = "";
        InsertionSort insertionSort = new InsertionSort();
        Read read = new Read(arq);
        read.linhas = read.Ler();
        if (read.linhas.isEmpty()){
            System.out.println("Erro ao ler do arquivo!");
        }
        insertionSort.Insertionsort(read.linhas);
        contadorMovimentos = insertionSort.retornaCont();
        ultimaLinha = "Movimentos: " + contadorMovimentos;
        read.linhas.add(ultimaLinha);
        Write write = new Write(arq, arqCSV);
        if (write.Escrever(read.linhas)){
            System.out.println("Arquivo '" + arqCSV + "' salvo com sucesso!");
        }else{
            System.out.println("Erro ao salvar o arquivo! '" + arqCSV + "'");
        
        }
    }

    private static void trataArquivoQuickSort(String arq, String arqCSV){ //Método para tratar o arquivo com o método QuickSort(Ordenar, ler e escrever no arquivo)
        int contadorMovimentos = 0;
        String ultimaLinha = "";
        Quicksort quickSort = new Quicksort();
        Read read = new Read(arq);
        read.linhas = read.Ler();
        if (read.linhas.isEmpty()){
            System.out.println("Erro ao ler do arquivo!");
        }
        quickSort.quickSort(read.linhas, 0, read.linhas.size() - 1);
        contadorMovimentos = quickSort.quantidadeMovimentos();
        ultimaLinha = "Movimentos: " + contadorMovimentos;
        read.linhas.add(ultimaLinha);
        Write write = new Write(arq, arqCSV);
        if (write.Escrever(read.linhas)){
            System.out.println("Arquivo '" + arqCSV + "' salvo com sucesso!");
        }else{
            System.out.println("Erro ao salvar o arquivo! '" + arqCSV + "'");
        
        }
    }

    private static void trataArquivoSelectionSort(String arq, String arqCSV){ //Método para tratar o arquivo com o método SelectionSort(Ordenar, ler e escrever no arquivo)
        System.out.println(arq);
        int contadorMovimentos = 0;
        String ultimaLinha = "";
        SelectionSort selectionSort = new SelectionSort();
        Read read = new Read(arq);
        read.linhas = read.Ler();
        if (read.linhas.isEmpty()){
            System.out.println("Erro ao ler do arquivo!");
        }
        selectionSort.Selectionsort(read.linhas);
        contadorMovimentos = selectionSort.retornaCont();
        ultimaLinha = "Movimentos: " + contadorMovimentos;
        read.linhas.add(ultimaLinha);
        Write write = new Write(arq, arqCSV);
        if (write.Escrever(read.linhas)){
            System.out.println("Arquivo '" + arqCSV + "' salvo com sucesso!");
        }else{
            System.out.println("Erro ao salvar o arquivo! '" + arqCSV + "'");
        }
    }

    private static String verificaArquivoEscolhido(int segundaEscolha) { //Método para verificar qual arquivo o usuário escolheu
        String auxiliar = ""; 
        if(segundaEscolha == 1){
            System.out.println("Arquivo escolhido: 100 entradas aleatórias");
            auxiliar = "100-ale";
        }
        else if(segundaEscolha == 2){
            System.out.println("Arquivo escolhido: 100 entradas crescentes");
            auxiliar = "100-cre";
        }
        else if(segundaEscolha == 3){
            System.out.println("Arquivo escolhido: 100 entradas decrescentes");
            auxiliar = "100-dec";
        }
        else if(segundaEscolha == 4){
            System.out.println("Arquivo escolhido: 1000 entradas aleatórias");
            auxiliar = "1000-ale";
        }
        else if(segundaEscolha == 5){
            System.out.println("Arquivo escolhido: 1000 entradas crescentes");
            auxiliar = "1000-cre";
        }
        else if(segundaEscolha == 6){
            System.out.println("Arquivo escolhido: 1000 entradas decrescentes");
            auxiliar = "1000-dec";
        }
        else if(segundaEscolha == 7){
            System.out.println("Arquivo escolhido: 10000 entradas aleatórias");
            auxiliar = "10000-ale";
        }
        else if(segundaEscolha == 8){
            System.out.println("Arquivo escolhido: 10000 entradas crescentes");
            auxiliar = "10000-cre";
        
        }else{
            System.out.println("Arquivo escolhido: 10000 entradas decrescentes");
            auxiliar = "10000-dec";
        }
        return auxiliar;  //Retorna o nome do arquivo
    }
}

