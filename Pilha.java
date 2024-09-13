package gerenciadordeatendimentoaocliente;

public class Pilha {
    private Node topo;

    public Pilha() {
        this.topo = null;
    }

    // Método para adicionar uma solicitação ao histórico (PUSH)
    public void push(Solicitacao solicitacao) {
        Node novoNode = new Node(solicitacao);
        novoNode.proximo = topo;
        topo = novoNode;
    }

    // Método para remover uma solicitação do histórico (POP)
    public Solicitacao pop() {
        if (isEmpty()) {
            System.out.println("Histórico vazio!");
            return null;
        }
        Solicitacao solicitacao = (Solicitacao) topo.elemento;
        topo = topo.proximo;
        return solicitacao;
    }

    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == null;
    }

    // Método para exibir o histórico de solicitações
    public void mostrarHistorico() {
        if (isEmpty()) {
            System.out.println("Histórico vazio!");
            return;
        }
        Node atual = topo;
        while (atual != null) {
            System.out.println(atual.elemento);
            atual = atual.proximo;
        }
    }
}
    

