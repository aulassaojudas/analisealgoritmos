import java.util.ArrayList;
import java.util.List;

public class ListaSimplesArrayList {
    public static void main(String[] args){ 
        List<Integer> numeros = new ArrayList<>(); 
        numeros.add(3);
        numeros.add(2);
        numeros.add(1);
        System.out.println("Lista " + numeros);
        numeros.remove(Integer.valueOf(2)); 
        System.out.println("Lista depois de excluir " + numeros);
        boolean contem = numeros.contains(3);
        System.out.println("a lista contem o numero tres " + contem );
        System.out.println("Travessia ");
        for( int num : numeros ){ 
            System.out.println("numero " + num );
        }
    }

}
