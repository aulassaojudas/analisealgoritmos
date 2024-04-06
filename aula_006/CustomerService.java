/*
 Este código é um exemplo simples de um sistema de atendimento ao cliente com duas filas distintas: 
 uma para clientes prioritários e outra para clientes normais. 
 
### Classe `Customer`
A classe `Customer` representa um cliente com três atributos:
- `name`      : O nome do cliente.
- `id`        : Um identificador único para o cliente.
- `isPriority`: Um booleano que indica se o cliente tem prioridade no atendimento.

#### Métodos
- Construtor    : Define os valores dos três atributos.
- `isPriority()`: Retorna o valor do atributo `isPriority`.
- `toString()`  : Sobrescreve o método padrão `toString` para fornecer uma representação em string do objeto `Customer`.

### Classe `CustomerService`
Esta classe gerencia duas filas de clientes utilizando `LinkedList`, que implementa a interface `Queue`.

#### Atributos
- `priorityQueue`: Fila para clientes prioritários.
- `normalQueue`  : Fila para clientes não prioritários.

#### Métodos
- Construtor                      : Inicializa as duas filas.
- `addCustomer(Customer customer)`: Adiciona um cliente à fila correspondente baseado em seu status de prioridade.
- `serveCustomer()`               : Atende um cliente. Primeiro verifica se há clientes na `priorityQueue` e atende o primeiro se disponível. 
- `displayQueues()`               : Exibe todos os clientes em ambas as filas.
 */

import java.util.LinkedList;
import java.util.Queue;

class Customer {
    private String name;
    private int id;
    private boolean isPriority;

    public Customer(String name, int id, boolean isPriority) {
        this.name = name;
        this.id = id;
        this.isPriority = isPriority;
    }

    public boolean isPriority() {
        return isPriority;
    }

    @Override
    public String toString() {
        return "Cliente[ID: " + id + ", Nome: " + name + ", Prioridade: " + (isPriority ? "Sim" : "Não") + "]";
    }
}

public class CustomerService {
    private Queue<Customer> priorityQueue;
    private Queue<Customer> normalQueue;

    public CustomerService() {
        priorityQueue = new LinkedList<>();
        normalQueue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        if (customer.isPriority()) {
            priorityQueue.add(customer);
            System.out.println("Cliente prioritário adicionado à fila: " + customer);
        } else {
            normalQueue.add(customer);
            System.out.println("Cliente normal adicionado à fila: " + customer);
        }
    }

    public void serveCustomer() {
        if (!priorityQueue.isEmpty()) {
            Customer customer = priorityQueue.poll();
            System.out.println("Atendendo cliente prioritário: " + customer);
        } else if (!normalQueue.isEmpty()) {
            Customer customer = normalQueue.poll();
            System.out.println("Atendendo cliente normal: " + customer);
        } else {
            System.out.println("Não há clientes na fila para serem atendidos.");
        }
    }

    public void displayQueues() {
        System.out.println("Clientes prioritários na fila:");
        if (priorityQueue.isEmpty()) {
            System.out.println("A fila prioritária está vazia.");
        } else {
            for (Customer customer : priorityQueue) {
                System.out.println(customer);
            }
        }

        System.out.println("Clientes normais na fila:");
        if (normalQueue.isEmpty()) {
            System.out.println("A fila normal está vazia.");
        } else {
            for (Customer customer : normalQueue) {
                System.out.println(customer);
            }
        }
    }

    public static void main(String[] args) {
        CustomerService cs = new CustomerService();

        cs.addCustomer(new Customer("Maria", 1, true));
        cs.addCustomer(new Customer("João", 2, false));
        cs.addCustomer(new Customer("Ana", 3, true));

        cs.displayQueues();

        cs.serveCustomer();
        cs.serveCustomer();

        cs.displayQueues();

        cs.addCustomer(new Customer("Carlos", 4, false));

        cs.displayQueues();

        cs.serveCustomer();
        cs.serveCustomer();
        cs.serveCustomer();
    }
}
