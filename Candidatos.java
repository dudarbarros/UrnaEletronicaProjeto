
public class Candidatos{
        private String nomeDosCandidatos;
        private String numeroDosCandidatos;
        private int votosDosCandidatos;

        public Candidatos(String nomeDosCandidatos , String numeroDosCandidatos){
            this.nomeDosCandidatos = nomeDosCandidatos;
            this.numeroDosCandidatos = numeroDosCandidatos;
            this.votosDosCandidatos = 0;
        }
        public String getNome(){
            return nomeDosCandidatos;
        }

        public String getNumero(){
            return numeroDosCandidatos;
        }
        public int getVotos(){
            return votosDosCandidatos;
        }
        public void setVotos(int votos){
            this.votosDosCandidatos = votos;
        }
        public void incrementarVotos() {
            votosDosCandidatos++;
        }
    }

