import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UrnaEletronica{
    private int votosNulos;
    private List<Candidatos> lista;
    

    public void listaCandidatos(){
 
        lista = new ArrayList<>();

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
        for(Candidatos candidato : lista) {
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
        int totalVotosValidos = lista.stream().mapToInt(Candidatos::getVotos).sum();
  
      int maiorVotos = 0;
      List<Candidatos> vencedores = new ArrayList<>();
  
      for (Candidatos candidato : lista) {
          if (candidato.getVotos() > maiorVotos) {
              maiorVotos = candidato.getVotos();
              vencedores.clear(); 
              vencedores.add(candidato);
          } else if (candidato.getVotos() == maiorVotos) {
              vencedores.add(candidato); 
          }
      }
  
      this.totalVotosValidos = totalVotosValidos;
      this.maiorVotos = maiorVotos;
      this.vencedores = vencedores;
    }
    
    public void exibirResultados(){
        f (totalVotosValidos == 0) {
            System.out.println("Nenhum voto foi registrado.");
            return;
        }
    
        System.out.println("\nResultado da Votação:");
        for (Candidatos candidato : lista) {
            double percentual = totalVotosValidos > 0 
                ? (candidato.getVotos() * 100.0 / totalVotosValidos) 
                : 0.0; 
            System.out.printf("%s: %d votos (%.2f%%)%n", 
                candidato.getnomeCandidato(), candidato.getVotos(), percentual);
    }
    
    System.out.println("Votos Nulos: " + votosNulos);

    if (vencedores.size() == 1) {
        System.out.println("Vencedor: " + vencedores.get(0).getnomeCandidato());
    } else if (vencedores.size() > 1) {
        System.out.print("Houve empate entre: ");
        for (Candidatos vencedor : vencedores) {
            System.out.print(vencedor.getnomeCandidato() + " ");
        }
        System.out.println();
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

        scanner.close();
    }
    
}
