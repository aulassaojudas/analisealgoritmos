import java.util.LinkedList;
import java.util.Queue;

public class FilaImpressora {
    public static void main(String[] args) {
        Queue<Integer> filaImpressora = new LinkedList<>();
        // Adicionando solicitações de impressão à fila
        filaImpressora.add(34);
        filaImpressora.add(21);
        filaImpressora.add(99);
        filaImpressora.poll(); // Removendo o primeiro elemento da fila (34)
        filaImpressora.add(10);
        filaImpressora.add(45);
        filaImpressora.poll(); // Removendo o primeiro elemento da fila (21)
        filaImpressora.add(72);
        filaImpressora.poll(); // Removendo o primeiro elemento da fila (99)
        filaImpressora.add(27);
        filaImpressora.poll(); // Removendo o primeiro elemento da fila (10)
        filaImpressora.poll(); // Removendo o primeiro elemento da fila (45)
        filaImpressora.add(34);
        filaImpressora.poll(); // Removendo o primeiro elemento da fila (72)
        filaImpressora.add(21);
        filaImpressora.add(66);
        filaImpressora.poll(); // Removendo o primeiro elemento da fila (27)
        filaImpressora.add(99);
        filaImpressora.add(90);
        // Exibindo a fila da impressora após a sequência de comandos
        System.out.println("Fila da Impressora:");
        System.out.println(filaImpressora);
    }
}
