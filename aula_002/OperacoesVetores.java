
public class OperacoesVetores {
    public static void main(String[] banana ) {
        // Exemplo de vetores 
        int[] vetorA = {1, 2, 3};
        int[] vetorB = {4, 5, 6}; 

        // adição 
        int[] soma = new int[vetorA.length];
        for( int i = 0; i < vetorA.length; i++){
            soma[i] = vetorA[i] + vetorB[i]; 
        }
        total(soma); 

        int[] subtracao = new int[vetorA.length]; 
        for( int i = 0; i < vetorA.length; i++){
            subtracao[i] = vetorA[i] - vetorB[i]; 
        }
        total(subtracao); 
    }
    public static void total( int[] somar){ 
        for( int i= 0; i < somar.length; i ++){
            System.out.println("[" + i + "]=" + somar[i]); 
        }
    }
}
