package gerenciadordeatendimentoaocliente;

public class Fila {
    private Node frente;
    private Node tras;

    public Fila() {
        this.frente = null;
        this.tras = null;
    }

    // Método para adicionar um cliente à fila
    public void adicionarClienteNaFila(Cliente cliente) { 
        Node novoNode = new Node(cliente);
        if (isEmpty()) {
            frente = tras = novoNode;
        } else {
            tras.proximo = novoNode;
            tras = novoNode;
        }
    }

    // Método para atender o próximo cliente
    public Cliente atenderProximoCliente() {  
        if (isEmpty()) {
            System.out.println("Fila de atendimento vazia!");
            return null;
        }
        Cliente cliente = (Cliente) frente.elemento;
        frente = frente.proximo;
        if (frente == null) {
            tras = null;
        }
        return cliente;
    }

    // Método para verificar se a fila está vazia
    public boolean isEmpty() {
        return frente == null;
    }

    // Método para exibir a fila de atendimento
    public void exibirFila() {  
        if (isEmpty()) {
            System.out.println("Fila de atendimento vazia!");
            return;
        }
        Node atual = frente;
        while (atual != null) {
            System.out.println(atual.elemento);
            atual = atual.proximo;
        }
    }
}
