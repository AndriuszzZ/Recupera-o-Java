import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Scanner;

public class provaJava {

    static int power (int x, int y, int p){

        int res = 1;

        x = x % p;

        while (y > 0){

            if ((y & 1) == 1)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }

        return res;
    }    

    static boolean miillerTest(int d, int n) {

        int a = 2 + (int) (Math.random() % (n - 4));

        int x = power(a, d, n);

        if ( x == 1 || x== n - 1)
            return true;

        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;

            if (x == 1)
                return false;
            if(x == n - 1);
                return true;    
        }        
        return false;
    }

    static boolean isPrime(int n, int k){

        if(n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;
            
        int d = n - 1;
        
        while (d % 2 == 0)
            d /= 2;

        for (int i = 0; i < k; i++)
            if (!miillerTest (d, n))
                return false;
        
        return true;        
    }
    public static void main(String[] args) {
        
        
        System.out.println(" ----- Atividade de Recuperação ----- ");

        String arquivo = "C:/Users/andre.lima2/Desktop/prova/lista1.txt";

        try{
            int k  = 10;
            FileReader ler = new FileReader(arquivo);
            BufferedReader bufferedReader =  new BufferedReader(ler);
            int linhas = 0;
            while(bufferedReader.readLine()!= null){
                linhas++;
            }
            
            bufferedReader.close();

            int[] lista = new int[linhas];
            ler = new FileReader(arquivo);
            bufferedReader = new BufferedReader(ler);
            linhas = 0;
            String linha ="";
            while((linha = bufferedReader.readLine())!=null){
                lista[linhas] = Integer.parseInt(linha);
                linhas++;
            }

            bufferedReader.close();
            
            for (int i : lista) {
                if (isPrime(i, k)) {
                    System.out.println(i);
                }
            }

            int n = lista.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                     if (lista[j] > lista[j + 1]) {
                     int temp = lista[j];
                     lista[j] = lista[j + 1];
                     lista[j + 1] = temp; 

            }   

                ler = new FileReader ("C:/Users/andre.lima2/Desktop/prova/lista1.txt");
                
                bufferedReader = new BufferedReader(ler);  
                SortedSet<Integer> collection = new TreeSet<>();
                linha = "";
                while (linha != null) {
                    linha = bufferedReader.readLine();
                    if (linha != null) {
                        collection.add(Integer.parseInt(linha));
                    }
                }

                bufferedReader.close();
    
                System.out.println("Números Primos: ");
                System.out.println(collection);
    
                FileWriter arquivoEscrita = new FileWriter("C:/Users/andre.lima2/Desktop/prova/lista1.txt");
                BufferedWriter bufferEscrita = new BufferedWriter(arquivoEscrita);
                for (int i : lista) {
                    if(isPrime(i,k)){
                        System.out.println(i);
                    }
                }

                bufferEscrita.close();
    
                System.out.println("Números não primos: ");
                System.out.println(collection);
    
                FileWriter arquivoEscrito = new FileWriter ("C:/Users/andre.lima2/Desktop/prova/lista1.txt");
                BufferedWriter bufferEscrito = new BufferedWriter(arquivoEscrito);
                for (int i : lista){
                    if(!isPrime(i,k)){
                        System.out.println(i);
                    }
                }

                bufferEscrito.close();
    
                BufferedReader leitura = new BufferedReader(new FileReader("lista1.txt"));
                    String reta = "";
                    while (true){
                        if (reta != null){
                            System.out.println(reta);
                        }else
                            break;
                         reta = leitura.readLine();   
                    }

                    leitura.close();
    
                  BufferedWriter Escrita = new BufferedWriter(new FileWriter("Primos.txt"));
                  String retas = ""; 
                  Scanner in = new Scanner(System.in);
                  retas = in.nextLine();
                  Escrita.append(retas + "\n");
                  
                  Escrita.close();
    
                  BufferedWriter Escrita2 = new BufferedWriter(new FileWriter("naoPrimos.txt"));
                  String retas2 = ""; 
                  Scanner on = new Scanner(System.in);
                  retas = on.nextLine();
                  Escrita2.append(retas2 + "\n");
                  
                  Escrita2.close();
    
        } catch(IOException e){
            System.out.println("Ocorreu um erro, tente novamente!" + e.getMessage());
        }
    }
}