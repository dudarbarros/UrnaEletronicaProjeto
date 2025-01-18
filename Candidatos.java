
    public class Candidatos{
        private String nomeDosCandidatos;
        private int numeroDosCandidatos;
        private int votosDosCandidatos;

        public Candidatos(String nome , int numero){
            this.nomeDosCandidatos = nomeDosCandidatos;
            this.numeroDosCandidatos = numeroDosCandidatos;
            this.votosDosCandidatos = 0;
        }
        public String getNome(){
            return nomeDosCandidatos;
        }

        public int getNumero(){
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

