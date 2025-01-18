import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UrnaEletronica{
    private int votosNulos;
    private List<Candidatos> candidatos;
    

    public UrnaEletronica(){

        List<Candidatos> lista = new ArrayList<>();

        Candidatos AdaLovelace = new Candidatos("Ada Lovelace" , 01);
        Candidatos AlanTuring = new Candidatos("Alan Turing", 02);
        Candidatos MarieCurie = new Candidatos ("Marie Curie", 03);
        Candidatos AlbertEinstein = new Candidatos ("Albert Einstein", 04);
        Candidatos LudwidVanBeethoven = new Candidatos ("Ludwid Van Beethoven", 05);

        lista.add(AdaLovelace);
        lista.add(AlanTuring);
        lista.add(MarieCurie);
        lista.add(AlbertEinstein);
        lista.add(LudwidVanBeethoven);

    }

    public void receberVoto(int numero){
        boolean votoValido = false;
        for(Candidatos candidato : candidatos) {
            if (candidato.getNumero() == numero){
                candidato.incrementarVotos();
                votoValido = true;
                break;
            }
        }

        if(!votoValido){
            votosNulos++;
            System.out.println("Voto inválido. Está sendo contato como voto nulo!");
        }
    }
    public void apurarResultados(){
        
    }
    public void exibirResultados(){
            
    }
    
}
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        UrnaEletronica urna = new UrnaEletronica();

        System.out.println("Bem-vindo à Urna Eletrônica!");
        System.out.println("Candidatos:");
        System.out.println("01 - Ada Lovelace");
        System.out.println("02 - Alan Turing");
        System.out.println("03 - Marie Curie");
        System.out.println("04 - Albert Einstein");
        System.out.println("05 - Ludwig van Beethoven");

        int votosRecebidos = 0;
        while (votosRecebidos < 10) {
            System.out.print("Digite o número do seu candidato: ");
            try {
                int numero = Integer.parseInt(scanner.nextLine());
                urna.receberVoto(numero);
                votosRecebidos++;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
            }
        }

        urna.apurarResultados();
    }

